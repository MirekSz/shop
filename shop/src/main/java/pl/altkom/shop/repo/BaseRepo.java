package pl.altkom.shop.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class BaseRepo {
	@PersistenceContext
	protected EntityManager em;

	public static interface Runn {
		Object run(EntityManager em);
	}
}
