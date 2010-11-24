package it.stasbranger.crowlerws.ws.bo;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import it.stasbranger.crowlerws.ws.dao.ClientiDAO;
import it.stasbranger.crowlerws.ws.dao.RicercaDAO;
import it.stasbranger.crowlerws.ws.domain.Clienti;
import it.stasbranger.crowlerws.ws.domain.Ricerca;
import it.stasbranger.crowlerws.ws.mvc.SearchModel;

public class SearchBO {
	
	private RicercaBO ricercaBO;
	private ClientiBO clientiBO;
	
	private List<Ricerca> ricerche;
	private Ricerca ricerca;
	
	private Set<Clienti> clienti;
	private Clienti cliente;
	
	 /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
	
    @Transactional
    public Set<Clienti> getClienti() {
        return clienti;
    }
    
    @Transactional
    public void setClienti(Set<Clienti> clienti) {
        this.clienti = clienti;
    }
    
    @Transactional
    public List<Ricerca> getRicerche() {
	        return ricerche;
    }
	
    @Transactional
	public void setRicerche(List<Ricerca> ricerche) {
        this.ricerche = ricerche;
    }
	
    @Transactional
	public void saveClienti(Ricerca ricerca, Set<Clienti> clienti){
		System.out.println(ricerca.getCosa());
		System.out.println(ricerca.getDove());
		System.out.println(ricerca.getData());
		ricerca.setId(1);
		System.out.println(ricerca.getId());
		ricercaBO.saveRicerca(ricerca);
		this.ricerca = ricercaBO.findRicercaById(ricerca);
		Iterator<Clienti> itr = clienti.iterator(); 
		while(itr.hasNext()){
			Clienti cliente = (Clienti) itr.next();
			clientiBO.saveClienti(cliente);
			logger.info("Clienti: " + cliente);
		}
		this.clienti = clienti;
	}
	
    @Transactional
	public void saveRicerche(Ricerca ricerca) {
        ricercaBO.saveRicerca(ricerca);
        this.ricerca = ricerca;
    }

    @Transactional
	public Ricerca ricercaDB(SearchModel searchModel){
		
		Ricerca ricVO = new Ricerca();
		ricVO.setId(1);
		ricVO = ricercaBO.findRicercaById(ricVO);
		
		return ricVO;
	}
}
