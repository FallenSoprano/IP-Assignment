<%-- 
    Document   : login
    Created on : 13 Aug 2026, 23:21:05
    Author     : thobi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body class="login">
        <div class="card">
            <h1>Login</h1>
            <form action="loginServlet" method="post">
                <label>Username:</label><input type="text" name="username"><br>
                <label>Password:</label><input type="password" name="password"><br>
                <p>${err1}</p>
                <input type="submit" value="Login">
            </form>
        </div>
    </body>
</html>
