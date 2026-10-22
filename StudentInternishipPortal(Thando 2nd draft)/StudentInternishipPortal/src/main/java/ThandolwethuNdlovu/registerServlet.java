/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ThandolwethuNdlovu;

import static ThandolwethuNdlovu.createServlet.internships;
import java.util.ArrayList;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author thobi
 */
public class registerServlet extends HttpServlet {
    
     public static ArrayList<String[][]> students = new ArrayList<>();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    String username = request.getParameter("username");
    String email = request.getParameter("email");
    String password = request.getParameter("password");
    String confirmpassword = request.getParameter("confirmpassword");

    // Check if fields are empty
    if (username.trim().isEmpty() ||
        email.trim().isEmpty() ||
        password.isEmpty() ||
        confirmpassword.isEmpty()) {

        request.setAttribute("err1", "All fields must be filled");

        RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
        rd.forward(request, response);
        return;
    }

    // Check password length
    if (password.length() < 6) {

        request.setAttribute("err1", "Password is too short");

        RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
        rd.forward(request, response);
        return;
    }

    // Check email
    if (!email.contains("@") || !email.contains(".")) {

        request.setAttribute("err1", "Invalid email address");

        RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
        rd.forward(request, response);
        return;
    }

    // Check passwords
    if (!password.equals(confirmpassword)) {

        request.setAttribute("err1", "Passwords do not match");

        RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
        rd.forward(request, response);
        return;
    }
    

    for (String[][] student : internships) {
        for (String[] rows : student){
                
                if (rows[0].equalsIgnoreCase(username)){
                    request.setAttribute("err1","Username already exists");
                    RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
                    rd.forward(request, response);
                    return;
                }
                   
        }
    }
    
    
    
    // Create a new Student
    String[][] student= {{username,email,password}};
    students.add(student);
    // Save username to use in another jsp
    request.getSession().setAttribute("Students",students);
    
    
    // Registration successful
    response.sendRedirect("stuDashboard.jsp");
}

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
