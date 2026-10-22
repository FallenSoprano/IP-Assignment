<%-- 
    Document   : profile
    Created on : 13 Aug 2026, 23:30:48
    Author     : thobi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Profile</title>
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
            <h1>Student Profile</h1>
            
            <form action="studentprofileServlet" method="get">
                
                <p>Please enter your name and ID number</p><br><br>
                <label>Name: </label><input type="text" name="name"><br>
                <p>${err1}</p>
                <label>ID: </label><input type="text" name = "idnumber"><br>
                <p>${err2}</p>
                <input type="submit">
                
                <label>First Name: </label> ${firstname}
                <label>Last Name: </label> ${lastname}
                <label>Date Of Birth: </label> ${dob}
                <label>ID number: </label> ${idnumber}
                <label>Gender: </label> ${gender}
                <label>Province: </label> ${province}
                <label>Qualification: </label> ${qualification}
                <label>Skills: </label> ${skills}
                
            </form>
            
        </div>
    </body>
</html>
