package pl.altkom.shop.aop;

@java.lang.annotation.Target(value = { java.lang.annotation.ElementType.TYPE })
@java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.RUNTIME)
public @interface Monitoring {
	long maxTime() default 100L;
}
