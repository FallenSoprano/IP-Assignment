/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ThandolwethuNdlovu;


import jakarta.servlet.annotation.MultipartConfig;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author thobi
 */
@MultipartConfig(maxFileSize = 2097152)

public class studentprofileServlet extends HttpServlet {
    
    public static ArrayList<String[][]> students = new ArrayList<>();
    
    
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String name = request.getParameter("name");
        String idnumber = request.getParameter("idnumber");
        boolean hasErrors = false;
        
        if (name == null || name.trim().isEmpty()) {
            request.setAttribute("err1", "First name is required.");
            hasErrors = true;
        } else if (!name.matches("[a-zA-Z ]+")) {
            request.setAttribute("err1", "First name must contain letters only.");
            hasErrors = true;
        }
        
        if (idnumber == null || idnumber.trim().isEmpty()) {
            request.setAttribute("err2", "ID number is required.");
            hasErrors = true;
            
        } else if (idnumber.length() != 13) {
            request.setAttribute("err2", "ID number must be 13 digits.");
            hasErrors = true;

        } else {
            for (int i = 0; i < idnumber.length(); i++) {
                if (!Character.isDigit(idnumber.charAt(i))) {
                    request.setAttribute("err2", "ID number must contain numbers only.");
                    hasErrors = true;
                    break;
                }
            }
        }
        
        // If there are errors, return to the JSP
        if (hasErrors) {
            RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
            rd.forward(request, response);
        } 
        
        
        
        int num = 0;
        for (String[][] application: students){
            for (String[] rows : application){
                if (name != null && name.equals(rows[0])){
                    request.setAttribute("firstname", application[num][0]);
                    request.setAttribute("lastname", application[num][1]);
                    request.setAttribute("dob", application[num][2]);
                    request.setAttribute("idnumber", application[num][3]);
                    request.setAttribute("province", application[num][4]);
                    request.setAttribute("qualification", application[num][5]);
                    request.setAttribute("skills", application[num][6]);
                    request.setAttribute("gender", application[num][7]);           
                }   
                       
            }
            num+=1;
        }
        
        // Display the Internship
        request.getRequestDispatcher("profile.jsp")
                .forward(request, response);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String dob = request.getParameter("dob");
        String idnumber = request.getParameter("idnumber");
        String province = request.getParameter("province");
        String qualification = request.getParameter("qualification");
        String skills = request.getParameter("skills");
        String gender = request.getParameter("gender");
        
        
        
        boolean hasErrors = false;

        // First Name
        if (firstName == null || firstName.trim().isEmpty()) {
            request.setAttribute("err1", "First name is required.");
            hasErrors = true;
        } else if (!firstName.matches("[a-zA-Z ]+")) {
            request.setAttribute("err1", "First name must contain letters only.");
            hasErrors = true;
        }

        // Last Name
        if (lastName == null || lastName.trim().isEmpty()) {
            request.setAttribute("err2", "Last name is required.");
            hasErrors = true;
        } else if (!lastName.matches("[a-zA-Z ]+")) {
            request.setAttribute("err2", "Last name must contain letters only.");
            hasErrors = true;
        }

        // Date of Birth
        if (dob == null || dob.trim().isEmpty()) {
            request.setAttribute("err3", "Date of birth is required.");
            hasErrors = true;
        }

        // ID Number
        if (idnumber == null || idnumber.trim().isEmpty()) {
            request.setAttribute("err4", "ID number is required.");
            hasErrors = true;
        } else if (idnumber.length() != 13) {
            request.setAttribute("err4", "ID number must be 13 digits.");
            hasErrors = true;
        } else {
            for (int i = 0; i < idnumber.length(); i++) {
                if (!Character.isDigit(idnumber.charAt(i))) {
                    request.setAttribute("err4", "ID number must contain numbers only.");
                    hasErrors = true;
                    break;
                }
            }
        }

        // Gender
        if (gender == null || gender.trim().isEmpty()) {
            request.setAttribute("err5", "Please select your gender.");
            hasErrors = true;
        }

        // Province
        if (province == null || province.equals("Select Province")) {
            request.setAttribute("err6", "Please select your province.");
            hasErrors = true;
        }

        // Qualification
        if (qualification == null || qualification.trim().isEmpty()) {
            request.setAttribute("err7", "Qualification is required.");
            hasErrors = true;
        }

        // Skills
        if (skills == null || skills.trim().isEmpty()) {
            request.setAttribute("err8", "Skills are required.");
            hasErrors = true;
        }

        // If there are errors, return to the JSP
        if (hasErrors) {
            RequestDispatcher rd = request.getRequestDispatcher("createprofile.jsp");
            rd.forward(request, response);
            return;
        }                
        
        String uploadPath = getServletContext().getRealPath("/CVs");

        
        
        // CV Validation and saving
        Part cv = request.getPart("CV");
        
        

        // CV validation
        if (cv == null || cv.getSize() == 0) {
            request.setAttribute("err9", "Please upload your CV.");
            RequestDispatcher rd = request.getRequestDispatcher("createprofile.jsp");
            rd.forward(request, response);
            return;
        }        

        if (cv.getSize() > 2 * 1024 * 1024) {
            request.setAttribute("err9", "CV must not be larger than 2MB.");
            RequestDispatcher rd = request.getRequestDispatcher("createprofile.jsp");
            rd.forward(request, response);
            return;
        }


        // Create CV folder
        String fileName = cv.getSubmittedFileName();
        
        

        if (!fileName.toLowerCase().endsWith(".pdf")) {

            request.setAttribute("err9", "CV must be a PDF file.");
            RequestDispatcher rd = request.getRequestDispatcher("createprofile.jsp");
            rd.forward(request, response);
            return;
        }

        if (cv.getSize() > 2097152) {

            request.setAttribute("err9", "CV must be less than 2MB.");
            RequestDispatcher rd = request.getRequestDispatcher("createprofile.jsp");
            rd.forward(request, response);
            return;
        }
        // Create the CVs directory if it does not exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();   // creates the directory and any necessary parents
        }

        // Write the file
        cv.write(uploadPath + File.separator + fileName);
        
        String username = (String) request.getSession().getAttribute("username");
        //If there's no error with the form now save the data
        
        String[][] student = {{
            firstName,
            lastName,
            dob,
            idnumber,
            gender,
            province,
            qualification,
            skills,
            fileName
        }};
        
        
        
        
        int r = -1;
        int b = 0;
        for (String[][] application: students){
            for (String[] rows : application){
                if (username != null && username.equals(rows[8])){
                    b+=1;
                    break;           
                }   
                       
            }
            if(b>0){
                break;
            }
            r+=1;
        }
        
        if(r==-1){
            
            // save new profile
            students.add(student);
            
        }
        else{
            
            students.set(r+1, student);
            
        }
        
        
        //View Profile
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
