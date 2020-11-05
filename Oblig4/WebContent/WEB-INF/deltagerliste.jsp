<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
    href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>Deltagerliste</title>
</head>
<body>

    <h2>Deltagerliste</h2>
    <table class="pure-table">
        <tr bgcolor="#cccccc">
            <th>Kjønn</th>
            <th align="left">Navn</th>
            <th align="left">Mobil</th>
        </tr>
 
<c:forEach var="deltager" items="${deltagerliste}" varStatus="loop">
    
     <tr>
        <c:choose>
        <c:when test="${deltager.getKjonn().equals('KVINNE')}">
        <td align="center">&#9792;</td>
        </c:when>
        <c:when test="${deltager.getKjonn().equals('MANN')}">
        <td align="center">&#9794;</td>
        </c:when>
        </c:choose>
        <c:set var="aktuell" value="${aktuell}"></c:set>
        <c:choose>    
        <c:when test="${deltager.getMobilnummer()==aktuell}">
        <td style="background-color:lightgreen;"><c:out value="${deltager.getFornavn()} ${deltager.getEtternavn()}" /> </td> 
        <td style="background-color:lightgreen;"><c:out value="${deltager.getMobilnummer()}" /></td>
        </c:when>
        <c:otherwise>
            <td><c:out value="${deltager.getFornavn()} ${deltager.getEtternavn()}" /> </td> 
            <td><c:out value="${deltager.getMobilnummer()}" /></td>
            </c:otherwise>
        </c:choose>
     </tr>
</c:forEach>
  
    </table>
    
        <form action="logout">
    <div class="pure-controls">
    <input type="submit" value="Logg ut" class="pure-button pure-button-primary"/>
    </div>
    </form>
</body>
</html>