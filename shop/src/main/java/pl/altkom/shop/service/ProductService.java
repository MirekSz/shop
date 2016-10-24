package pl.altkom.shop.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import pl.altkom.shop.model.Product;
import pl.altkom.shop.repo.ProductRepo;

@Service
public class ProductService {
	@Inject
	private ProductRepo repo;

	public Long insert(Product product) {
		return repo.insert(product);
	}
}
