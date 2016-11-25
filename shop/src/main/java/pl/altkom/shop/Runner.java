package pl.altkom.shop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import pl.altkom.shop.repo.SaleDocumentRepo;

public class Runner {

	public static void main(String[] args) {
		// -Dspring.profiles.active="profile,dev"
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		for (int i = 0; i < 5; i++) {
			String encode = bCryptPasswordEncoder.encode("user");
			System.out.println(encode);
		}

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				CoreConfig.class);

		SaleDocumentRepo repo = context.getBean(SaleDocumentRepo.class);
		repo.findAll(new PageRequest(0, 10));
	}

}
