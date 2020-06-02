package com.module.mongo.monitor;

import com.module.dataAccesser.config.mBeanInfo.DBAttribute;
import com.module.mongo.Initializer;
import com.mongodb.ConnectionString;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.model.changestream.ChangeStreamDocument;
import com.mongodb.client.model.changestream.FullDocument;
import com.mongodb.reactivestreams.client.*;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

import static java.lang.String.format;
import static java.util.Arrays.asList;

/**
 * https://www.programcreek.com/java-api-examples/?code=mongodb%2Fmongo-java-driver-reactivestreams%2Fmongo-java-driver-reactivestreams-master%2Fexamples%2Fdocumentation%2Fsrc%2FChangeStreamSamples.java#
 */
@Component
public class MongoMonitor {
    @Autowired
    private Initializer initializer;

    public void connectDB() {
        DBAttribute mongoAttr = (DBAttribute)initializer.getMongoAttribute();
        MongoClient mongoClient = MongoClients.create(
                new ConnectionString(mongoAttr.getConnAddress()));
        MongoDatabase database = mongoClient.getDatabase(mongoAttr.getDBName());
        MongoCollection collection = database.getCollection(mongoAttr.getCollectName());
        doCollectionWatch(collection);
    }

    private void doCollectionWatch(MongoCollection collection) {

        try {
             /**
             * example 1
             */
            System.out.println("1. Initial document from the change stream");
            ChangeStreamPublisher<Document> publisher = collection.watch();
            ObservableSubscriber<ChangeStreamDocument<Document>> subscriber =
                    new ObservableSubscriber<>();
            publisher.subscribe(subscriber);

            //Insert a test document into the collection and request a result
            subscribeAndAwait(collection.insertOne(Document.parse("{userName:'lizhuangjie',password:'lzj2577577'}")));
            subscriber.waitForThenCancel(1);

            /**
             * example 2
             */
            System.out.println("2. Document from the change stream, with lookup enabled");
            publisher = collection.watch().fullDocument(FullDocument.UPDATE_LOOKUP);
            subscriber = new ObservableSubscriber<>();
            publisher.subscribe(subscriber);
            subscribeAndAwait(collection.updateOne(Document.parse("{userName:'lizhuangjie'}"),
                                                   Document.parse("{$set:{email:'1984415860@qq.com'}}")));
            subscriber.waitForThenCancel(1);

            /**
             * example 3
             */
            System.out.println("3. Document from the change stream, with lookup enabled, matching 'update' operations only");
            /** Insert some dummy data. */
            subscribeAndAwait(collection.insertMany(asList(Document.parse("{updateMe:1}"), Document.parse("{replaceMe:1}"))));
            /** create match pipeline stage. */
            List<Bson> pipeline = Collections.singletonList(Aggregates.match(
                    Filters.or(Document.parse("{'fullDocument.userName':'lizhuangjie'}"),
                               Filters.in("operationType", asList("update", "replace", "delete")))
            ));
            /** create the change stream cursor with match */
            publisher = collection.watch(pipeline).fullDocument(FullDocument.UPDATE_LOOKUP);
            subscriber = new ObservableSubscriber<>(false);
            publisher.subscribe(subscriber);

            /** update and replace the test document */
            subscribeAndAwait(collection.updateOne(Filters.eq("updateMe", 1), Updates.set("updated", true)));
            subscribeAndAwait(collection.replaceOne(Filters.eq("replaceMe", 1), Document.parse("{replaced:true}")));

            /** delete the test document */
            subscribeAndAwait(collection.deleteOne(Filters.eq("userName", "lizhuangjie")));

            subscriber.waitForThenCancel(3);

            List<ChangeStreamDocument<Document>> results = subscriber.getResults();
            System.out.println(format("Update operationType: %s %n %-20s %s", results.get(0).getUpdateDescription(), "", results.get(0)));
            System.out.println(format("Replace operationType: %s", results.get(1)));
            System.out.println(format("Delete operationType: %s", results.get(2)));

            /**
             * example 4
             */
            System.out.println("4. Document from the change stream including a resume token");
            //Get the resume token from the last document we saw in the previous change stream cursor.
            BsonDocument resumeToken = results.get(2).getResumeToken();
            System.out.println(resumeToken);

            //Pass the resume token to the resume after function to continue the change stream cursor
            publisher = collection.watch().resumeAfter(resumeToken);
            subscriber = new ObservableSubscriber<>();
            publisher.subscribe(subscriber);

            //Insert a test document
            subscribeAndAwait(collection.insertOne(Document.parse("{test:'d'})")));

            subscriber.waitForThenCancel(1);

        } catch (Throwable throwable) {
            throwable.printStackTrace();

        }
    }

    private <T> void subscribeAndAwait(final Publisher<T> publisher) throws Throwable {
        ObservableSubscriber<T> subscriber = new ObservableSubscriber<>(false);
        publisher.subscribe(subscriber);
        subscriber.await();
    }
    

}
