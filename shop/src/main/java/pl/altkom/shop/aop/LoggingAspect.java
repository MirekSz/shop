package pl.altkom.shop.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	Logger log = Logger.getLogger(LoggingAspect.class);

	@Pointcut("@annotation(pl.altkom.shop.aop.Trace)")
	public void performanceLogableMethod() {
	}

	@Around("@annotation(pl.altkom.shop.aop.Trace)")
	public Object monitpr(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("PRZED");
		Object obj = pjp.proceed();
		return obj;
	}
	// @Around("within(@org.springframework.stereotype.Service *)")
	// public Object trace(ProceedingJoinPoint proceedingJP) throws Throwable {
	// // advice
	// Stopwatch sw = Stopwatch.createStarted();
	// Object obj = proceedingJP.proceed();
	// sw.stop();
	// log.info("++++++  method " + proceedingJP.getSignature().getName() + " "
	// + sw.elapsed(TimeUnit.MILLISECONDS));
	// return obj;
	//
	// }
	//
	// @After("within(pl.vavatech..*)")
	// public void logAfter() {
	// System.out.println("@After:" + new Date());
	// }
	//
	// @Before("execution(* pl.vavatech.auction.blc.service.AuctionService+.*(..))")
	// public void userAdvice() {
	// System.out.println("find my advice before your task.");
	// }
}
