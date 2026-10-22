<%-- 
    Document   : register
    Created on : 13 Aug 2026, 23:20:46
    Author     : thobi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body class="register">
        <div class="card">
            <h1>Register</h1>
            <form action="registerServlet" method="post">
                <label>Username:</label><input type="text" name="username"><br>
                <label>Email:</label><input type="email" name="email"><br>
                <label>Password:</label><input type="password" name="password"><br>
                <label>Confirm Password:</label><input type="password" name="confirmpassword"><br>
                <p style="color: red">${err1}</p>
                <input type="submit" value="Register">
            </form>
        </div>
    </body>
</html>
