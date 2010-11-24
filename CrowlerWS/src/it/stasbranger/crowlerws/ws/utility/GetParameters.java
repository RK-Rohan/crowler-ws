package it.stasbranger.crowlerws.ws.utility;

public class GetParameters {
	 static public String getRagioneSociale(String textArea) {
         return RegexHTML.getValue(textArea, "<div class=\"ypdata\"><a class=yschttl href=\"(.*?)\">(.*?)</a>")[2];
	 }
	 static public String getIndirizzo(String textArea) {
         return RegexHTML.getValue(textArea, "<div class=\"yschabstr\">(.*?)<br></div>")[1];
	 }
	 static public String getDescrizione(String textArea) {
		 String[] sTextArea = textArea.split("<br clear=\"all\">");
         return RegexHTML.getValue(sTextArea[1], "<div class=\"yschabstr\">(.*?)[^<br>]</div>")[1];
	 }
	 static public String getTelefono(String textArea) {
         return RegexHTML.getValue(textArea, "<div class=\"ypphone\">Telefono: <strong>(.*?)</strong>")[1];
	 }
	 static public String getFax(String textArea) {
         return RegexHTML.getValue(textArea, "<br>Fax: <strong>(.*?)</strong>")[1];
	 }
	 static public String getRisultati(String textArea) {
         return RegexHTML.getValue(textArea, "<div id=\"yschtools\"><div><span><br></span></div></div><div id=yschinfo><h1>Risultati ricerca</h1> <p>1 - 10 di circa (.*?) per <strong>(.*?)</strong>")[1];
	 }	
	 static public String getEmail(String textArea) {
         return RegexHTML.getValue(textArea, "<span class=\"ypurl\">(.*?)</span>")[1];
	 }	
	 static public String getEmail2(String textArea) {
         return RegexHTML.getValue(textArea, "(.*?),(.*)")[1];
	 }	
	 static public String getCorpoRisultati(String textArea) {
         return RegexHTML.getValue(textArea, "<div id=yschres><div id=yschcont><div id=yschpri>(.*?)</div></div></div><div id=yschpg>")[1];
	 }
	 static public String getStartSingoloRisultato(String textArea) {
         return RegexHTML.getValue(textArea, "<div class=\"ypresult\">(.*?)")[1];
	 }
	 static public String getEndSingoloRisultato(String textArea) {
         return RegexHTML.getValue(textArea, "<br clear=\"all\">(.*?)")[1];
	 }
	 static public String getCategoria(String textArea) {
         return RegexHTML.getValue(textArea, "<div>Categoria: <a href=\"(.*?)\">(.*?)</a></div>")[2];
	 }
	 static public String getCAP(String textArea) {
         return RegexHTML.getValue(textArea, "(.*?)\\|\\s(.*?)\\s(.*?),\\s(.*)")[2];
	 }
	 static public String getVia(String textArea) {
         return RegexHTML.getValue(textArea, "(.*?)\\|\\s(.*?)\\s(.*?),\\s(.*)")[1];
	 }
	 static public String getComune(String textArea) {
         return RegexHTML.getValue(textArea, "(.*?)\\|\\s(.*?)\\s(.*?),\\s(.*)")[3];
	 }
	 static public String getProvincia(String textArea) {
         return RegexHTML.getValue(textArea, "(.*?)\\|\\s(.*?)\\s(.*?),\\s(.*)")[4];
	 }
	 static public String getTelefono2(String textArea) {
         return RegexHTML.getValue(textArea, "(.*?)[,|-](.*)")[1];
	 }
	 static public String getFax2(String textArea) {
         return RegexHTML.getValue(textArea, "(.*?)[,|-](.*)")[1];
	 }
	 static public String getSingoloRisultato(String textArea) {
         return RegexHTML.getValue(textArea, " <div class=\"(.*?)\">")[1];
	 }
}
