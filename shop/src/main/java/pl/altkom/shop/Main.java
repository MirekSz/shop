package pl.altkom.shop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.altkom.shop.service.SaleDocumentService;

public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				CoreConfig.class);
		context.getBean(SaleDocumentService.class).count();
		// SaleDocumentService service = context
		// .getBean(SaleDocumentService.class);
		// DocumentRequest documentRequest = new DocumentRequest();
		// documentRequest.items.add(new Item(9L, 3));
		// documentRequest.items.add(new Item(10L, 5));

		// System.out.println(productService.sample.getFilename());
		//
		// Properties properties = new Properties();
		// properties.load(productService.sample.getInputStream());
	}
}
