package pl.altkom.shop.repo;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import org.springframework.stereotype.Repository;

import pl.altkom.shop.model.Product;

@Repository
public class HibernateProductRepository implements ProductRepo {
	@PersistenceContext
	EntityManager em;
	@PersistenceUnit
	EntityManagerFactory emf;

	@PostConstruct
	public void init() {
		insert(new Product("Rower", "Bardzo dobry rower", 12, BigDecimal.TEN));
		insert(new Product("Sanki", "Sanki zimowe", 123, BigDecimal.valueOf(12.45)));
	}

	@Override
	public Long insert(Product product) {
		// em.persist(product);
		return product.getId();
	}

	@Override
	public Integer count() {
		return null;
	}

	@Override
	public List<Product> getAll() {
		return null;
	}

}
