<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Chamados - Portal Sira</title>
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
        .chamado-lista {
            margin-bottom: 2rem;
        }
        .chamado-card {
            background: #f4f9fb;
            border-left: 5px solid #2980b9;
            border-radius: 8px;
            margin-bottom: 1.2rem;
            padding: 1rem 1.2rem;
            box-shadow: 0 2px 8px 0 rgba(41, 128, 185, 0.07);
        }
        .chamado-card .titulo {
            font-weight: bold;
            color: #2573a6;
            font-size: 1.1rem;
        }
        .chamado-card .descricao {
            margin: 0.5rem 0 0.7rem 0;
            color: #444;
        }
        .chamado-card .info {
            font-size: 0.95rem;
            color: #888;
        }
        .novo-chamado-form {
            background: #eaf6fb;
            border-radius: 8px;
            padding: 1.2rem 1rem 1rem 1rem;
            box-shadow: 0 1px 4px 0 rgba(41, 128, 185, 0.05);
        }
        .novo-chamado-form input[type="text"],
        .novo-chamado-form textarea,
        .novo-chamado-form select {
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
        .novo-chamado-form input[type="text"]:focus,
        .novo-chamado-form textarea:focus,
        .novo-chamado-form select:focus {
            border: 1.5px solid #2980b9;
        }
        .novo-chamado-form button {
            padding: 0.7rem 1.5rem;
            background: #2980b9;
            color: #fff;
            border: none;
            border-radius: 6px;
            font-size: 1rem;
            cursor: pointer;
            transition: background 0.2s;
        }
        .novo-chamado-form button:hover {
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
    </style>
</head>
<body>
<div class="container">
    <a href="/logout" class="logout-link">Sair</a>
    <h2>Chamados</h2>
    <div class="chamado-lista">
        <c:forEach var="c" items="${chamados}">
            <div class="chamado-card">
                <div class="titulo">${c.titulo} <span style="font-size:0.9em; color:#888;">(${c.tipo})</span></div>
                <div class="descricao">${c.descricao}</div>
                <div class="info">Por ${c.usuarioAbertura.nome} para ${c.destinatario} em ${c.dataHoraAbertura} - Status: ${c.status}</div>
            </div>
        </c:forEach>
        <c:if test="${empty chamados}">
            <div style="color:#888; text-align:center;">Nenhum chamado registrado ainda.</div>
        </c:if>
    </div>
    <form class="novo-chamado-form" method="post" action="/chamados">
        <h3>Novo Chamado</h3>
        <input type="text" name="titulo" placeholder="Título" maxlength="100" required />
        <textarea name="descricao" placeholder="Descrição" rows="4" maxlength="1000" required></textarea>
        <input type="text" name="destinatario" placeholder="Destinatário (nome, email ou empresa)" maxlength="100" required />
        <select name="tipo" required>
            <option value="interno">Interno</option>
            <option value="externo">Externo</option>
        </select>
        <button type="submit">Abrir Chamado</button>
    </form>
</div>
</body>
</html> 