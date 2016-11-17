package pl.altkom.shop.repo;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.altkom.shop.aop.Monitoring;
import pl.altkom.shop.model.Product;

@Repository
@Monitoring
@Transactional
public class HibernateProductRepository extends BaseRepo implements ProductRepo {

	@Override
	public Long insert(Product product) {
		em.persist(product);

		return product.getId();
	}

	@Override
	public Integer count() {
		return (Integer) em.createQuery("select count(prod) from Product as prod").getSingleResult();

	}

	@Override
	public List<Product> getAll(String query) {

		if (query == null) {
			return em.createQuery("from Product").getResultList();
		} else {
			return em.createQuery("from Product where name like :query").setParameter("query", "%" + query + "%")
					.getResultList();
		}

	}

	@Override
	public void delete(Long id) {
		Product product = em.find(Product.class, id);

		em.remove(product);
	}

	@Override
	public Product find(Long id) {
		return em.find(Product.class, id);
	}

	@Override
	public void update(Product product) {

		em.merge(product);

	}

	@Override
	public void save(Object entity) {

		em.persist(entity);

	}

}
