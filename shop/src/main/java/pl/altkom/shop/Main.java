package pl.altkom.shop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.altkom.shop.model.Product;
import pl.altkom.shop.service.ProductService;

public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				CoreConfig.class);
		ProductService productService = context.getBean(ProductService.class);
		productService.insert(new Product());

	}
}
