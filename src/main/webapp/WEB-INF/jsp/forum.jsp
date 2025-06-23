<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Fórum de Ocorrências - Portal Sira</title>
    <style>
        body {
            background: linear-gradient(120deg, #6dd5fa, #2980b9);
            min-height: 100vh;
            margin: 0;
            font-family: 'Segoe UI', Arial, sans-serif;
        }
        .container {
            max-width: 900px;
            margin: 40px auto;
            background: #fff;
            border-radius: 12px;
            box-shadow: 0 8px 32px 0 rgba(31, 38, 135, 0.2);
            padding: 2rem 2.5rem 2.5rem 2.5rem;
        }
        h2 {
            color: #2980b9;
            margin-bottom: 1.5rem;
        }
        .ocorrencia-lista {
            margin-bottom: 2rem;
        }
        .ocorrencia-card {
            background: #f4f9fb;
            border-left: 5px solid #2980b9;
            border-radius: 8px;
            margin-bottom: 1.2rem;
            padding: 1rem 1.2rem;
            box-shadow: 0 2px 8px 0 rgba(41, 128, 185, 0.07);
        }
        .ocorrencia-card .titulo {
            font-weight: bold;
            color: #2573a6;
            font-size: 1.1rem;
        }
        .ocorrencia-card .descricao {
            margin: 0.5rem 0 0.7rem 0;
            color: #444;
        }
        .ocorrencia-card .info {
            font-size: 0.95rem;
            color: #888;
        }
        .comentarios-section {
            background: #eaf6fb;
            border-radius: 8px;
            padding: 1rem;
            margin-top: 1.2rem;
        }
        .comentario {
            border-bottom: 1px solid #d0e6f7;
            padding: 0.7rem 0;
        }
        .comentario:last-child {
            border-bottom: none;
        }
        .comentario .autor {
            font-weight: bold;
            color: #2573a6;
        }
        .comentario .data {
            font-size: 0.9em;
            color: #888;
            margin-left: 0.7em;
        }
        .comentario .texto {
            margin-top: 0.2em;
            color: #333;
        }
        .novo-comentario-form {
            margin-top: 1.2rem;
            background: #f9fcff;
            border-radius: 8px;
            padding: 1rem;
            box-shadow: 0 1px 4px 0 rgba(41, 128, 185, 0.05);
        }
        .novo-comentario-form textarea {
            width: 100%;
            padding: 0.7rem;
            margin-bottom: 1rem;
            border: 1px solid #b2bec3;
            border-radius: 6px;
            font-size: 1rem;
            outline: none;
            transition: border 0.2s;
            resize: none;
        }
        .novo-comentario-form textarea:focus {
            border: 1.5px solid #2980b9;
        }
        .novo-comentario-form button {
            padding: 0.7rem 1.5rem;
            background: #2980b9;
            color: #fff;
            border: none;
            border-radius: 6px;
            font-size: 1rem;
            cursor: pointer;
            transition: background 0.2s;
        }
        .novo-comentario-form button:hover {
            background: #2573a6;
        }
        .logout-link {
            float: right;
            color: #e74c3c;
            text-decoration: none;
            font-size: 1rem;
            margin-top: -2.5rem;
        }
        .logout-link:hover {
            text-decoration: underline;
        }
        .detalhes-link {
            float: right;
            font-size: 0.95em;
            color: #2980b9;
            text-decoration: underline;
            margin-left: 1em;
        }
    </style>
</head>
<body>
<div class="container">
    <a href="/logout" class="logout-link">Sair</a>
    <h2>Fórum de Ocorrências</h2>
    <div class="ocorrencia-lista">
        <c:choose>
            <c:when test="${not empty ocorrencias}">
                <c:forEach var="o" items="${ocorrencias}">
                    <div class="ocorrencia-card">
                        <div class="titulo">${o.titulo}
                            <a href="/forum/${o.id}" class="detalhes-link">Detalhes</a>
                        </div>
                        <div class="descricao">${o.descricao}</div>
                        <div class="info">Por ${o.usuario.nome} em ${o.dataHora}</div>
                    </div>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <div style="color:#888; text-align:center;">Nenhuma ocorrência registrada ainda.</div>
            </c:otherwise>
        </c:choose>
    </div>

    <c:if test="${not empty ocorrencia}">
        <div class="ocorrencia-card">
            <div class="titulo">${ocorrencia.titulo}</div>
            <div class="descricao">${ocorrencia.descricao}</div>
            <div class="info">Por ${ocorrencia.usuario.nome} em ${ocorrencia.dataHora}</div>
        </div>
        <div class="comentarios-section">
            <h3>Comentários</h3>
            <c:choose>
                <c:when test="${not empty comentarios}">
                    <c:forEach var="c" items="${comentarios}">
                        <div class="comentario">
                            <span class="autor">${c.usuario.nome}</span>
                            <span class="data">${c.dataHora}</span>
                            <div class="texto">${c.texto}</div>
                        </div>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <div style="color:#888;">Nenhum comentário ainda.</div>
                </c:otherwise>
            </c:choose>
            <form class="novo-comentario-form" method="post" action="/forum/${ocorrencia.id}/comentar">
                <textarea name="texto" placeholder="Escreva um comentário..." rows="3" maxlength="1000" required></textarea>
                <button type="submit">Comentar</button>
            </form>
        </div>
        <div style="margin-top:1.5rem;"><a href="/forum">Voltar para lista de ocorrências</a></div>
    </c:if>
</div>
</body>
</html> 