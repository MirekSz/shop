package pl.altkom.shop.service;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.altkom.shop.model.Product;
import pl.altkom.shop.repo.ProductRepo;

@Service
@Transactional
public class ProductService {
	@Inject
	private ProductRepo repo;
	@Inject
	ApplicationEventPublisher publisher;
	@Value("${appName}")
	public String appName;

	public Long insert(Product product) {

		Long id = repo.insert(product);
		ProductAddedEvent event = new ProductAddedEvent(id);
		publisher.publishEvent(event);
		return id;
	}
}
