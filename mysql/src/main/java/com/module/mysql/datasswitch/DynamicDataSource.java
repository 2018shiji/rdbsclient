package com.module.mysql.datasswitch;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        String dataSource = DDataSourceContextHolder.getDataSourceType();
        System.out.println("当前数据源是：" + dataSource);
        return dataSource;
    }
}
