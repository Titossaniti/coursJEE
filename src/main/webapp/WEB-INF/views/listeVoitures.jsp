<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Voitures via Hibernate</title>
</head>
<body>
<h1>Liste des Voitures</h1>
<p>${voitures}</p>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Marque</th>
        <th>Model</th>
    </tr>
    <c:forEach var="voiture" items="${voitures}">
        <tr>
            <td>${voiture.getId()}</td>
            <td>${voiture.getMarque()}</td>
            <td>${voiture.getModel()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
