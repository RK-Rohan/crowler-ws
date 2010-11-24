<%@ include file="/WEB-INF/jsp/include.jsp" %>

<html>
  <head><title>Elenco Clienti</title></head>
  <body>
    <h1><fmt:message key="heading"/></h1>
    <p><fmt:message key="greeting"/> <c:out value="${model.now}"/></p>
    <br>
    <a href="<c:url value="search.html"/>">Nuova Ricerca</a>
    <br>
    <h3>Clienti</h3>
    <c:forEach items="${model.clienti}" var="cli">
      <c:out value="${cli.ragioneSociale}"/> 
		| <i><c:out value="${cli.categoria}"/></i>
		| <i><c:out value="${cli.provincia}"/></i>
		| <i><c:out value="${cli.citta}"/></i>
		| <i><c:out value="${cli.telefono}"/></i>
		| <i><c:out value="${cli.fax}"/></i>
		| <b><c:out value="${cli.email}"/></b>
		| <i><c:out value="${cli.indirizzo}"/></i>
		| <i><c:out value="${cli.cap}"/></i>
		| <i><c:out value="${cli.note}"/></i>	
	<br><br>
    </c:forEach>
  </body>
</html>