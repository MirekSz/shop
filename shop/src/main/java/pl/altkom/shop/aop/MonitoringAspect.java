package pl.altkom.shop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MonitoringAspect {

	@Around("@within(pl.altkom.shop.aop.Monitoring)")
	public Object monit(ProceedingJoinPoint pjp) throws Throwable {

		long time = System.currentTimeMillis();

		// Object obj = pjp.proceed();
		String args = "";
		for (Object arg : pjp.getArgs()) {
			args += arg;
		}
		System.out.println(this.getClass().getSimpleName() + ": "
				+ pjp.toString() + " - " + (System.currentTimeMillis() - time)
				+ " - " + args);

		return "s";
	}
}
