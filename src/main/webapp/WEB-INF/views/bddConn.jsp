<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Entity.Voiture" %>
<html>
<head>
    <title>Liste des voitures de la BDD</title>
</head>
<body>
<h2>Ajouter une Voiture</h2>
<form action="AddCar" method="post">
    <label for="marque">Marque:</label>
    <input type="text" id="marque" name="marque" required><br><br>
    <label for="model">Modèle:</label>
    <input type="text" id="model" name="model" required><br><br>
    <input type="submit" value="Ajouter">
</form>
<h2>Liste des Voitures</h2>
<table border="1">
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