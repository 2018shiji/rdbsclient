package com.module.mysql.datasswitch;

import java.util.ArrayList;
import java.util.List;

public class DDataSourceContextHolder {
    private static final ThreadLocal<String> contextHolder = new ThreadLocal<String>();

    private static List<String> dataSourceIds = new ArrayList<>();

    public static void setDataSourceType(String type){
        System.out.println("切换至" + type + "数据源");
        contextHolder.set(type);
    }

    public static String getDataSourceType() {
        return contextHolder.get();
    }

    public static void clearDataSourceType() {
        contextHolder.remove();
    }

    public static void addDataSourceId(String id){
        dataSourceIds.add(id);
    }

    public static boolean isContainDS(String dsId){
        return dataSourceIds.contains(dsId);
    }
}
