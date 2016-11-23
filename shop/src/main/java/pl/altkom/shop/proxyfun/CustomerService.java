package pl.altkom.shop.proxyfun;

import java.io.Serializable;
import java.util.List;

import pl.altkom.shop.model.Product;
import pl.altkom.shop.repo.ProductRepo;

public class CustomerService implements Serializable, ProductRepo {
	public Product findByid(Long id) {
		return null;
	}

	@Override
	public Long insert(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Product find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Product> getAll(String query) {
		// TODO Auto-generated method stub
		return null;
	}
}
