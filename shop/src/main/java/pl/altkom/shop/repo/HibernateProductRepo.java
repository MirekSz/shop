package pl.altkom.shop.repo;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import pl.altkom.shop.model.Product;

@Repository
@Primary
public class HibernateProductRepo implements ProductRepo {
	@Inject
	EntityManagerFactory emf;

	@Override
	public Long insert(Product product) {
		run((em) -> {
			em.persist(product);
			return product.getId();
		});
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		run((em) -> {
			Product product = em.find(Product.class, id);
			em.remove(product);
			return null;
		});

	}

	@Override
	public Product find(Long id) {
		return (Product) run((em) -> {
			Product product = em.find(Product.class, id);
			return product;
		});
	}

	@Override
	public void update(Product product) {
		run((em) -> {
			em.merge(product);
			return null;
		});

	}

	interface Runner {
		Object run(EntityManager em);
	}

	private Object run(Runner runner) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		Object object = runner.run(em);
		transaction.commit();
		return object;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> getAll(String query) {
		return (List<Product>) run((em) -> {
			if (query == null) {
				return em.createQuery("FROM Product p").getResultList();
			}
			Query dbQuery = em.createNamedQuery("Product.findByName");
			dbQuery.setParameter("name", "%" + query + "%");
			return dbQuery.getResultList();
		});

	}
}
