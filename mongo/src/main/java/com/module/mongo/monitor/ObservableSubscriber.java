package com.module.mongo.monitor;

import com.mongodb.MongoTimeoutException;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class ObservableSubscriber <T> implements Subscriber<T> {
    private final CountDownLatch latch;
    private final List<T> results = new ArrayList<>();
    private final boolean printResults;

    private volatile int minNumOfResults;
    private volatile int counter;
    private volatile Subscription subscription;
    private volatile Throwable error;

    public ObservableSubscriber(){this(true);}

    public ObservableSubscriber(final boolean printResults){
        this.printResults = printResults;
        this.latch = new CountDownLatch(1);
    }

    @Override
    public void onSubscribe(Subscription s) {

    }

    @Override
    public void onNext(T t) {

    }

    @Override
    public void onError(Throwable t) {

    }

    @Override
    public void onComplete() {

    }

    public List<T> getResults() { return results;}

    public void await() throws Throwable {
        if(!latch.await(10, TimeUnit.SECONDS))
            throw new MongoTimeoutException("Publisher timed out");
        if(error != null)
            throw error;
    }

    public void waitForThenCancel(final int minNumOfResults) throws Throwable {
        this.minNumOfResults = minNumOfResults;
        if(minNumOfResults > counter)
            await();
        subscription.cancel();
    }
}
