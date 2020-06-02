package com.module.mongo.monitor;

import com.module.dataAccesser.config.mBeanInfo.DBAttribute;
import com.module.mongo.Initializer;
import com.module.mongo.pojo.User;
import com.mongodb.client.model.changestream.ChangeStreamDocument;
import com.mongodb.client.model.changestream.OperationType;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ChangeStreamOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.messaging.*;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.time.Duration;
import java.util.Objects;

/**
 * https://www.linzepeng.com/2019/07/19/mongo-change-stream/
 * https://github.com/ZeponLin/change-stream-demo
 */
@Component
public class ChangeStreamListener {
    @Autowired
    private Initializer initializer;
    private final MessageListenerContainer listenerContainer;

    public ChangeStreamListener(MongoTemplate template) {
        listenerContainer = new DefaultMessageListenerContainer(template);
        init();
    }

    private void init() { listenerContainer.start();}

    @PreDestroy
    private void destroy() {
        if(listenerContainer != null && listenerContainer.isRunning())
            listenerContainer.stop();
    }

    public void registerListener() {
        registerListener("user", getCollectionListener(), User.class);
    }

    private <T> void registerListener(String collectionName,
                                      MessageListener<ChangeStreamDocument<Document>, T>listener,
                                      Class<T> bodyType) {
        ChangeStreamOptions changeStreamOptions = ChangeStreamOptions.builder().returnFullDocumentOnUpdate().build();
        registerListener(collectionName, listener, bodyType, changeStreamOptions);
    }

    private <T> void registerListener(String collectionName,
                                      MessageListener<ChangeStreamDocument<Document>, T>listener,
                                      Class<T> bodyType,
                                      ChangeStreamOptions changeStreamOptions) {
        ChangeStreamRequest.ChangeStreamRequestOptions options =
                new ChangeStreamRequest.ChangeStreamRequestOptions(
                        ((DBAttribute)initializer.getMongoAttribute()).getDBName(), collectionName, changeStreamOptions);
        Subscription subscription = listenerContainer.register(new ChangeStreamRequest<>(listener, options), bodyType);

        try{
            if(subscription.await(Duration.ofSeconds(10))){
                System.out.println("collection listener register success!");
            } else{
                System.out.println("collection listener register fail or time out");
            }
        } catch (InterruptedException e){
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    private MessageListener<ChangeStreamDocument<Document>, User> getCollectionListener() {
        return createMessageListener(new CallbackChangeStream<User>() {
            @Override
            public void insert(ChangeStreamDocument<Document> raw, User body) {
                System.out.println("new user is inserted, content is " + body.toString());
            }

            @Override
            public void update(ChangeStreamDocument<Document> raw, User body) {
                System.out.println("user is updated, content is " + body.toString());
            }

            @Override
            public void delete(ChangeStreamDocument<Document> raw, User body) {
                System.out.println("user is delete, content is " + body.toString());
            }
        });
    }

    private <T> MessageListener<ChangeStreamDocument<Document>, T> createMessageListener(CallbackChangeStream<T> callback) {
        return listenMsg -> {
            ChangeStreamDocument<Document> raw = listenMsg.getRaw();
            OperationType operationType = Objects.requireNonNull(raw).getOperationType();
            switch(operationType){
                case INSERT :
                    callback.insert(raw, listenMsg.getBody());
                    break;
                case REPLACE:
                case UPDATE:
                    callback.update(raw, listenMsg.getBody());
                    break;
                case DELETE:
                    callback.delete(raw, listenMsg.getBody());
                    break;
                default:
                    break;
            }
        };
    }
}
