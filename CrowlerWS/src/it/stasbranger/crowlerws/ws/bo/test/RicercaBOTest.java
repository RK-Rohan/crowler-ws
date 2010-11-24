package it.stasbranger.crowlerws.ws.bo.test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

import it.stasbranger.crowlerws.ws.bo.RicercaBO;
import it.stasbranger.crowlerws.ws.dao.IRicercaDAO;
import it.stasbranger.crowlerws.ws.dao.RicercaDAO;
import it.stasbranger.crowlerws.ws.domain.Ricerca;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class RicercaBOTest {

	private ClassPathXmlApplicationContext ctx;
    private JpaTransactionManager txManager;
    private IRicercaDAO rdao;
	
    /**
    #	 * Log4j logger
    #	 */
    static Logger log4j = Logger.getLogger("it.stasbranger.crowlerws");
    
	@Before
	public void setUp() throws Exception {
		ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        txManager = ((JpaTransactionManager) ctx.getBean("transactionManager"));
        rdao = RicercaDAO.getFromApplicationContext(ctx);
	}

	@Test
	public void testSave() {
		RicercaBO bean = (RicercaBO) ctx.getBean("RicercaBO");
		Ricerca ricerca = new Ricerca();
		ricerca.setCosa("Fioraio");
		ricerca.setDove("Napoli");
		Calendar calendar = Calendar.getInstance();
		java.util.Date now = calendar.getTime();
		java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());
		ricerca.setData(currentTimestamp);
		ricerca.setId(null);
		
		TransactionStatus status = txManager.getTransaction(new DefaultTransactionDefinition()); 
        bean.saveRicerca(ricerca);
        txManager.commit(status);
        
	}

	@Test
	public final void testDelete() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testUpdate() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testFindById() {
		RicercaBO rbo = (RicercaBO) ctx.getBean("RicercaBO");
		Ricerca ricerca = new Ricerca();
		ricerca.setId(1);
		//TransactionStatus status = txManager.getTransaction(new DefaultTransactionDefinition()); 
		ricerca = rbo.findRicercaById(ricerca);
        //txManager.commit(status);
        System.out.println("Cosa: " + ricerca.getCosa() + "    Dove: " + ricerca.getDove() );
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testFindByProperty() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testFindByCosa() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testFindByDove() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testFindAll() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public final void testGetFromApplicationContext() {
		fail("Not yet implemented"); // TODO
	}

}
