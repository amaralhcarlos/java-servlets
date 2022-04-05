<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Nova empresa cadastrada</title>

</head>
<body>

	<c:if test="empty nomeEmpresa">
		<p>Nenhuma empresa foi cadastrada!</p>
	</c:if>

	<c:if test="not empty nomeEmpresa">
		<P>Cadastro da empresa ${nomeEmpresa} efetuado com sucesso!</P>
	</c:if>

</body>
</html>