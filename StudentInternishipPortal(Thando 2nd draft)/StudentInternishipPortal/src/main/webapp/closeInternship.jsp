<%-- 
    Document   : closeInternship
    Created on : 21 Aug 2026, 18:16:08
    Author     : black
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Close Internship</title>
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
            <form action="pageServlet" method="get">
                <h1>Close Internship</h1>

            <p>${message}</p>

           
            <p>Internship Name: ${internshipname}</p>

            <p>Company: ${company}</p>

            <p>province: ${province}</p>

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
            <a href="pageServlet?page=<%= num - 1 %>">Previous Page</a>
            <%
                }
            %>
            
            <a href="pageServlet?page=<%= num + 1 %>">Next Page</a>
            
            </form>
        </div><br>
        
            <div class="card">
            
            <form action="closeServlet" method="post">
                <label>Internship name: </label><input type="text" name="internshipname"><br>
                <label>Company: </label><input type="text" name="company"><br>
                <p>${err1}</p>
                <input type="search" value="Search">
            
                <p>Page ${Page}</p>
              
            </form>
            
        </div>
    </body>
</html>
