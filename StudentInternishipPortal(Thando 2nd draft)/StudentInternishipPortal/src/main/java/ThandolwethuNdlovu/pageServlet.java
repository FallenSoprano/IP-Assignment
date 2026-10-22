/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ThandolwethuNdlovu;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author black
 */
public class pageServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet pageServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet pageServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
    
        int pageNum = 0; // default to first internship
        String pageParam = request.getParameter("page");
        if (pageParam != null && !pageParam.isEmpty()) {
            try {
                pageNum = Integer.parseInt(pageParam);
            } catch (NumberFormatException e) {
                pageNum = 0;
            }
        }
    
        // Ensure the index is within bounds
        if (createServlet.internships.isEmpty()) {
            request.setAttribute("message", "No internships have been created.");
        } else {
            if (pageNum < 0) pageNum = 0;
            if (pageNum >= createServlet.internships.size()) pageNum = createServlet.internships.size() - 1;
        
            String[][] internship = createServlet.internships.get(pageNum);
        
            // Now internship is a 1×5 array, so always use index 0 for the row
            if (internship.length > 0 && internship[0].length >= 5) {
                request.setAttribute("internshipname", internship[0][0]);
                request.setAttribute("company", internship[0][1]);
                request.setAttribute("location", internship[0][2]);
                request.setAttribute("province", internship[0][3]);
                request.setAttribute("description", internship[0][4]);
            } else {
                request.setAttribute("message", "Internship data is incomplete.");
            }
        
            request.setAttribute("page", pageNum); // for display and links
        }
    
        request.getRequestDispatcher("closeInternship.jsp").forward(request, response);
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
        processRequest(request, response);
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
