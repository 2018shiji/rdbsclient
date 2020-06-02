package com.module.dataAccesser.config.mBeanNotify;

import org.springframework.stereotype.Component;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;


/**
 * mBean event publisher
 */
@Component
public class Notify extends NotificationBroadcasterSupport
        implements NotifyMBean {
    private int seq = 0;

    @Override
    public void createNotify() {
        Notification notify = new Notification(
                "broadcaster.notify", this, ++seq, System.currentTimeMillis(), "broadcaster");

        sendNotification(notify);
    }

}
