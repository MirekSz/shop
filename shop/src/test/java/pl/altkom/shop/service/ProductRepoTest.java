package pl.altkom.shop.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.junit.Test;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import pl.altkom.shop.BaseTest;
import pl.altkom.shop.model.Product;
import pl.altkom.shop.repo.ProductRepo;

public class ProductRepoTest extends BaseTest {
	@Inject
	ProductRepo repo;

	@Test
	public void shoulAddProduct() throws Exception {
		// UsernamePasswordAuthenticationToken authentication = new
		// UsernamePasswordAuthenticationToken("user", "user");
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken("admin", "admin");
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// given
		Product product = new Product("rower", "2", 10, BigDecimal.TEN);
		int beforeInsertSize = repo.getAll(null).size();

		// when
		repo.insert(product);

		// then
		assertThat(repo.getAll(null).size()).isGreaterThan(beforeInsertSize);
	}
}
