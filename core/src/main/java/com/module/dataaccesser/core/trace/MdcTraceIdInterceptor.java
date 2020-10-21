package com.module.dataaccesser.core.trace;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.util.Map;

/**
 * logback全局日志交易id拦截器
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
public class MdcTraceIdInterceptor implements MethodInterceptor {
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        if(MDC.get(MyThreadContext.MDC_TRACE_ID) != null)
            return methodInvocation.proceed();

        try {
            String traceId = UUIDShort.generate();
            MyThreadContext.setTraceId(traceId);
            MDC.put(MyThreadContext.MDC_TRACE_ID,traceId);
            return methodInvocation.proceed();
        } catch (Throwable e) {
            log.warn("MdcTraceIdMethodInteceptor error", e.getMessage());
            throw e;
        } finally {
            MDC.remove(MyThreadContext.MDC_TRACE_ID);
            MyThreadContext.removeTraceId();
        }

    }
}
