<%-- 
    Document   : adminDashboard
    Created on : 21 Aug 2026, 17:27:55
    Author     : black
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Dashboard</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body class="dashboard">
        <nav style="margin-bottom: 20px;">
            <a href="register.jsp">Register</a> | 
            <a href="login.jsp">Login</a> | 
            <a href="adminDashboard.jsp">Dashboard</a>
        </nav>

        <div class="card">
            <h1>Welcome ${username}</h1>
            <nav style="margin-top: 20px; display: flex; flex-direction: column; gap: 12px;">
                <a href="manageInternships.jsp">Manage internship listings</a>
                <a href="appliedstudents.jsp">View applications</a>
                <a href="logoutServlet">Logout</a>
            </nav>
        </div>
    </body>
</html>
