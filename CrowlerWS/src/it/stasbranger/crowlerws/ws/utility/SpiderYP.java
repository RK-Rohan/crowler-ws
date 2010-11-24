package it.stasbranger.crowlerws.ws.utility;

import it.stasbranger.crowlerws.ws.domain.Clienti;
import it.stasbranger.crowlerws.ws.domain.Ricerca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpiderYP {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public Set<Clienti> getSpiderYP(Ricerca ricerca) throws IOException{
		// TODO Auto-generated method stub
		Set<Clienti> clientiList = new HashSet<Clienti>();
		
		String[] provDaEsaminare;
		String[] province = new String[]{ 	"AG","AL","AN","AO","AP","AQ","AR","AT","AV",
											"BA","BG","BI","BL","BN","BO","BR","BS","BT","BZ",
											"CA","CB","CE","CH","CI","CL","CN","CO","CR",
											"CS","CT","CZ","EN","FE","FG","FI","FO","FR","FM",
											"GE","GO","GR","IM","IS","KR","LC","LE","LI",
											"LO","LT","LUCCA","MB","MC","ME","MI","MN","MO","MS",
											"MT","NA","NO","NU","OG","OR","OT","PA","PC",
											"PD","PE","PG","PI","PN","PO","PR","PT","PU",
											"PV","PZ","RA","RC","RE","RG","RI","RM","RN",
											"ROVIGO","SA","SI","SO","SP","SR","SS","SV","TA",
											"TE","TN","TO","TP","TR","TS","TV","UD","VA",
											"VB","VC","VE","VI","VR","VS","VT","VV"		};
		
		if(ricerca.getDove().equalsIgnoreCase("italia") || 
				ricerca.getDove().equalsIgnoreCase("italy") ||
				ricerca.getDove().equalsIgnoreCase("it")){
			System.out.println("Tutte le province selezionate.");
			provDaEsaminare = province;
			
		}else{
			System.out.println("Localita' specifica selezionata : " + ricerca.getDove());
			provDaEsaminare = ricerca.getDove().split(",");
		}
		
		for (int prov=0; prov<provDaEsaminare.length; prov++) {
			try{
		        Thread.sleep(60000);        
		             
		    }catch (InterruptedException ie){
		        System.out.println(ie.getMessage());
		    }
			System.out.println("LOCALITA' DA ESAMINARE : " + provDaEsaminare[prov]);
			
			String urlStr = "http://it.search.yahoo.com/yp/search;_ylt=A0oG758Z2TpMkHwBa_Y6DQx.?fr=sfp&fr2=&p="+ricerca.getCosa().replace(" ", "+")+"&dv="+provDaEsaminare[prov].replace(" ", "+")+"&s=Cerca&b=";
			String wordFind;
			
			URLConnectionReader ucr = new URLConnectionReader();
			String content = ucr.getContentsURL(urlStr + "1");
			
			int pagine = 0;
			
			wordFind = GetParameters.getRisultati(content);
			
			if(wordFind == null){
				pagine = 1;
			}else{
				int numeroRisultati = Integer.parseInt(wordFind);
				int restoPagina = numeroRisultati % 10;
				
				
				
				if(restoPagina == 0)
					pagine = (numeroRisultati-restoPagina)/10;
				else
					pagine = (numeroRisultati-restoPagina)/10 + 1;
			}
			
			for(int elemento = 0; elemento < pagine; elemento++){
				
				URL url = new URL(urlStr + (elemento * 10 + 1));
				
				URLConnection conn = new URL(url.toString()).openConnection();
				BufferedReader in = new BufferedReader(
						new InputStreamReader(conn.getInputStream()));
				try{
				System.out.println(url.toString());
				
				String inputLine;
				String singoloRisultato = null;
				List<String> risultati = new ArrayList<String>();
				int jj = -1, comodo = 0;
				
				while ((inputLine = in.readLine()) != null){
					
					if(inputLine.equals("</div><div id=yschft>")){
						risultati.add(singoloRisultato);
						break;	// uscita forzata dal ciclo while
					} 
					
					if((wordFind = GetParameters.getSingoloRisultato(inputLine)) != null && comodo == 1){
						if(wordFind.equals("ypresult")){
							if(jj>=0)
								risultati.add(singoloRisultato);
							jj = jj + 1;
							comodo = 1;
							singoloRisultato = "";
						}
					}	
					
					if(comodo == 1)
						singoloRisultato += inputLine + "\n";
					
					if(inputLine.equals("<div id=yschres><div id=yschcont><div id=yschpri>"))
						comodo = 1;
				}	
				in.close();
				
				for (int jjj = 0; jjj < risultati.size(); jjj++)
				{
				    System.out.println("----------------------------------");
				    System.out.println("Azienda (" + jjj + ") : " + risultati.get(jjj));
				    clientiList.add(getYPCliente(ricerca, risultati.get(jjj)));
				}
				
				
				//String htmlPage = buf.toString();    
				//System.out.println(htmlPage);
				



//				for(String inputLine; (inputLine = in.readLine()) != null; ){
//					
//					if((wordFind = GetParameters.getStartSingoloRisultato(inputLine)) != null && (count == 0)){
//						System.out.println("-------------------------------------");
//						count = 1;
//					}
//					if((wordFind = GetParameters.getRagioneSociale(inputLine)) != null && (count == 1)){
//						ragioneSociale = wordFind.trim();
//						System.out.println(ragioneSociale);
//						//clienti.setRagioneSociale(ragioneSociale);
//						count = 2;
//					}
//					if((wordFind = GetParameters.getIndirizzo(inputLine)) != null && (count == 2)){
//						indirizzo = wordFind.trim();
//						if((cap = GetParameters.getCAP(indirizzo)) != null){
//							cap = cap.trim();
//						}
//						if((via = GetParameters.getVia(indirizzo)) != null){
//							via = via.trim();
//						}
//						if((comune = GetParameters.getComune(indirizzo)) != null){
//							comune = comune.trim();
//						}
//						if((provincia = GetParameters.getProvincia(indirizzo)) != null){
//							provincia = provincia.trim();
//						}
//				
//						System.out.println(indirizzo);
//	//					clienti.setIndirizzo(via);
//	//					clienti.setCap(cap);
//	//					clienti.setCitta(comune);
//	//					clienti.setProvincia(provincia);
//						count = 3;
//					}
//					if((wordFind = GetParameters.getCategoria(inputLine)) != null && (count == 3)){
//						categoria = wordFind.trim();
//						System.out.println(categoria);
//						//clienti.setCategoria(categoria);
//						count = 4;
//					}
//					if((wordFind = GetParameters.getTelefono(inputLine)) != null && (count == 4)){
//						telefono = wordFind.trim();
//						if((wordFind = GetParameters.getTelefono2(telefono)) != null){
//							telefono = wordFind.trim();
//						}
//						System.out.println(telefono);
//						//clienti.setTelefono(telefono);
//						count = 5;
//					}
//					if((wordFind = GetParameters.getFax(inputLine)) != null && (count == 5)){
//						fax = wordFind.trim();
//						System.out.println(fax);
//						count = 6;
//					}
//					if((wordFind = GetParameters.getEmail(inputLine)) != null && (count == 6 || count == 5)){
//						email = wordFind.trim();
//						if((wordFind = GetParameters.getEmail2(email)) != null){
//							email = wordFind.trim();
//						}
//						System.out.println(email);
//						//clienti.setEmail(email);
//						count = 7;
//					}
//					if((wordFind = GetParameters.getDescrizione(inputLine)) != null){
//						descrizione = wordFind.trim();
//						System.out.println(descrizione);
//						count = 0;
//						//clienti.setNote(descrizione);
//						if(!email.equals("")){
//							
//							i++;					
//							clientiList.add(new Clienti(ricerca.getId(),ragioneSociale,categoria,provincia,comune, telefono, fax, email,  via,  cap, 0, descrizione));
//						}
//					}
//				}
				
				}catch (Exception e) {
					System.out.println(e.getStackTrace());
				}finally{
					in.close();
				}
			}
		} // and ciclo for per ogni provincia da esaminare	
		return clientiList;
	}
	
	private Clienti getYPCliente(Ricerca ricerca, String text){
		
	    Clienti cliente = new Clienti();
		String wordFind,ragioneSociale = ""
			,categoria = ""
			,email = ""
			,telefono = ""
			,fax = ""
			,descrizione = ""
			,indirizzo = ""
			,cap = ""
			,comune = ""
			,provincia = ""
			,via = "";
		
		if((ragioneSociale = GetParameters.getRagioneSociale(text)) != null){
	    	ragioneSociale = ragioneSociale.trim();
	    	cliente.setRagioneSociale(ragioneSociale);
	    	System.out.println("Ragione sociale : " + ragioneSociale);
	    }
	    System.out.println("Ragione Sociale : " + ragioneSociale);
	    if((indirizzo = GetParameters.getIndirizzo(text)) != null){
	    	if((cap = GetParameters.getCAP(indirizzo)) != null){
				cap = cap.trim();
			}
			if((via = GetParameters.getVia(indirizzo)) != null){
				via = via.trim();
			}
			if((comune = GetParameters.getComune(indirizzo)) != null){
				comune = comune.trim();
			}
			if((provincia = GetParameters.getProvincia(indirizzo)) != null){
				provincia = provincia.trim();
			}
	    	cliente.setCap(cap);
	    	cliente.setIndirizzo(via);
	    	cliente.setCitta(comune);
	    	cliente.setProvincia(provincia);
	    	System.out.println("Indirizzo : " + indirizzo);
	    }
	    if((categoria = GetParameters.getCategoria(text)) != null){
	    	categoria = categoria.trim();
	    	cliente.setCategoriaPaginegialle(categoria);
	    	System.out.println("Categoria : "+ categoria);
	    }
	    if((telefono = GetParameters.getTelefono(text)) != null){
	    	telefono = telefono.trim();
	    	if((wordFind = GetParameters.getTelefono2(telefono)) != null){
				telefono = wordFind.trim();
			}
	    	cliente.setTelefono(telefono);
	    	System.out.println("Telefono : "+ telefono);
	    }
	    if((fax = GetParameters.getFax(text)) != null){
	    	fax = fax.trim();
	    	if((wordFind = GetParameters.getFax2(fax)) != null){
	    		fax = wordFind.trim();
			}
	    	cliente.setFax(fax);
			System.out.println("Fax : "+ fax);
	    }else{
	    	cliente.setFax(telefono);
	    }
	    if((email = GetParameters.getEmail(text)) != null){
	    	email = email.trim();
	    	if((wordFind = GetParameters.getEmail2(email)) != null){
				email = wordFind.trim();
			}
	    	cliente.setEmail(email);
	    	System.out.println("Email : "+ email);
	    }else{
	    	cliente.setEmail("");
	    }
	    if((descrizione = GetParameters.getDescrizione(text)) != null){
	    	descrizione = descrizione.trim();
	    	cliente.setNote(descrizione);
	    	System.out.println("Descrizione : "+ descrizione);
	    }else{
	    	cliente.setNote("");
	    }
	    cliente.setIdRicerca(ricerca.getId());
	    cliente.setNumeroInviati(0);
	    
	    return cliente;
		
	}

}
