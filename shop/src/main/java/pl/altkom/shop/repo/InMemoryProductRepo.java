package pl.altkom.shop.repo;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import pl.altkom.shop.model.Product;

@Repository
public class InMemoryProductRepo implements ProductRepo {
	Map<Long, Product> products = new HashMap<Long, Product>();

	@PostConstruct
	public void init() {
		insert(new Product());
		insert(new Product());
	}

	@Override
	public Long insert(Product product) {
		product.setId(products.size() + 1L);

		products.put(product.getId(), product);

		return product.getId();
	}

	@Override
	public Integer count() {
		return products.size();
	}
}
