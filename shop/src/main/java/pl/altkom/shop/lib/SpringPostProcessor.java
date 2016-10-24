package pl.altkom.shop.lib;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import pl.altkom.shop.model.Product;
import pl.altkom.shop.repo.InMemoryProductRepo;

@Component
public class SpringPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		// TODO Auto-generated method stub
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		if (bean instanceof InMemoryProductRepo) {
			InMemoryProductRepo repo = (InMemoryProductRepo) bean;
			repo.insert(new Product());
		}
		System.out.println(beanName);
		return bean;
	}

}
