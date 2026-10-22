/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ThandolwethuNdlovu;

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
public class applyServlet extends HttpServlet {

    public static ArrayList<String[][]> applications = new ArrayList<>();
    //[0]= username
    //[1]= internshipName
    //[2]= companyName
    //[3]= Status
    
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
        
        // must share profile and view CV
        String username = (String) request.getSession().getAttribute("username");
        String internshipname = request.getParameter("internshipname");
        String company = request.getParameter("company");
        
        boolean existingprofile= false;
        //Check profile
        for (String[][] student: studentprofileServlet.students){
            for (String [] rows: student)
            if (username.equals(rows[9])){
                existingprofile = true;
                break;
            }
        }
        if (!existingprofile == false){
            request.setAttribute("err1","Create profile before applying");
            RequestDispatcher rd = request.getRequestDispatcher("stuDashboard.jsp");
            rd.forward(request, response);
            return;
        }
        
        //Don't repeat applications
        for (String[][] application: applications){
            for (String[] rows : application){
                        // Search by province
                        if (username.equals(rows[0]) && internshipname.equals(rows[1])
                            && company.equals(rows[2]) && internshipname != null
                            && company !=null) {
                            request.setAttribute("err1","Internship application already exists");
                            RequestDispatcher rd = request.getRequestDispatcher("apply.jsp");
                            rd.forward(request, response);
                        }   
                       
            }
        }
        
        // if all is gud then add application
        applications.add(new String[][]{{username, internshipname,"Submitted"}});
        
        response.sendRedirect("trackapplications.jsp");
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
