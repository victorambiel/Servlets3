<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
Bem vindo ao nosso gerenciador de empresas!<br/>

<c:if test="${usuarioLogado != null}">
   </br>
   Você está logado como: ${usuarioLogado.email} </br></br>
</c:if>

<form action="executa?tarefa=NovaEmpresa" method="POST">
   Nome: <input type="text" name="nome">  
   <input type="submit" value="Enviar">
</form>

<form action="executa?tarefa=Login" method="POST">
	E-mail: <input type="email" name="email"/>
	Senha: <input type="password" name="senha"/>
	<input type="submit" value="Enviar"/>
</form>

<form action="executa" method="POST">
   <input type="hidden" name="tarefa" value="Logout">
   <input type="submit" value="Logout">
</form>

</body>
</html>