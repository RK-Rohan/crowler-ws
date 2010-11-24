package it.stasbranger.crowlerws.ws.dao;

import it.stasbranger.crowlerws.ws.domain.Ricerca;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Transactional;

/**
 * A data access object (DAO) providing persistence and search support for
 * Ricerca entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see it.stasbranger.crowlerws.ws.domain.Ricerca
 * @author MyEclipse Persistence Tools
 */

public class RicercaDAO extends JpaDaoSupport implements IRicercaDAO {
	// property constants
	public static final String COSA = "cosa";
	public static final String DOVE = "dove";

	/**
	 * Perform an initial save of a previously unsaved Ricerca entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * <p>
	 * User-managed Spring transaction example:
	 * 
	 * <pre>
	 * TransactionStatus txn = txManager
	 * 		.getTransaction(new DefaultTransactionDefinition());
	 * RicercaDAO.save(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            Ricerca entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	@Transactional
	public void save(Ricerca entity) {
		logger.info("saving Ricerca instance");
		try {
			getJpaTemplate().persist(entity);
			logger.info("save successful");
		} catch (RuntimeException re) {
			logger.error("save failed", re);
			throw re;
		}
	}

	/**
	 * Delete a persistent Ricerca entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * <p>
	 * User-managed Spring transaction example:
	 * 
	 * <pre>
	 * TransactionStatus txn = txManager
	 * 		.getTransaction(new DefaultTransactionDefinition());
	 * RicercaDAO.delete(entity);
	 * txManager.commit(txn);
	 * entity = null;
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            Ricerca entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	@Transactional
	public void delete(Ricerca entity) {
		logger.info("deleting Ricerca instance");
		try {
			entity = getJpaTemplate().getReference(Ricerca.class,
					entity.getId());
			getJpaTemplate().remove(entity);
			logger.info("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved Ricerca entity and return it or a copy of it
	 * to the sender. A copy of the Ricerca entity parameter is returned when
	 * the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * <p>
	 * User-managed Spring transaction example:
	 * 
	 * <pre>
	 * TransactionStatus txn = txManager
	 * 		.getTransaction(new DefaultTransactionDefinition());
	 * entity = RicercaDAO.update(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            Ricerca entity to update
	 * @return Ricerca the persisted Ricerca entity instance, may not be the
	 *         same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	@Transactional
	public Ricerca update(Ricerca entity) {
		logger.info("updating Ricerca instance");
		try {
			Ricerca result = getJpaTemplate().merge(entity);
			logger.info("update successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("update failed", re);
			throw re;
		}
	}

	public Ricerca findById(Integer id) {
		logger.info("finding Ricerca instance with id: " + id);
		try {
			Ricerca instance = getJpaTemplate().find(Ricerca.class, id);
			return instance;
		} catch (RuntimeException re) {
			logger.error("find failed", re);
			throw re;
		}
	}

	/**
	 * Find all Ricerca entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Ricerca property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            number of results to return.
	 * @return List<Ricerca> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Ricerca> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		logger.info("finding Ricerca instance with property: " + propertyName
				+ ", value: " + value);
		try {
			final String queryString = "select model from Ricerca model where model."
					+ propertyName + "= :propertyValue";
			return getJpaTemplate().executeFind(new JpaCallback() {
				public Object doInJpa(EntityManager em)
						throws PersistenceException {
					Query query = em.createQuery(queryString);
					query.setParameter("propertyValue", value);
					if (rowStartIdxAndCount != null
							&& rowStartIdxAndCount.length > 0) {
						int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
						if (rowStartIdx > 0) {
							query.setFirstResult(rowStartIdx);
						}

						if (rowStartIdxAndCount.length > 1) {
							int rowCount = Math.max(0, rowStartIdxAndCount[1]);
							if (rowCount > 0) {
								query.setMaxResults(rowCount);
							}
						}
					}
					return query.getResultList();
				}
			});
		} catch (RuntimeException re) {
			logger.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Ricerca> findByCosa(Object cosa, int... rowStartIdxAndCount) {
		return findByProperty(COSA, cosa, rowStartIdxAndCount);
	}

	public List<Ricerca> findByDove(Object dove, int... rowStartIdxAndCount) {
		return findByProperty(DOVE, dove, rowStartIdxAndCount);
	}
	
	@SuppressWarnings("unchecked")
	public List<Ricerca> findLastRicerca() {
		return getJpaTemplate().findByNamedQuery("lastRicerca");
	}
	
	@SuppressWarnings("unchecked")
	public List<Ricerca> findByCosaDove(Object cosa, Object dove, int...rowStartIdxAndCount) {
		return getJpaTemplate().findByNamedQuery("findCosaDove", cosa, dove);
	}

	/**
	 * Find all Ricerca entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Ricerca> all Ricerca entities
	 */
	@SuppressWarnings("unchecked")
	public List<Ricerca> findAll(final int... rowStartIdxAndCount) {
		logger.info("finding all Ricerca instances");
		try {
			final String queryString = "select model from Ricerca model";
			return getJpaTemplate().executeFind(new JpaCallback() {
				public Object doInJpa(EntityManager em)
						throws PersistenceException {
					Query query = em.createQuery(queryString);
					if (rowStartIdxAndCount != null
							&& rowStartIdxAndCount.length > 0) {
						int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
						if (rowStartIdx > 0) {
							query.setFirstResult(rowStartIdx);
						}

						if (rowStartIdxAndCount.length > 1) {
							int rowCount = Math.max(0, rowStartIdxAndCount[1]);
							if (rowCount > 0) {
								query.setMaxResults(rowCount);
							}
						}
					}
					return query.getResultList();
				}
			});
		} catch (RuntimeException re) {
			logger.error("find all failed", re);
			throw re;
		}
	}

	public static IRicercaDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IRicercaDAO) ctx.getBean("RicercaDAO");
	}
}