<%@ page import="java.util.List, gerenciador.Banco, gerenciador.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista empresas com JSTL</title>
<%
List<Empresa> empresas = (List<Empresa>) request.getAttribute("empresas");
%>
</head>
<body>


	<H3>Empresas Cadastradas</H3>
	<%
	if (empresas.size() > 0) {
	%><TABLE>
		<TR>
			<TH>ID</TH>
			<TH>Nome da Empresa</TH>
		</TR>

		<c:forEach items="${ empresas }" var="empresa">
			<TR>
				<TD>${ empresa.id }</TD>
				<TD>${ empresa.nome }</TD>
			</TR>
		</c:forEach>

	</TABLE>
	<%
	} else {
	%>
	<H2>Não existem empresas cadastradas nesse momento.</H2>
	<%
	}
	%>


</body>
</html>