<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<c:if test="${usuarioLogado != null}">
   Usu�rio logado: ${usuarioLogado.email}
</c:if>
</body>
</html>