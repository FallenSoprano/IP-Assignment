<%-- 
    Document   : Dashboard
    Created on : 13 Aug 2026, 23:48:08
    Author     : thobi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body class="dashboard">
        <nav style="margin-bottom: 20px;">
            <a href="register.jsp">Register</a>
            <a href="login.jsp">Login</a>
            <a href="stuDashboard.jsp">Dashboard</a>
        </nav>
        
        <div class="card">
            <h1>Welcome ${username}</h1>
            <nav style="margin-top: 20px; display: flex; flex-direction: column; gap: 12px;">
                <a href="createprofile.jsp">Create/Update Profile</a><br>
                <a href="profile.jsp">View Profile</a><br>
                <a href="apply.jsp">Apply for Internships</a><br>
                <a href="trackapplications.jsp">View Applications</a><br>
                <a href="adminfeedback.jsp">Read administrator feedback</a> 
                <a href="logoutServlet">Logout</a> 
            </nav>
        </div>
    </body>
</html>
