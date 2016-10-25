package pl.altkom.shop.repo;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import pl.altkom.shop.aop.Trace;
import pl.altkom.shop.model.Product;

@Repository
public class HibernateProductRepository extends BaseRepo implements ProductRepo {
	@PersistenceContext
	EntityManager em;

	@PostConstruct
	public void init() {
		// insert(new Product("Rower", "Bardzo dobry rower", 12,
		// BigDecimal.TEN));
		// insert(new Product("Sanki", "Sanki zimowe", 123,
		// BigDecimal.valueOf(12.45)));
	}

	@Override
	@Trace
	public Long insert(Product product) {
		em.persist(product);
		return product.getId();
	}

	@Override
	public Integer count() {
		return null;
	}

	@Override
	public List<Product> getAll() {
		return em.createQuery("FROM Product").getResultList();
	}

	@Override
	public List<Product> getAll(String query) {
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

}
