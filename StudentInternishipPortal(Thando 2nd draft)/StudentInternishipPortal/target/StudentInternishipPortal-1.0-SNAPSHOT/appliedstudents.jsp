<%-- 
    Document   : appliedstudents
    Created on : 23 Aug 2026, 19:30:44
    Author     : thobi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>

<head>
    <title>Student Applications</title>
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
        
        
            <form action="aspageServlet" method="get">
                <h1>Applied Students</h1>

                <p>${message}</p>

            
                <p>Internship: ${internshipname}</p>

                <p>Student: ${student}</p>

                <p>Current Status: ${status}</p>

            
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
                        <a href="aspageServlet?page=<%= num - 1 %>">Previous Page</a>
                <%
                    }
                %>
            
                        <a href="aspageServlet?page=<%= num + 1 %>">Next Page</a>
            
                
            </form>


        <form action="updatestatusServlet"
              method="post">

            <input type="hidden"
                   name="username"
                   value="${student}">

            <input type="hidden"
                   name="internshipname"
                   value="${internshipname}">

            <select name="status">

                <option value="Pending">
                    Pending
                </option>

                <option value="Accepted">
                    Accepted
                </option>

                <option value="Rejected">
                    Rejected
                </option>

            </select>

            <input type="submit"
                   value="Update Status">

        </form>
     </div>

        <hr>



</body>

</html>
