/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ThandolwethuNdlovu;

import static ThandolwethuNdlovu.createServlet.internships;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author thobi
 */
public class loginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        //admin login
        if ("admin".equals(username) && "Demo1234".equals(password)) {

        request.getSession().setAttribute("username", username);

        response.sendRedirect("adminDashboard.jsp");
        return;
        }
        
        // check if all fields are filled
        if (username == null || username.trim().isEmpty() ||
        password == null || password.isEmpty() ) {

        request.setAttribute("err1", "All fields must be filled");
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
        rd.forward(request, response);
        return;
        }
        
        //check if user exists

        for (String[][] student : internships) {
            for (String[] rows : student){
                

                    // Check username and password
                    if (username.equals(rows[0])
                            && password.equals(rows[2])) {

                        // Store username to use in Dashboard
                        request.getSession().setAttribute("username", student[0]);
                        response.sendRedirect("stuDashboard.jsp");
                        }
                   
            }
        }
        

        
        // if user is not found
        request.setAttribute("err1", "Invalid username or password");

        RequestDispatcher rd =
                request.getRequestDispatcher("login.jsp");

        rd.forward(request, response);
        
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
