package it.stasbranger.crowlerws.ws.mvc;

import it.stasbranger.crowlerws.ws.bo.ClientiBO;
import it.stasbranger.crowlerws.ws.domain.Clienti;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class ListaClientiController extends SimpleFormController {
	@Resource
	private ClientiBO clientiBO;

	protected final Log logger = LogFactory.getLog(getClass());
	 
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
		
		//String number = ServletRequestUtils.getStringParameter(request, "clienti");
		//System.out.println("request: "+request+" response: "+response+" clienti: "+number);
		
		String now = (new java.util.Date()).toString();
        logger.info("returning hello view with " + now);

        Map<String, Object> myModel = new HashMap<String, Object>();
        myModel.put("now", now);
        myModel.put("clienti", clientiBO.getClienti());
		// Clienti c = (Clienti)command;
		
		return new ModelAndView("listaClienti", "model", myModel);
	}

	public void setClientiBO(ClientiBO clientiBO) {
        this.clientiBO = clientiBO;
    }
    
    public ClientiBO getClientiBO() {
        return clientiBO;
    }
}
