package com.target.retail.tracing;

import brave.ScopedSpan;
import brave.Tracer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TracingAspect {
    @Value("${spring.application.name:myRetail}")
    private String appName;


//    @Inject
    private Tracer tracer;


    private ScopedSpan startNewSpan(String serviceName, String methodSignature, Object... objects) {
        // Span name contains class and method name
        final StringBuilder spanNameBuilder = new StringBuilder("/").append(methodSignature);

        final ScopedSpan span = tracer.startScopedSpan(spanNameBuilder.toString());
        if (span != null) {
            span.tag("peer.service", serviceName);
        }

        return span;
    }

    private void addErrorDetailsToSpan(ScopedSpan span, Throwable throwable) {
        if (span == null) {
            return;
        }

        span.error(throwable);
    }

    private void closeSpan(ScopedSpan span) {
        if (span == null) {
            return;
        }

        span.finish();
    }

    @Around("execution(public * com.target..*(..))")
    public Object traceAllMethodCalls(ProceedingJoinPoint pJoinPoint) throws Throwable {
        final MethodSignature methodSignature = (MethodSignature) pJoinPoint.getSignature();
        final String serviceName = appName;

        final String targetMethodSignature = methodSignature.toShortString();
        Object[] arguments = pJoinPoint.getArgs();
        for (Object object : arguments) {
            System.out.println("myRetail : " + object);
        }
        final ScopedSpan span = startNewSpan(serviceName, targetMethodSignature,arguments);
        try {
            return pJoinPoint.proceed();
        } catch (Exception exception) {
            addErrorDetailsToSpan(span, exception);
            throw exception;
        } finally {
            closeSpan(span);
        }
    }
}
