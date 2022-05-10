<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:url value="/editaEmpresa?id=" var="linkEditaEmpresaServlet" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Editar empresa</title>
</head>
<body>

	<form action="${linkEditaEmpresaServlet}${empresa.id}" method="post">

		<label for="nomeEmpresa">Nome da Empresa: </label> <input type="text"
			name="nomeEmpresa" value="${empresa.nome }" required /><br> <br>
		
		<label for="dataAberturaEmpresa">Data de Abertura: </label> 
		<input
			type="date" name="dataAberturaEmpresa" required
			value="<fmt:formatDate value="${empresa.dataAbertura }" pattern="yyyy-MM-dd"/>" />
		<br> <br>
		
		<input type="submit" />

	</form>

</body>
</html>