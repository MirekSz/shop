package pl.altkom.shop.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Primary;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.altkom.shop.model.Product;

@Transactional
@Repository
@Primary
public class HibernateProductRepo implements ProductRepo {
	@PersistenceContext
	EntityManager em;

	@Override
	@UserMnagmentAccess
	public Long insert(Product product) {
		em.persist(product);
		return product.getId();
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		Product product = em.find(Product.class, id);
		em.remove(product);

	}

	@Override
	public Product find(Long id) {
		Product product = em.find(Product.class, id);
		return product;
	}

	// @PreAuthorize("authentication.name == #product.createdBy")
	@Override
	public void update(Product product) {
		em.merge(product);

	}

	@SuppressWarnings("unchecked")
	@Override
	@PostFilter("#filtered == authentication.name")
	public List<Product> getAll(String query) {
		if (query == null) {
			return em.createQuery("FROM Product p").getResultList();
		}
		Query dbQuery = em.createNamedQuery("Product.findByName");
		dbQuery.setParameter("name", "%" + query + "%");
		return dbQuery.getResultList();
	}
}
