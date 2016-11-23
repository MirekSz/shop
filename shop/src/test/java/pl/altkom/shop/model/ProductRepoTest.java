package pl.altkom.shop.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import pl.altkom.shop.CoreConfig;
import pl.altkom.shop.repo.ProductRepo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CoreConfig.class)
@Rollback
@Transactional
@ActiveProfiles("test")
public class ProductRepoTest {
	@Inject
	ProductRepo repo;

	@Test
	public void shoulAddProduct() throws Exception {
		// UsernamePasswordAuthenticationToken authentication = new
		// UsernamePasswordAuthenticationToken("user", "user");
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken("admin", "admin");
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// given
		Product product = new Product("rower", "2", 0, BigDecimal.TEN);
		int beforeInsertSize = repo.getAll(null).size();

		// when
		repo.insert(product);

		// then
		assertThat(repo.getAll(null).size()).isGreaterThan(beforeInsertSize);
	}
}
