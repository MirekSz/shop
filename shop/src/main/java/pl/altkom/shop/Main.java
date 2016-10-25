package pl.altkom.shop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import pl.altkom.shop.service.ProductService;

public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CoreConfig.class);
		ProductService productService = context.getBean(ProductService.class);
		String encode = new BCryptPasswordEncoder().encode("user");
		System.out.println(encode);
		// productService.insert(new Product());
		// System.out.println(productService.sample.getFilename());
		//
		// Properties properties = new Properties();
		// properties.load(productService.sample.getInputStream());
	}
}
