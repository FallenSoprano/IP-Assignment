<%-- 
    Document   : Applications
    Created on : 26 Aug 2026, 20:27:13
    Author     : thobi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>

<head>
    <title>Internships</title>
</head>

<body>
    <!-- Students who have applied -->
    <h1>Available Internships</h1>

    <%
        ArrayList<String[]> internships =
            (ArrayList<String[]>)
            request.getAttribute("internships");

        if (internships == null
                || internships.isEmpty()) {
    %>

        <p>No internships available.</p>

    <%
        } else {

            for (String[] internship : internships) {
    %>

        <h2><%= internship[0] %></h2>

        <p>
            <b>Company:</b>
            <%= internship[1] %>
        </p>

        <p>
            <b>Province:</b>
            <%= internship[2] %>
        </p>

        <p>
            <b>Location:</b>
            <%= internship[3] %>
        </p>

        <p>
            <b>Description:</b>
            <%= internship[4] %>
        </p>

        <form action="applyServlet" method="post">

            <input type="hidden"
                   name="internshipname"
                   value="<%= internship[0] %>">

            <input type="submit"
                   value="Apply">

        </form>

        <hr>

    <%
            }
        }
    %>

    <br>


</body>

</html>
