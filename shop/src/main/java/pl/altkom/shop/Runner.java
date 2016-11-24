package pl.altkom.shop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.PageRequest;

import pl.altkom.shop.repo.SaleDocumentRepo;

public class Runner {

	public static void main(String[] args) {
		// -Dspring.profiles.active="profile,dev"
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				CoreConfig.class);

		SaleDocumentRepo repo = context.getBean(SaleDocumentRepo.class);
		repo.findAll(new PageRequest(0, 10));
	}

}
