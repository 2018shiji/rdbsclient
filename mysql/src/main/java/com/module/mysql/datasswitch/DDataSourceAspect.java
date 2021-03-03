package com.module.mysql.datasswitch;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.hibernate.engine.spi.SessionImplementor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Aspect
@Order(-1)
@Component
public class DDataSourceAspect {

    @PersistenceContext
    private EntityManager entityManager;

    @Before(value="@annotation(iDataSource)")
    public void changeDataSource(JoinPoint point, IDataSource iDataSource) throws Throwable {
        String dsId = iDataSource.value();
        if (DDataSourceContextHolder.isContainDS(dsId)) {
            DDataSourceContextHolder.setDataSourceType(dsId);
        } else {
            System.out.println("数据源" + dsId + "不存在，使用默认数据源 >" + point.getSignature());
            DDataSourceContextHolder.setDataSourceType("PPDaiDB");
        }
    }

    @After("@annotation(iDataSource)")
    public void restoreDataSource(JoinPoint point, IDataSource iDataSource) {
        //方法执行完毕之后，销毁当前数据源信息，进行垃圾回收。
        DDataSourceContextHolder.clearDataSourceType();
        SessionImplementor session = entityManager.unwrap(SessionImplementor.class);
        //最关键的一句代码， 手动断开连接，不用重新设置 ，会自动重新设置连接。
        session.disconnect();
    }
}
