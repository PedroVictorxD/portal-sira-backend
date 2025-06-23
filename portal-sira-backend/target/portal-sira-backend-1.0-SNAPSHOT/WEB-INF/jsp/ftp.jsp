<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>FTP - Portal Sira</title>
    <style>
        body {
            background: linear-gradient(120deg, #6dd5fa, #2980b9);
            min-height: 100vh;
            margin: 0;
            font-family: 'Segoe UI', Arial, sans-serif;
        }
        .container {
            max-width: 500px;
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
        .ftp-form {
            background: #eaf6fb;
            border-radius: 8px;
            padding: 1.2rem 1rem 1rem 1rem;
            box-shadow: 0 1px 4px 0 rgba(41, 128, 185, 0.05);
            display: flex;
            flex-direction: column;
        }
        .ftp-form input[type="file"] {
            margin-bottom: 1rem;
        }
        .ftp-form button {
            padding: 0.7rem 1.5rem;
            background: #2980b9;
            color: #fff;
            border: none;
            border-radius: 6px;
            font-size: 1rem;
            cursor: pointer;
            transition: background 0.2s;
        }
        .ftp-form button:hover {
            background: #2573a6;
        }
        .mensagem {
            margin-top: 1rem;
            color: #2980b9;
            text-align: center;
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
    <h2>Transferência de Arquivos (FTP)</h2>
    <form class="ftp-form" method="post" action="/ftp/upload" enctype="multipart/form-data">
        <input type="file" name="arquivo" required />
        <button type="submit">Enviar Arquivo</button>
    </form>
    <c:if test="${not empty mensagem}">
        <div class="mensagem">${mensagem}</div>
    </c:if>
</div>
</body>
</html> 