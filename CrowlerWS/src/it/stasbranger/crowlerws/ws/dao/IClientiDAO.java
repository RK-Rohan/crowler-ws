package it.stasbranger.crowlerws.ws.dao;

import it.stasbranger.crowlerws.ws.domain.Clienti;

import java.util.List;

/**
 * Interface for ClientiDAO.
 * @author MyEclipse Persistence Tools
 */

public interface IClientiDAO {
		/**
	 Perform an initial save of a previously unsaved Clienti entity. 
	 All subsequent persist actions of this entity should use the #update() method.
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist} operation.
	 	 <p>
	 User-managed Spring transaction example:
	 	 	 
	 * <pre> 
	 *   TransactionStatus txn = txManager.getTransaction(new DefaultTransactionDefinition());
	 *   IClientiDAO.save(entity);
	 *   txManager.commit(txn);
	 * </pre>
	 @see <a href = "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring container-managed transaction examples</a>
	   @param entity Clienti entity to persist
	  @throws RuntimeException when the operation fails
	 */
    public void save(Clienti entity);
    /**
	 Delete a persistent Clienti entity.
	  This operation must be performed 
	 within the a database transaction context for the entity's data to be
	 permanently deleted from the persistence store, i.e., database. 
	 This method uses the {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete} operation.
	 	 <p>
	 User-managed Spring transaction example:
	 	 	 
	 * <pre> 
	 *   TransactionStatus txn = txManager.getTransaction(new DefaultTransactionDefinition());
	 *   IClientiDAO.delete(entity);
	 *   txManager.commit(txn);
	 *   entity = null;
	 * </pre>
	 @see <a href = "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring container-managed transaction examples</a>
	   @param entity Clienti entity to delete
	 @throws RuntimeException when the operation fails
	 */
    public void delete(Clienti entity);
   /**
	 Persist a previously saved Clienti entity and return it or a copy of it to the sender. 
	 A copy of the Clienti entity parameter is returned when the JPA persistence mechanism has not previously been tracking the updated entity. 
	 This operation must be performed within the a database transaction context for the entity's data to be permanently saved to the persistence
	 store, i.e., database. This method uses the {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge} operation.
	 	 <p>
	 User-managed Spring transaction example:
	 	 	 
	 * <pre> 
	 *   TransactionStatus txn = txManager.getTransaction(new DefaultTransactionDefinition());
	 *   entity = IClientiDAO.update(entity);
	 *   txManager.commit(txn);
	 * </pre>
	 @see <a href = "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring container-managed transaction examples</a>
	   @param entity Clienti entity to update
	 @return Clienti the persisted Clienti entity instance, may not be the same
	 @throws RuntimeException if the operation fails
	 */
	public Clienti update(Clienti entity);
	public Clienti findById( Integer id);
	 /**
	 * Find all Clienti entities with a specific property value.  
	 
	  @param propertyName the name of the Clienti property to query
	  @param value the property value to match
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<Clienti> found by query
	 */
	public List<Clienti> findByProperty(String propertyName, Object value
			, int...rowStartIdxAndCount
		);
	public List<Clienti> findByIdRicerca(Object idRicerca
			, int...rowStartIdxAndCount
		);
	public List<Clienti> findByRagioneSociale(Object ragioneSociale
			, int...rowStartIdxAndCount
		);
	public List<Clienti> findByCategoriaPaginegialle(Object categoriaPaginegialle
			, int...rowStartIdxAndCount
		);
	public List<Clienti> findByProvincia(Object provincia
			, int...rowStartIdxAndCount
		);
	public List<Clienti> findByCitta(Object citta
			, int...rowStartIdxAndCount
		);
	public List<Clienti> findByTelefono(Object telefono
			, int...rowStartIdxAndCount
		);
	public List<Clienti> findByFax(Object fax
			, int...rowStartIdxAndCount
		);
	public List<Clienti> findByEmail(Object email
			, int...rowStartIdxAndCount
		);
	public List<Clienti> findByIndirizzo(Object indirizzo
			, int...rowStartIdxAndCount
		);
	public List<Clienti> findByCap(Object cap
			, int...rowStartIdxAndCount
		);
	public List<Clienti> findByNumeroInviati(Object numeroInviati
			, int...rowStartIdxAndCount
		);
	public List<Clienti> findByNote(Object note
			, int...rowStartIdxAndCount
		);
	public List<Clienti> findByCategoria(Object categoria
			, int...rowStartIdxAndCount
		);
	/**
	 * Find all Clienti entities.
	  	  @param rowStartIdxAndCount Optional int varargs. rowStartIdxAndCount[0] specifies the  the row index in the query result-set to begin collecting the results. rowStartIdxAndCount[1] specifies the the maximum count of results to return.  
	  	  @return List<Clienti> all Clienti entities
	 */
	public List<Clienti> findAll(
			int...rowStartIdxAndCount
		);	
	
	public List<Clienti> findClienteDuplicato(Clienti cliente);
}