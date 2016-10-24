package pl.altkom.shop.repo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import pl.altkom.shop.model.Product;

@Repository
public class InMemoryProductRepo implements ProductRepo {
	Map<Long, Product> products = new HashMap<Long, Product>();

	@Override
	public Long insert(Product product) {
		product.setId(products.size() + 1L);

		products.put(product.getId(), product);

		return product.getId();
	}
}
