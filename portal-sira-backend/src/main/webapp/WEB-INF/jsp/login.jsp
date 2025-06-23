<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <title>Login - Portal Sira</title>
    <style>
        body {
            background: linear-gradient(120deg, #2980b9, #6dd5fa);
            height: 100vh;
            margin: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            font-family: 'Segoe UI', Arial, sans-serif;
        }
        .login-container {
            background: #fff;
            padding: 2.5rem 2rem;
            border-radius: 12px;
            box-shadow: 0 8px 32px 0 rgba(31, 38, 135, 0.2);
            width: 340px;
            display: flex;
            flex-direction: column;
            align-items: center;
        }
        .login-container h2 {
            margin-bottom: 1.5rem;
            color: #2980b9;
        }
        .login-container form {
            width: 100%;
            display: flex;
            flex-direction: column;
        }
        .login-container input[type="text"],
        .login-container input[type="password"] {
            padding: 0.7rem;
            margin-bottom: 1rem;
            border: 1px solid #b2bec3;
            border-radius: 6px;
            font-size: 1rem;
            outline: none;
            transition: border 0.2s;
        }
        .login-container input[type="text"]:focus,
        .login-container input[type="password"]:focus {
            border: 1.5px solid #2980b9;
        }
        .login-container button {
            padding: 0.7rem;
            background: #2980b9;
            color: #fff;
            border: none;
            border-radius: 6px;
            font-size: 1rem;
            cursor: pointer;
            transition: background 0.2s;
        }
        .login-container button:hover {
            background: #2573a6;
        }
        .error-message {
            color: #e74c3c;
            margin-bottom: 1rem;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="login-container">
    <h2>Portal Sira</h2>
    <form method="post" action="/login">
        <c:if test="${not empty error}">
            <div class="error-message">${error}</div>
        </c:if>
        <input type="text" name="username" placeholder="Usuário" required autofocus />
        <input type="password" name="password" placeholder="Senha" required />
        <button type="submit">Entrar</button>
    </form>
</div>
</body>
</html> 