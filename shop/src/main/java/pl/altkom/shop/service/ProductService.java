package pl.altkom.shop.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import pl.altkom.shop.model.Product;
import pl.altkom.shop.repo.ProductRepo;

@Service
public class ProductService {
	@Inject
	ProductRepo repo;

	public Product hello(Long id) {
		return repo.find(id);
	}
}
