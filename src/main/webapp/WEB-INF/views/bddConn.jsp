<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Entity.Voiture" %>
<html>
<head>
    <title>Liste des voitures de la BDD</title>
</head>
<body>
<h1>Liste des Voitures</h1>
<table>
    <tr>
        <th>Marque</th>
        <th>Modèle</th>
    </tr>
    <%
        ArrayList<Voiture> voitures = (ArrayList<Voiture>) request.getAttribute("voitures");
        if (voitures != null) {
            for (Voiture voiture : voitures) {
    %>
    <tr>
        <td><%= voiture.getMarque() %></td>
        <td><%= voiture.getModel() %></td>
    </tr>
    <%
            }
        }
    %>
</table>
</body>
</html>