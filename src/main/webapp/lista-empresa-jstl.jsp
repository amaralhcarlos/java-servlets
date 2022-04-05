<%@ page import="java.util.List,model.Banco,model.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="totalEmpresas" scope="session" value="${empresas.size() }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista empresas com JSTL</title>
</head>
<body>

	<H3>Empresas Cadastradas</H3>

	<c:if test="${totalEmpresas > 0}">
		<TABLE>
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
	</c:if>

	<c:if test="${ totalEmpresas == 0}">
		<H2>N�o existem empresas cadastradas nesse momento.</H2>
	</c:if>

</body>
</html>