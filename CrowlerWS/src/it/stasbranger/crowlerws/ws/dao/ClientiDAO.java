package it.stasbranger.crowlerws.ws.dao;

import it.stasbranger.crowlerws.ws.domain.Clienti;
import it.stasbranger.crowlerws.ws.domain.Ricerca;

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
 * Clienti entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see it.stasbranger.crowlerws.ws.domain.Clienti
 * @author MyEclipse Persistence Tools
 */

public class ClientiDAO extends JpaDaoSupport implements IClientiDAO {
	// property constants
	public static final String ID_RICERCA = "idRicerca";
	public static final String RAGIONE_SOCIALE = "ragioneSociale";
	public static final String CATEGORIA = "categoria";
	public static final String PROVINCIA = "provincia";
	public static final String CITTA = "citta";
	public static final String TELEFONO = "telefono";
	public static final String FAX = "fax";
	public static final String EMAIL = "email";
	public static final String INDIRIZZO = "indirizzo";
	public static final String CAP = "cap";
	public static final String NUMERO_INVIATI = "numeroInviati";
	public static final String NOTE = "note";

	/**
	 * Perform an initial save of a previously unsaved Clienti entity. All
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
	 * ClientiDAO.save(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            Clienti entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	@Transactional
	public void save(Clienti entity) {
		logger.info("saving Clienti instance");
		try {
			getJpaTemplate().persist(entity);
			logger.info("save successful");
		} catch (RuntimeException re) {
			logger.error("save failed", re);
			throw re;
		}
	}

	/**
	 * Delete a persistent Clienti entity. This operation must be performed
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
	 * ClientiDAO.delete(entity);
	 * txManager.commit(txn);
	 * entity = null;
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            Clienti entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	@Transactional
	public void delete(Clienti entity) {
		logger.info("deleting Clienti instance");
		try {
			entity = getJpaTemplate().getReference(Clienti.class,
					entity.getId());
			getJpaTemplate().remove(entity);
			logger.info("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved Clienti entity and return it or a copy of it
	 * to the sender. A copy of the Clienti entity parameter is returned when
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
	 * entity = ClientiDAO.update(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            Clienti entity to update
	 * @return Clienti the persisted Clienti entity instance, may not be the
	 *         same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	@Transactional
	public Clienti update(Clienti entity) {
		logger.info("updating Clienti instance");
		try {
			Clienti result = getJpaTemplate().merge(entity);
			logger.info("update successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("update failed", re);
			throw re;
		}
	}

	public Clienti findById(Integer id) {
		logger.info("finding Clienti instance with id: " + id);
		try {
			Clienti instance = getJpaTemplate().find(Clienti.class, id);
			return instance;
		} catch (RuntimeException re) {
			logger.error("find failed", re);
			throw re;
		}
	}

	/**
	 * Find all Clienti entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Clienti property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            number of results to return.
	 * @return List<Clienti> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Clienti> findByProperty(String propertyName,
			final Object value, final int... rowStartIdxAndCount) {
		logger.info("finding Clienti instance with property: " + propertyName
				+ ", value: " + value);
		try {
			final String queryString = "select model from Clienti model where model."
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

	public List<Clienti> findByIdRicerca(Object idRicerca,
			int... rowStartIdxAndCount) {
		return findByProperty(ID_RICERCA, idRicerca, rowStartIdxAndCount);
	}

	public List<Clienti> findByRagioneSociale(Object ragioneSociale,
			int... rowStartIdxAndCount) {
		return findByProperty(RAGIONE_SOCIALE, ragioneSociale,
				rowStartIdxAndCount);
	}

	public List<Clienti> findByCategoria(Object categoria,
			int... rowStartIdxAndCount) {
		return findByProperty(CATEGORIA, categoria, rowStartIdxAndCount);
	}

	public List<Clienti> findByProvincia(Object provincia,
			int... rowStartIdxAndCount) {
		return findByProperty(PROVINCIA, provincia, rowStartIdxAndCount);
	}

	public List<Clienti> findByCitta(Object citta, int... rowStartIdxAndCount) {
		return findByProperty(CITTA, citta, rowStartIdxAndCount);
	}

	public List<Clienti> findByTelefono(Object telefono,
			int... rowStartIdxAndCount) {
		return findByProperty(TELEFONO, telefono, rowStartIdxAndCount);
	}

	public List<Clienti> findByFax(Object fax, int... rowStartIdxAndCount) {
		return findByProperty(FAX, fax, rowStartIdxAndCount);
	}

	public List<Clienti> findByEmail(Object email, int... rowStartIdxAndCount) {
		return findByProperty(EMAIL, email, rowStartIdxAndCount);
	}

	public List<Clienti> findByIndirizzo(Object indirizzo,
			int... rowStartIdxAndCount) {
		return findByProperty(INDIRIZZO, indirizzo, rowStartIdxAndCount);
	}

	public List<Clienti> findByCap(Object cap, int... rowStartIdxAndCount) {
		return findByProperty(CAP, cap, rowStartIdxAndCount);
	}

	public List<Clienti> findByNumeroInviati(Object numeroInviati,
			int... rowStartIdxAndCount) {
		return findByProperty(NUMERO_INVIATI, numeroInviati,
				rowStartIdxAndCount);
	}

	public List<Clienti> findByNote(Object note, int... rowStartIdxAndCount) {
		return findByProperty(NOTE, note, rowStartIdxAndCount);
	}
	
	@SuppressWarnings("unchecked")
	public List<Clienti> findClienteDuplicato(Clienti cliente) {
		return getJpaTemplate().findByNamedQuery("clienteDuplicato",cliente.getEmail(),cliente.getProvincia(), cliente.getCitta());
	}

	/**
	 * Find all Clienti entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Clienti> all Clienti entities
	 */
	@SuppressWarnings("unchecked")
	public List<Clienti> findAll(final int... rowStartIdxAndCount) {
		logger.info("finding all Clienti instances");
		try {
			final String queryString = "select model from Clienti model";
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

	public static IClientiDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IClientiDAO) ctx.getBean("ClientiDAO");
	}

	public List<Clienti> findByCategoriaPaginegialle(
			Object categoriaPaginegialle, int... rowStartIdxAndCount) {
		// TODO Auto-generated method stub
		return null;
	}
}