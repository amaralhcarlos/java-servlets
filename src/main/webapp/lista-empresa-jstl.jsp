<%@ page import="java.util.List,model.Banco,model.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="totalEmpresas" scope="session" value="${empresas.size() }" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista empresas com JSTL</title>
</head>
<body>

	<c:if test="${not empty nomeEmpresa }">
		<P>Cadastro da empresa ${nomeEmpresa} efetuado com sucesso!</P>
	</c:if>

	<H3>Empresas Cadastradas</H3>

	<c:if test="${totalEmpresas > 0}">
		<TABLE>
			<TR>
				<TH>ID</TH>
				<TH>Nome da Empresa</TH>
				<TH>Data da Abertura</TH>
			</TR>

			<c:forEach items="${ empresas }" var="empresa">
				<TR>
					<TD>${ empresa.id }</TD>
					<TD>${ empresa.nome }</TD>
					<TD><fmt:formatDate value="${empresa.dataAbertura }"
							pattern="dd/MM/yyyy" /></TD>
				</TR>
			</c:forEach>

		</TABLE>
	</c:if>

	<c:if test="${ totalEmpresas == 0}">
		<H2>N�o existem empresas cadastradas nesse momento.</H2>
	</c:if>

</body>
</html>