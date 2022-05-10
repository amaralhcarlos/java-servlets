<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/listaEmpresasJSTL" var="listaEmpresasLink" />
<html>
<head>
<title>Bem-vindo</title>
</head>


<body>
	<h1>Bem-vindo</h1>
	<p>Curso de Servlets - Alura</p>

	<br />
	<br />
	<a href="${listaEmpresasLink }">Lista de empresas</a>
</body>


</html>