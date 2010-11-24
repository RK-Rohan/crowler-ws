package it.stasbranger.crowlerws.ws.bo;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import it.stasbranger.crowlerws.ws.dao.IRicercaDAO;
import it.stasbranger.crowlerws.ws.domain.Ricerca;

public class RicercaBO {

	private static IRicercaDAO rdao;
	
	@Transactional
    public static List<Ricerca> listRicerche(){
            List<Ricerca> rlist = rdao.findAll();
    return rlist;   
    }
    
    @Transactional
    public Ricerca findRicercaById(Ricerca r){
            setRicercaDAO(rdao);
            Ricerca ricerca = rdao.findById(r.getId());
            
    return ricerca;    
    }
    
    @Transactional
    public List<Ricerca> findRicercaByCosaDove(Ricerca r){
            setRicercaDAO(rdao);
            List<Ricerca> lRicerca = rdao.findByCosaDove(r.getCosa(), r.getDove());
            
    return lRicerca;    
    }
    
    @Transactional
    public Ricerca findLastRicerca(Ricerca r){
            setRicercaDAO(rdao);
            List<Ricerca> lRicerca = rdao.findLastRicerca();
            r = lRicerca.get(0);
    return r;    
    }

	 @Transactional
     public void saveRicerca(Ricerca ricerca){
         rdao.save(ricerca);
     }

	 public void setRicercaDAO(IRicercaDAO rdao) {
         this.rdao = rdao;
	 }

}
