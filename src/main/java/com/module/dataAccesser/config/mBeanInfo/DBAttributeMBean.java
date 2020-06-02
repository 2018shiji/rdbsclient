package com.module.dataAccesser.config.mBeanInfo;

import org.springframework.stereotype.Component;


@Component
public interface DBAttributeMBean {

    String getMainIP();
    void setMainIP(String mainIP);

    int getMainPort();
    void setMainPort(int port);

    String getConnAddress();
    void setConnAddress(String connAddress);

}
