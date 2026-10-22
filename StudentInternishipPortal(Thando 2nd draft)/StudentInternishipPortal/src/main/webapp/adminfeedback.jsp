<%-- 
    Document   : adminfeedback
    Created on : 14 Aug 2026, 00:18:18
    Author     : thobi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Feedback</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body class="dashboard">
        
        <nav style="margin-bottom: 20px;">
            <a href="register.jsp">Register</a>
            <a href="login.jsp">Login</a>
            <a href="stuDashboard.jsp">Dashboard</a>
            <a href="logoutServlet">Logout</a> 
        </nav>
        
        <div class="card">            
        
            <form action="updatestatusServlet" method="get">
                <h1>This is admin feedback</h1>
                <p>Enter the name you used on your applications</p><br><br>
                <lable>Name: </lable><input type="text" name="name"><br>
                <lable>Internship name: </lable><input type="text" name="intname"><br>
                <p>${err1}</p><br>    
                <lable>Statues: </lable>${statues}
            
                <br><input type="submit">
            </form>
        </div>
    </body>
</html>
