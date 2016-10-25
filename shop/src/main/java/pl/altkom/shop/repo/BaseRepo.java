package pl.altkom.shop.repo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

public class BaseRepo {
	@PersistenceContext
	EntityManager em;
	@PersistenceUnit
	EntityManagerFactory emf;

	protected void tx(Runn runn) {
		EntityManager createEntityManager = emf.createEntityManager();
		createEntityManager.getTransaction().begin();
		runn.run(createEntityManager);
		createEntityManager.getTransaction().commit();
	}

	public static interface Runn {
		void run(EntityManager em);
	}
}
