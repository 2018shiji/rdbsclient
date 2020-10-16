package com.module.dataaccesser.core.trace;

import ch.qos.logback.classic.helpers.MDCInsertingServletFilter;
import org.slf4j.MDC;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MdcServletFilter extends MDCInsertingServletFilter {
    private static final String HEADER_FOR_TRACE_ID = "X-TRACE-ID";


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (!(request instanceof HttpServletRequest))
            return;
        /**如果前端传递了唯一标识，拿出来直接用*/
        String traceId = ((HttpServletRequest) request).getHeader(HEADER_FOR_TRACE_ID);

        if (StringUtils.isEmpty(traceId))
            traceId = UUIDShort.generate();

        MyThreadContext.setTraceId(traceId);
        MDC.put(MyThreadContext.MDC_TRACE_ID, traceId);
        try {
            super.doFilter(request, response, chain);
        } finally {
            MDC.remove(MyThreadContext.MDC_TRACE_ID);
            MyThreadContext.removeTraceId();
        }

    }
}
