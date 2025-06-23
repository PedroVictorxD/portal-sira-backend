<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Ocorrência - Formulário</title>
</head>
<body>
<h2>${ocorrencia.id == null ? 'Nova Ocorrência' : 'Editar Ocorrência'}</h2>
<form method="post" action="${ocorrencia.id == null ? pageContext.request.contextPath.concat('/ocorrencias') : pageContext.request.contextPath.concat('/ocorrencias/editar/').concat(ocorrencia.id)}">
    <label>Título:<br>
        <input type="text" name="titulo" value="${ocorrencia.titulo}" required maxlength="100" />
    </label><br><br>
    <label>Descrição:<br>
        <textarea name="descricao" rows="4" cols="40" required>${ocorrencia.descricao}</textarea>
    </label><br><br>
    <button type="submit">Salvar</button>
    <a href="${pageContext.request.contextPath}/ocorrencias">Cancelar</a>
</form>
</body>
</html> 