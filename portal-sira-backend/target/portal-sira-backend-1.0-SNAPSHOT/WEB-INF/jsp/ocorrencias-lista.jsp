<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Ocorrências - Fórum</title>
</head>
<body>
<h2>Ocorrências</h2>
<a href="${pageContext.request.contextPath}/ocorrencias/nova">Nova Ocorrência</a>
<table border="1" cellpadding="8">
    <tr>
        <th>Título</th>
        <th>Descrição</th>
        <th>Autor</th>
        <th>Data/Hora</th>
        <th>Ações</th>
    </tr>
    <c:forEach var="o" items="${ocorrencias}">
        <tr>
            <td><a href="${pageContext.request.contextPath}/ocorrencias/${o.id}">${o.titulo}</a></td>
            <td>${o.descricao}</td>
            <td>${o.usuario.nome}</td>
            <td>${o.dataHora}</td>
            <td>
                <a href="${pageContext.request.contextPath}/ocorrencias/editar/${o.id}">Editar</a> |
                <a href="${pageContext.request.contextPath}/ocorrencias/excluir/${o.id}" onclick="return confirm('Tem certeza que deseja excluir?');">Excluir</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html> 