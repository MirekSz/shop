package pl.altkom.shop.service;

import java.util.List;
import java.util.Properties;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import pl.altkom.shop.model.Product;
import pl.altkom.shop.repo.ProductRepo;

@Service
public class ProductService {
	@Inject
	private ProductRepo repo;
	@Inject
	ApplicationEventPublisher publisher;
	@Value("${appName}")
	public String appName;
	@Value("${classpath:application.properties}")
	public Properties sample;

	@Secured("ROLE_ADMIN")
	public Long insert(Product product) {

		Long id = repo.insert(product);
		ProductAddedEvent event = new ProductAddedEvent(id);
		publisher.publishEvent(event);
		return id;
	}

	public void update(Product product) {
		repo.update(product);
	}

	public void delete(Long id) {
		repo.delete(id);
	}

	public Product find(Long id) {
		return repo.find(id);
	}

	public List<Product> getAll(String query) {
		return repo.getAll(query);
	}
}
