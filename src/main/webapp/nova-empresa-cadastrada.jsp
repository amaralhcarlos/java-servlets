<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nova empresa cadastrada</title>

<%
String nomeEmpresa = (String) request.getAttribute("nomeEmpresa");
%>
</head>
<body>

	<P>
		Cadastro da empresa
		<%=nomeEmpresa%>
		efetuado com sucesso
	</P>

</body>
</html>