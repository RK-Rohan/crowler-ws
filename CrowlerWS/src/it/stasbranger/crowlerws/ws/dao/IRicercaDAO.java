package it.stasbranger.crowlerws.ws.dao;

import it.stasbranger.crowlerws.ws.domain.Ricerca;

import java.sql.Timestamp;
import java.util.List;

/**
 * Interface for RicercaDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IRicercaDAO {
		/**
	 Perform an initial save of a previously unsaved Ricerca entity. 
	 All subsequent persist actions of this entity should use the #update() method.
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 	 <p>
	 User-managed Spring transaction example:
	 	 	 
	 * <pre> 
	 *   TransactionStatus txn = txManager.getTransaction(new DefaultTransactionDefinition());
	 *   IRicercaDAO.save(entity);
	 *   txManager.commit(txn);
	 * </pre>
	 @see <a href = "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring container-managed transaction examples</a>
	   @param entity Ricerca entity to persist
	  @throws RuntimeException when the operation fails
	 */
    public void save(Ricerca entity);
    /**
	 Delete a persistent Ricerca entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	 <p>
	 User-managed Spring transaction example:
	 	 	 
	 * <pre> 
	 *   TransactionStatus txn = txManager.getTransaction(new DefaultTransactionDefinition());
	 *   IRicercaDAO.delete(entity);
	 *   txManager.commit(txn);
	 *   entity = null;
	 * </pre>
	 @see <a href = "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring container-managed transaction examples</a>
	   @param entity Ricerca entity to delete
	 @throws RuntimeException when the operation fails
	 */
    public void delete(Ricerca entity);
   /**
	 Persist a previously saved Ricerca entity and return it or a copy of it to the sender. 
	 A copy of the Ricerca entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 <p>
	 User-managed Spring transaction example:
	 	 	 
	 * <pre> 
	 *   TransactionStatus txn = txManager.getTransaction(new DefaultTransactionDefinition());
	 *   entity = IRicercaDAO.update(entity);
	 *   txManager.commit(txn);
	 * </pre>
	 @see <a href = "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring container-managed transaction examples</a>
	   @param entity Ricerca entity to update
	 @return Ricerca the persisted Ricerca entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public Ricerca update(Ricerca entity);
	public Ricerca findById( Integer id);
	 /**
	 * Find all Ricerca entities with a specific property value.  
	 
	  @param propertyName the name of the Ricerca property to query
	  @param value the property value to match
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<Ricerca> found by query
	 */
	public List<Ricerca> findByProperty(String propertyName, Object value
			, int...rowStartIdxAndCount
		);
	public List<Ricerca> findByCosa(Object cosa
			, int...rowStartIdxAndCount
		);
	public List<Ricerca> findByDove(Object dove
			, int...rowStartIdxAndCount
		);
	/**
	 * Find all Ricerca entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<Ricerca> all Ricerca entities
	 */
	public List<Ricerca> findAll(
			int...rowStartIdxAndCount
		);	
	
	public List<Ricerca> findLastRicerca();
	
	public List<Ricerca> findByCosaDove(Object cosa, Object dove, int...rowStartIdxAndCount);
}