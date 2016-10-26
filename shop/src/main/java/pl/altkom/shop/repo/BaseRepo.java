package pl.altkom.shop.repo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

public abstract class BaseRepo {
	@PersistenceContext
	EntityManager em;
	@PersistenceUnit
	EntityManagerFactory emf;

	protected Object tx(Runn runn) {
		EntityManager createEntityManager = emf.createEntityManager();
		EntityTransaction transaction = createEntityManager.getTransaction();
		transaction.begin();
		try {
			return runn.run(createEntityManager);
		} catch (Exception e) {
			transaction.rollback();
			throw new RuntimeException(e);
		} finally {
			if (transaction.isActive())
				transaction.commit();
		}
	}

	public static interface Runn {
		Object run(EntityManager em);
	}
}
