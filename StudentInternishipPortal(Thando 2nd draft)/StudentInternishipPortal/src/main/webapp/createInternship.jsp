<%-- 
    Document   : createInternship
    Created on : 21 Aug 2026, 18:15:11
    Author     : black
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Internship</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body class="dashboard">
        
        <nav style="margin-bottom: 20px;"> 
            <a href="register.jsp">Register</a>
            <a href="login.jsp">Login</a>
            <a href="adminDashboard.jsp">Dashboard</a>
            <a href="logoutServlet">Logout</a> 
        </nav>
        
        <div class="card">
            <h1>Create Internship</h1>
            <form action="createServlet" method="post">
                <label>Internship name: </label><input type="text" name="internshipname"><br>
                <label>Company: </label><input type="text" name="company"><br>
                <label>Province: </label><input type="text" name="province"><br>
                <label>Location: </label><input type="text" name="location"><br>
                <label>Decription:</label> <input type="text" name="description"><br>
                <p>${err1}</p>
                <input type="submit">
            </form>
        </div>
    </body>
</html>
