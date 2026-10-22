<%-- 
    Document   : trackapplications
    Created on : 13 Aug 2026, 23:42:46
    Author     : thobi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import= "java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Internship Applications</title>
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
            
        <form action="tapageServlet" method="get">
            <h1>My Applications</h1>
        
            <label>Name: </label><input type="text" name="name" placeholder="Enter your name"><br>
            <p>${err1}</p>
            <input type="submit" value="Search"><br>
        
            <p>${message}</p>

            <p>Internship: ${intname}</p>

            <p>Company: ${company}</p>

            <p>Status: ${status}</p>

            
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
            <a href="tapageServlet?page=<%= num - 1 %>">Previous Page</a>
            <%
                }
            %>
            
            <a href="tapageServlet?page=<%= num + 1 %>">Next Page</a>
            </form>
        
        
        </div>
        
    </body>
</html>
