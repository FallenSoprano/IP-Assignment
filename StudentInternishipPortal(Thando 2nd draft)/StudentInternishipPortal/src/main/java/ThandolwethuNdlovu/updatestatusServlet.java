/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ThandolwethuNdlovu;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author thobi
 */
public class updatestatusServlet extends HttpServlet {

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
            out.println("<title>Servlet updatestatusServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet updatestatusServlet at " + request.getContextPath() + "</h1>");
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
        
        String name = request.getParameter("name");
        String intname = request.getParameter("intname");
        
        // check if all fields are filled
        if (name == null && intname == null) {

        request.setAttribute("err1", "All fields must be filled");
        RequestDispatcher rd = request.getRequestDispatcher("adminfeedback.jsp");
        rd.forward(request, response);
        return;
        }
        
        for (String[][] application : applyServlet.applications) {
                for (String[] rows : application){
                        if (rows[0].equals(name) && rows[1].equals(intname)) {
                            if (rows[3] != null){
                                
                                request.setAttribute("statues",rows[3]);
                                RequestDispatcher rd = request.getRequestDispatcher("adminfeedback.jsp");
                                    rd.forward(request, response);
                                break;
                                
                            }
                            
                            
                        }
                }
        }        
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
        
            String username = request.getParameter("username");
            String internshipName = request.getParameter("internshipname");
            String company = request.getParameter("company");
            String status = request.getParameter("status");

            for (String[][] application : applyServlet.applications) {
                for (String[] rows : application){
                        // Search by province
                        if (rows[0].equals(username) && rows[1].equals(internshipName)
                        && rows[2].equals(company)) {
                            
                            rows[3] = status;
                            break;
                            
                        }   
                       
                }
                
            }

            response.sendRedirect(
                    "appliedforInternshipServlet");
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
