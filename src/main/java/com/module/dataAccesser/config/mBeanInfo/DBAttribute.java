package com.module.dataAccesser.config.mBeanInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
public class DBAttribute implements DBAttributeMBean {
    protected NotificationPublisher publisher;
    private String DBName;
    private String collectName;

    private String mainIP;
    private int mainPort;
    private String connAddress;
    private List<ClusterIPPort> clusterIPPort;

    public DBAttribute(){
        DBName = "test";
        collectName = "user2";

        mainIP = "127.0.0.1";
        mainPort = 27017;
        clusterIPPort = new ArrayList<>();

        ClusterIPPort ipPort1 = new ClusterIPPort("127.0.0.1", 27018);
        ClusterIPPort ipPort2 = new ClusterIPPort("127.0.0.1", 27019);
        ClusterIPPort ipPort3 = new ClusterIPPort("127.0.0.1", 27020);

        clusterIPPort.add(ipPort1);
        clusterIPPort.add(ipPort2);
        clusterIPPort.add(ipPort3);

        /**
         * "mongodb://localhost:27018
         * "mongodb://localhost:27018,localhost:27019,localhost:27020"
         */
        connAddress = "mongodb://" + mainIP + ":" + mainPort;

    }

    @AllArgsConstructor
    class ClusterIPPort {
        String clusterIp;
        int clusterPort;
    }
}
