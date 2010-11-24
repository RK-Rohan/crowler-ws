package it.stasbranger.crowlerws.ws.bo.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.logging.Logger;

import it.stasbranger.crowlerws.ws.bo.ClientiBO;
import it.stasbranger.crowlerws.ws.bo.RicercaBO;
import it.stasbranger.crowlerws.ws.dao.ClientiDAO;
import it.stasbranger.crowlerws.ws.dao.IClientiDAO;
import it.stasbranger.crowlerws.ws.dao.IRicercaDAO;
import it.stasbranger.crowlerws.ws.domain.Clienti;
import it.stasbranger.crowlerws.ws.domain.Ricerca;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class ClientiBOTest {

	private ClassPathXmlApplicationContext ctx;
    private JpaTransactionManager txManager;
    private IClientiDAO cdao;
	
    /**
    #	 * Log4j logger
    #	 */
    static Logger log4j = Logger.getLogger("it.stasbranger.crowlerws");
    
	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        txManager = ((JpaTransactionManager) ctx.getBean("transactionManager"));
        cdao = ClientiDAO.getFromApplicationContext(ctx);
	}

	@Test
	public final void testListClienti() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testFindClienti() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testSaveClienti() {
		ClientiBO bean = (ClientiBO) ctx.getBean("ClientiBO");
		Clienti cliente = new Clienti();
		cliente.setRagioneSociale("Stasbranger");
		cliente.setCap("70031");
		cliente.setCategoriaPaginegialle("software house");
		cliente.setCitta("Andria");
		cliente.setEmail("info@stasbranger.com");
		cliente.setFax("0883380207");
		cliente.setId(null);
		cliente.setIdRicerca(1);
		cliente.setIndirizzo("via Settembrini, 23");
		cliente.setNote("bla bla bla");
		cliente.setNumeroInviati(0);
		cliente.setProvincia("BT");
		cliente.setRagioneSociale("Puglia");
		cliente.setTelefono("0883380207");
		
		TransactionStatus status = txManager.getTransaction(new DefaultTransactionDefinition()); 
        bean.saveClienti(cliente);
        txManager.commit(status);
	}

	@Test
	public final void testSetClientiDAO() {
		fail("Not yet implemented"); // TODO
	}

}
