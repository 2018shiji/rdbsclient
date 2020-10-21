package com.module.dataaccesser.postgresql.logconfig;

import com.module.dataaccesser.core.trace.MdcTraceIdInterceptor;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @descriptionlogback全局日志交易id拦截器配置 <br/>
 *  主要针对例如 定时任务 MQ等 非HTTP发起的请求没有traceId 配置需要拦截过滤的地址使用 <br/>
 *  配置demo ：<br/>
 *  log.traceId.pointcutExpression=execution(* com.test.service.rabbitmq..*.*(..)) || execution(* com.test.job..*.*(..))
 */
@Configuration
@ConditionalOnProperty(name = "log.traceId.pointcutExpression")
public class MdcTraceIdConfigure {
    @Value("${log.traceId.pointcutExpression}")
    private String POINTCUT_EXPRESSION;

    @Bean("MdcTraceIdInterceptor")
    public MdcTraceIdInterceptor mdcTraceIdInterceptor() {
        return new MdcTraceIdInterceptor();
    }

    @Bean("MdcTraceIdAdvisor")
    public Advisor MdcTraceIdAdvisor(MdcTraceIdInterceptor mdcTraceIdMethodInterceptor) {
        AspectJExpressionPointcut cut = new AspectJExpressionPointcut();
        cut.setExpression(POINTCUT_EXPRESSION);
        Advisor advisor = new DefaultPointcutAdvisor(cut, mdcTraceIdMethodInterceptor);
        return advisor;
    }

}
