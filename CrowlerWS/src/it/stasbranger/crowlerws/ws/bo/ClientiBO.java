package it.stasbranger.crowlerws.ws.bo;

import it.stasbranger.crowlerws.ws.dao.IClientiDAO;
import it.stasbranger.crowlerws.ws.domain.Clienti;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

public class ClientiBO {

	private static IClientiDAO cdao;
	private Set<Clienti> clienti;
	private Clienti cliente;
	
	@Transactional
    public static List<Clienti> listClienti(){
            List<Clienti> clist = cdao.findAll();
    return clist;   
    }
    
    @Transactional
    public Clienti findClienti(Clienti c){
            setClientiDAO(cdao);
            Clienti cliente = cdao.findById(c.getId());
            
    return cliente;    
    }

	 @Transactional
     public void saveClienti(Clienti cliente){
		 	List<Clienti> lc = cdao.findClienteDuplicato(cliente);
		 	if(lc.size() == 0){
		 		cdao.save(cliente);
		 	}else{
		 		System.out.println("Cliente duplicato: " + cliente.getRagioneSociale() + "  " + cliente.getEmail());
		 	}	
     }
	 
	 @Transactional
	 public Set<Clienti> getClienti() {
	        return clienti;
	 }
	    
	 @Transactional
	 public void setClienti(Set<Clienti> clienti) {
	        this.clienti = clienti;
	 }

	 public void setClientiDAO(IClientiDAO cdao) {
         this.cdao = cdao;
	 }

}
