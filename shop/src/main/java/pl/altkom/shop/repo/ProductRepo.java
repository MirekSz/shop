package pl.altkom.shop.repo;

import java.util.List;

import pl.altkom.shop.model.Product;

public interface ProductRepo {

	public Long insert(Product product);

	Long count();

	public List<Product> getAll();

	public void delete(Long id);

	public Product find(Long id);

	public void update(Product product);

	public void save(Object entity);
}
