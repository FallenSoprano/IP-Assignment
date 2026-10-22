/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ThandolwethuNdlovu;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author black
 */
public class closeServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String internshipname = request.getParameter("internshipname");
        String company = request.getParameter("company");  
        
        if (internshipname!=null || company != null){
            request.setAttribute("err1","Fill all fiels");
            RequestDispatcher rd = request.getRequestDispatcher("closeInternship.jsp");
            rd.forward(request, response);
            return;
        }
        
    
        boolean removed = false;
    
        // Loop through the list of internships (each is a String[][])
        for (int i = 0; i < createServlet.internships.size(); i++) {
            String[][] internshipData = createServlet.internships.get(i); // <-- correct type
        
            boolean hasName = false;
            boolean hasCompany = false;
        
            // Flatten the 2D array and check for both name and company
            for (String[] row : internshipData) {
                for (String cell : row) {
                    if (cell != null && cell.equalsIgnoreCase(internshipname.trim())) {
                        hasName = true;
                    }
                    if (cell != null && cell.equalsIgnoreCase(company.trim())) {
                        hasCompany = true;
                    }
                }
            }
        
            if (hasName && hasCompany) {
                createServlet.internships.remove(i);
                removed = true;
                break;
            }
        }
    
        if (removed) {
            request.setAttribute("msg", "Internship closed successfully");
            response.sendRedirect("manageInternships.jsp");
        } else {
            request.setAttribute("err1", "Internship not found for the given company");
        }
       
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
