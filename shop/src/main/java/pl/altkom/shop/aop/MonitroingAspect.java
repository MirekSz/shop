package pl.altkom.shop.aop;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.inject.Inject;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MonitroingAspect {
	public static Boolean enalbeTeracing = false;
	static Map<String, Object> cache = new ConcurrentHashMap<String, Object>();
	@Inject
	TraceStorage traceStorage;

	@Around("@within(org.springframework.stereotype.Controller) || @within(org.springframework.stereotype.Service) || @within(org.springframework.stereotype.Repository)")
	public Object superTracer(ProceedingJoinPoint pjp) throws Throwable {
		// if (!enalbeTeracing) {
		// return pjp.proceed();
		// }
		MethodSignature ms = (MethodSignature) pjp.getSignature();
		Method m = ms.getMethod();
		long currentTimeMillis = System.currentTimeMillis();
		traceStorage.incLevel();
		Object obj = pjp.proceed();
		long end = System.currentTimeMillis() - currentTimeMillis;
		traceStorage.add("CZAS " + m.getDeclaringClass().getSimpleName() + "/" + m.getName() + ":" + end);
		traceStorage.decLevel();
		return obj;
	}

	@Around("@annotation(pl.altkom.shop.aop.Monitoring)")
	public Object monitpr(ProceedingJoinPoint pjp) throws Throwable {
		MethodSignature ms = (MethodSignature) pjp.getSignature();
		Method m = ms.getMethod();
		long max = m.getAnnotation(Monitoring.class).maxTime();
		long currentTimeMillis = System.currentTimeMillis();
		Object obj = pjp.proceed();
		long end = System.currentTimeMillis() - currentTimeMillis;
		if (end > max) {
			System.err.println("CZAS " + end);
		}
		return obj;
	}

	@Around("@annotation(pl.altkom.shop.aop.ResponseCache)")
	public Object cache(ProceedingJoinPoint pjp) throws Throwable {
		MethodSignature ms = (MethodSignature) pjp.getSignature();
		Method m = ms.getMethod();
		Object[] args = pjp.getArgs();

		String key = m.toString();

		Object object = cache.get(key);
		if (object == null) {
			Object obj = pjp.proceed();
			cache.put(key, obj);
		}
		return cache.get(key);
	}
}
