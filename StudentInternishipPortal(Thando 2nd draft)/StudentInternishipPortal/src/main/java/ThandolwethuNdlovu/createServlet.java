/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ThandolwethuNdlovu;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author black
 */
public class createServlet extends HttpServlet {

    
    public static ArrayList<String[][]> internships = new ArrayList<>();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Provincial search
        String province = request.getParameter("province");

        ArrayList<String[][]> results = new ArrayList<>();

        // If the user did not search for a province,
        // show all internships
        if (province == null || province.trim().isEmpty()) {
            results = internships;
        } 
        else {
            
            for (String[][] internship : internships) {
                for (String[] rows : internship){
                        // Search by province
                        if (rows[2].equalsIgnoreCase(province.trim())) {
                            results.add(internship);
                        }   
                       
                }
            }
        
        }

        // send arraylist internships to apply.jsp
        request.setAttribute("internships",internships);
        
        RequestDispatcher rd = request.getRequestDispatcher("apply.jsp");
        rd.forward(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String internname = request.getParameter("internshipname");
        String company = request.getParameter("company");
        String location = request.getParameter("location");
        String province = request.getParameter("province");
        String description = request.getParameter("description");
        
        // Check if fields are empty
        if (internname == null || internname.trim().isEmpty()
                || company == null || company.trim().isEmpty()
                || province == null || province.trim().isEmpty()
                || location == null || location.trim().isEmpty()
                || description == null || description.trim().isEmpty()) {

            request.setAttribute("err1", "All fields must be filled");

            RequestDispatcher rd = request.getRequestDispatcher("createInternship.jsp");
            rd.forward(request, response);
            return;
        }
        
        // Create internship
        String[][] internship = {{
            internname,
            company,
            province,
            location,
            description
        }};

        // Save internship
        internships.add(internship);

        response.sendRedirect("adminDashboard.jsp");
        

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
