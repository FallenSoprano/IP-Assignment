<%-- 
    Document   : manageInternships
    Created on : 21 Aug 2026, 17:53:45
    Author     : black
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Internships</title>
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
            <h1>Manage Internships</h1>
             <a href="createInternship.jsp">
                 <button style="margin-bottom: 20px;">Create Internship</button><br>
            </a>
            <a href="closeInternship.jsp">
                <button style="margin-bottom: 20px;">Close Internship</button><br>
            </a>
            <a href="adminDashboard.jsp">
                <button style="margin-bottom: 20px;">Dashboard</button><br>
            </a>
        </div>
    </body>
</html>
