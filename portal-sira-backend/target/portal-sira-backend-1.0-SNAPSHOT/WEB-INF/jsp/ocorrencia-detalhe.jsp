<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Detalhes da Ocorrência</title>
</head>
<body>
<h2>Detalhes da Ocorrência</h2>
<p><b>Título:</b> ${ocorrencia.titulo}</p>
<p><b>Descrição:</b> ${ocorrencia.descricao}</p>
<p><b>Autor:</b> ${ocorrencia.usuario.nome}</p>
<p><b>Data/Hora:</b> ${ocorrencia.dataHora}</p>
<a href="${pageContext.request.contextPath}/ocorrencias/editar/${ocorrencia.id}">Editar</a> |
<a href="${pageContext.request.contextPath}/ocorrencias/excluir/${ocorrencia.id}" onclick="return confirm('Tem certeza que deseja excluir?');">Excluir</a> |
<a href="${pageContext.request.contextPath}/ocorrencias">Voltar</a>
<hr>
<h3>Comentários (Timeline)</h3>
<!-- Aqui será integrado o CRUD de comentários -->
<p>[Timeline de comentários aqui]</p>
</body>
</html> 