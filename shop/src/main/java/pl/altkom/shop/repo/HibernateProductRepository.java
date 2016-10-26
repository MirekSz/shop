package pl.altkom.shop.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import pl.altkom.shop.aop.Monitoring;
import pl.altkom.shop.model.Product;

@Repository
@Monitoring
public class HibernateProductRepository extends BaseRepo implements ProductRepo {

	@Override
	public Long insert(Product product) {

		tx((em) -> {

			em.persist(product);

			return null;
		});

		return product.getId();
	}

	@Override
	public Integer count() {
		Long reesult = ((Long) tx((em) -> {

			return em.createQuery("select count(prod) from Product as prod")
					.getSingleResult();

		}));
		return reesult.intValue();
	}

	@Override
	public List<Product> getAll(String query) {

		if (query == null) {
			return em.createQuery("from Product").getResultList();
		} else {
			return em.createQuery("from Product where name like :query")
					.setParameter("query", "%" + query + "%").getResultList();
		}

	}

	@Override
	public void delete(Long id) {
		tx((em) -> {
			Product product = em.find(Product.class, id);

			em.remove(product);

			return null;

		});

	}

	@Override
	public Product find(Long id) {
		return (Product) tx((em) -> {
			return em.getReference(Product.class, id);
		});
	}

	@Override
	public void update(Product product) {
		tx((em) -> {

			em.merge(product);

			return null;

		});

	}

	@Override
	public void save(Object entity) {
		tx((em) -> {

			em.persist(entity);

			return null;

		});

	}

}
