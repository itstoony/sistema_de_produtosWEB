
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/entrada" var="linkInicioServlet"/>
<c:url value="/entrada?acao=CadastroForm" var="linkCadastroForm"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Formulário de Login</title>
</head>
<body>
<form action="${linkInicioServlet}" method="post">
Login: <input type="text" name="login"/> <br>
Senha: <input type="password" name="senha"/> <br>

<input type="hidden" name="acao" value="Login"/> <br>
<input type="submit" value="Login"> <a href="${linkCadastroForm}">CADASTRO</a>
</form>


</body>
</html>
