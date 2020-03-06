package com.target.retail.tracing;

import brave.ScopedSpan;
import brave.Tracer;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 
 * @author atulgupta
 *
 */
@Component
@Aspect
public class TracingAspect {
	
	private static final Logger log = LoggerFactory.getLogger(TracingAspect.class);

	@Value("${spring.application.name:myRetail}")
	private String appName;

	@Autowired
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
			log.info("myRetail : " + object);
		}
		final ScopedSpan span = startNewSpan(serviceName, targetMethodSignature, arguments);
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
