<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/novaEmpresa" var="linkNovaEmpresaServlet" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar nova empresa</title>
</head>
<body>

	<form action="${linkNovaEmpresaServlet}" method="post">

		<label for="nomeEmpresa">Nome da Empresa: </label>
		<input type="text" name="nomeEmpresa" required/><br><br>
		
		<label for="dataAberturaEmpresa">Data de Abertura: </label> 
		<input type="date" name="dataAberturaEmpresa" required/><br><br>
		
		 <input type="submit" />

	</form>

</body>
</html>