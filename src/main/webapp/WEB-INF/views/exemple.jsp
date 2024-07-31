<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Page Servlet exemple </title>
</head>
<body>
    <%@include file="menu.jsp"%>
    <p>${tartanpion}</p>
    <p>${tartanpion2}</p>

    <h2>Information Transmise</h2>
    <p>Valeur transmise : ${transmittedValue}</p>

    <h2>Liste des personnes</h2>
    <ul>
        <c:forEach var="personne" items="${pers}">
            <li>${personne.getName()} - ${personne.getAge()} ans</li>
        </c:forEach>
    </ul>
</body>
</html>
