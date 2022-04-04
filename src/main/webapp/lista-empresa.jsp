<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista empresas</title>
<%@ page import="java.util.List, gerenciador.Banco, gerenciador.Empresa"%>
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
		<%
		for (Empresa empresa : empresas) {
		%>
		<TR>
			<TD><%=empresa.getId()%></TD>
			<TD><%=empresa.getNome()%>"</TD>
		</TR>
		<%
		}
		%>
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