package com.module.dataAccesser.config.mBeanInfo;

import lombok.Data;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.stereotype.Component;

@Data
@Component
public class RMIAttribute {
    protected NotificationPublisher publisher;

    private String mainIP;
    private int mainPort;

    private String service;
    private String connAddress;

    public RMIAttribute(){
        mainIP = "127.0.0.1";
        mainPort = 9090;
        service = "jmx";
        connAddress = "service:jmx:rmi:///jndi/rmi://" + mainIP + ":" + mainPort + "/" + service;
    }


}
