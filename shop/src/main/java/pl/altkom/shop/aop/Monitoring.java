package pl.altkom.shop.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Monitoring {
	public static enum OpType {
		OPERATIONAL, ANALITYCT, REPORTS
	}

	long maxTime() default 10L;
}
