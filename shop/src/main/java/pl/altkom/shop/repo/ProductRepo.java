package pl.altkom.shop.repo;

import java.util.List;

import pl.altkom.shop.model.Product;

public interface ProductRepo {

	public Long insert(Product product);

	Integer count();

	public List<Product> getAll();
}
