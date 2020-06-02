package com.module.mongo;

import com.module.dataAccesser.config.mBeanInfo.DBAttributeMBean;
import com.module.dataAccesser.config.mBeanInfo.DBAttribute;
import com.module.dataAccesser.config.mBeanInfo.RMIAttribute;
import com.module.dataAccesser.config.mBeanNotify.MBeanListener;
import com.module.dataAccesser.config.mBeanNotify.Notify;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;

@Data
@Component
public class Initializer {

    private Notify notify;
    private MBeanListener listener;
    private RMIAttribute rmiAttribute;
    private DBAttributeMBean mongoAttribute;

    public Initializer() {
        notify = new Notify();
        listener = new MBeanListener();
        rmiAttribute = new RMIAttribute();
        mongoAttribute = new DBAttribute();
    }

    public void startJMXServer() {
        try{
            MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();


            ObjectName objectName = new ObjectName("jmxBean:name=mongo");
            mBeanServer.registerMBean(mongoAttribute, objectName);

            ObjectName notifyName = new ObjectName("jmxBean:name=notify");
            mBeanServer.registerMBean(notify, notifyName);
            notify.addNotificationListener(listener, null, "i am here");

            LocateRegistry.createRegistry(mongoAttribute.getMainPort());
            JMXServiceURL jmxServiceURL = new JMXServiceURL(rmiAttribute.getConnAddress());

            JMXConnectorServer cs = JMXConnectorServerFactory.newJMXConnectorServer(jmxServiceURL, null, mBeanServer);

            cs.start();

        } catch (Exception e){
            e.printStackTrace();

        }

    }


}
