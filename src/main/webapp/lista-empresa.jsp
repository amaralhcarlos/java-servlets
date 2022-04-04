<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista empresas</title>
<%@ page import="java.util.List, gerenciador.Banco, gerenciador.Empresa"%>
</head>
<body>


	<H3>Empresas Cadastradas</H3>
	<%
	Banco banco = new Banco();
	List<Empresa> empresas = banco.getEmpresas();

	if (empresas.size() > 0) {

		out.println("<TABLE>");
		out.println("<TR><TH>ID</TH><TH>Nome da Empresa</TH></TR>");

		for (Empresa empresa : empresas) {
			out.println("<TR><TD>" + empresa.getId() + " </TD><TD> " + empresa.getNome() + " </TD></TR>");
		}

		out.println("</TABLE>");

	} else {
		out.println("<H2>Não existem empresas cadastradas nesse momento.</H2>");
	}
	%>

</body>
</html>