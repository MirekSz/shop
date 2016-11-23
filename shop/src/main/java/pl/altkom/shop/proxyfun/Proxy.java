package pl.altkom.shop.proxyfun;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;

public class Proxy {

	public static void main(String[] args) {
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.setTarget(new CustomerService());
		proxyFactory.setProxyTargetClass(false);
		proxyFactory.addAdvice(new MethodInterceptor() {

			@Override
			public Object invoke(MethodInvocation invocation) throws Throwable {
				return "sadsa";
			}
		});

		CustomerService proxy = (CustomerService) proxyFactory.getProxy();
		System.out.println(proxy.findByid(1L));

	}

}
