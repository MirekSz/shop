package pl.altkom.shop.aop;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MonitroingAspect {
	static Map<String, Object> cache = new ConcurrentHashMap<String, Object>();

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
