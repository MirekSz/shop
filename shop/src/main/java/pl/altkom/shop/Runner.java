package pl.altkom.shop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.altkom.shop.service.ProductService;

public class Runner {

	public static void main(String[] args) {
		// -Dspring.profiles.active="profile,dev"
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				CoreConfig.class);

		ProductService productService = context.getBean(ProductService.class);
		productService.hello();
		productService.hello();
		productService.hello();

	}

}
