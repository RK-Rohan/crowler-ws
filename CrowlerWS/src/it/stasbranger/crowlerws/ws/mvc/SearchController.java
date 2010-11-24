package it.stasbranger.crowlerws.ws.mvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.stasbranger.crowlerws.ws.domain.Ricerca;
import it.stasbranger.crowlerws.ws.domain.Clienti;
import it.stasbranger.crowlerws.ws.bo.ClientiBO;
import it.stasbranger.crowlerws.ws.bo.RicercaBO;
import it.stasbranger.crowlerws.ws.utility.SpiderYP;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.SimpleFormController;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Controller
public class SearchController extends SimpleFormController {

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    
    @Resource
	private ClientiBO clientiBO;
    
    @Resource
	private RicercaBO ricercaBO;
     
    @RequestMapping
    protected ModelAndView onSubmit(Object command) throws ServletException, IOException {

        String cosa = ((SearchModel) command).getCosa();
        String dove = ((SearchModel) command).getDove();
        logger.info("Cosa e Dove : " + cosa + " - " + dove);
        Ricerca ricerca = new Ricerca();
        // set ricerca values

        ricerca.setCosa(cosa);
        ricerca.setDove(dove);
        ricerca.setId(null);
    	Calendar calendar = Calendar.getInstance();
		java.util.Date noww = calendar.getTime();
		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(noww.getTime());
        ricerca.setData(currentTimestamp);
        
        SpiderYP syp = new SpiderYP();
        Map<String, Object> myModel = new HashMap<String, Object>();
        String now = (new java.util.Date()).toString();
        myModel.put("now", now);
//        List<Ricerca> lRic = new ArrayList<Ricerca>();
//        lRic = ricercaBO.findRicercaByCosaDove(ricerca);
//        if(lRic.isEmpty()){
        	ricercaBO.saveRicerca(ricerca);
        	ricerca = ricercaBO.findLastRicerca(ricerca);	
        	Set<Clienti> clienti = syp.getSpiderYP(ricerca);
        
	        logger.info("Clienti " + clienti);
	        if(clienti != null){
	        		  
	        	Iterator<Clienti> itr = clienti.iterator(); 
	    		while(itr.hasNext()){
	    			Clienti cliente = (Clienti) itr.next();
	    			cliente.setIdRicerca(ricerca.getId());
	    			clientiBO.saveClienti(cliente);
	    			logger.info("Clienti: " + cliente);
	    		}
	    		clientiBO.setClienti(clienti);
			    myModel.put("clienti", clienti);
		        logger.info("Increasing prices by " + cosa + "%.");
	        logger.info("returning from PriceIncreaseForm view to " + getSuccessView());
	        }else{
	        	logger.info("Lista clienti vuota");
	        }
//        }else{
//        	logger.info("Ricerca effettuata");
//        	System.out.println("Ricerca gia effettuata");
//        }    
        return new ModelAndView(new RedirectView(getSuccessView()),"model", myModel);
    }
    
    protected Object formBackingObject(HttpServletRequest request) throws ServletException {
        SearchModel searchModel = new SearchModel();
        return searchModel;
    }
    
    public void setClientiBO(ClientiBO clientiBO) {
        this.clientiBO = clientiBO;
    }
    
    public ClientiBO getClientiBO() {
        return clientiBO;
    }
    
    public void setRicercaBO(RicercaBO ricercaBO) {
        this.ricercaBO = ricercaBO;
    }
    
    public RicercaBO getRicercaBO() {
        return ricercaBO;
    }
}
