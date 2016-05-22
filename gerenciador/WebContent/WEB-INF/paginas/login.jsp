<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<c:if test="${usuarioLogado != null}">
   Usuário logado: ${usuarioLogado.email}
</c:if>
</body>
</html>