<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
    <%@include file="WEB-INF/views/menu.jsp"%>
    <h2>Hello World!!!</h2>

    <h2>Formulaire</h2>
    <form action="afficherPersonnes" method="post">
        <label for="transmittedValue">Contenu :</label>
        <input type="text" id="transmittedValue" name="transmittedValue">
        <button type="submit">Envoyer</button>
    </form>
    <a href="${pageContext.request.contextPath}/bddConn">Se connecter à la BDD</a>
</body>
</html>