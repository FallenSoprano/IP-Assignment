<%-- 
    Document   : createprofile
    Created on : 14 Aug 2026, 00:16:55
    Author     : thobi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create profile</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body class="dashboard">
        
        <nav style="margin-bottom: 20px;">
            <a href="register.jsp">Register</a>
            <a href="login.jsp">Login</a>
            <a href="stuDashboard.jsp">Dashboard</a>
            <a href="logoutServlet">Logout</a> 
        </nav>
        
        <h1>Here you create a Student profile</h1>
        <div class="card">
            <h1>Applicant Profile</h1>
            <form action="studentprofileServlet" method="post" enctype="multipart/form-data">
                
                <label>First Name:</label><input type="text" name="firstname"><br>
                <p style="color: red">${err1}</p>
                <label>Last Name:</label><input type="text" name="lastname"><br>
                <p style="color: red">${err2}</p>
                <label>Date of Birth:</label><input type="date" name="dob"><br>
                <p style="color: red">${err3}</p>
                <label>ID number:</label><input type="text" name="idnumber"><br>
                <p style="color: red">${err4}</p>
                <label>Gender:</label><br>
                <label>Male:</label><input type="radio" name="gender" value="Male">
                <label>Female:</label><input type="radio" name="gender" value="Female">
                <label>Other:</label><input type="radio" name="gender" value="Other"><br>
                <p style="color: red">${err5}</p>
                <label>Province:</label>
                <select name="province">
                    <option>Select Province</option>
                    <option value="Limpopo">Limpopo</option>
                    <option value="Free State">Free State</option>
                    <option value="Mpumalanga">Mpumalanga</option>
                    <option value="KwaZulu Natal">KwaZulu Natal</option>
                    <option value="Western Cape">Western Cape</option>
                    <option value="Gauteng">Gauteng</option>
                    <option value="Eastern Cape">Eastern Cape</option>
                    <option value="Northern Cape">Northern Cape</option>
                    <option value="North West">North West</option>
                </select><br>
                <p style="color: red">${err6}</p>
                <label>Qualification:</label><input type="text" name="qualification"><br>
                <p style="color: red">${err7}</p>
                <label>Skills:</label><input type="text" name="skills"><br><br>
                <p style="color: red">${err8}</p>
                
                <button>Upload CV</button><input type="file" name="CV" accept=".pdf">
                <p>Must be PDF up to 2MB</p>
                <p style="color: red">${err9}</p>
                <input type="submit"><br><br>
            </form>
            
        </div>
    </body>
</html>
