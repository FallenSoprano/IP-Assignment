<%-- 
    Document   : studentapplyServlet
    Created on : 13 Aug 2026, 23:38:50
    Author     : thobi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Internship Application</title>
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
        <form action="apageServlet" method="get">
            <h1>My Applications</h1>
        
            <label>Province: </label><input type="text" name="province" placeholder="Search by Province">
            <p>${err1}</p>
            <input type="submit" value="Search"><br>
        
            <p>${message}</p>

            <p>Company: ${company}</p>

            <p>Province: ${province}</p>

            <p>Location: ${location}</p>
            
            <p>Description: ${description}</p>

            
            <p>Page ${page}</p>
            
            <%
                String pageParam = request.getParameter("page");
                int num = 1; // default to page 1 if parameter is missing
                if (pageParam != null && !pageParam.isEmpty()) {
                try {
                    num = Integer.parseInt(pageParam);
                        } catch (NumberFormatException e) {
                            num = 1; // if invalid, default to 1
                        }
                    }
                if(num == 1) {
            %>
            <a href="apageServlet?page=<%= num - 1 %>">Previous Page</a>
            <%
                }
            %>
            
            <a href="apageServlet?page=<%= num + 1 %>">Next Page</a>
        </form>
        
        </div><br>
        
        <div class="card">
            
            <form action="applyServlet" method="get">
                <p>Enter the details of the internship you want to apply to</p><br>
                <label>Username: </label><input type="text" name="username"><br>
                <label>Company: </label><input type="text" name="company"><br>
                <label>Internship Name: </label><input type="text" name="internshipname"><br>
                <p>${err1}</p><br>
                <input type="submit" value="Apply">
            </form>
        </div>
        
    </body>
  
</html>
