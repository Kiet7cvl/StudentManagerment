/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.Student;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.StudentDAO;

/**
 *
 * @author ADMIN
 */
@WebServlet(name="StudentUpdate", urlPatterns={"/studentupdate"})
public class StudentUpdate extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MajorUpdate</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MajorUpdate at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String a = request.getParameter("sid");
        Student sc = new StudentDAO().getStudent(Integer.parseInt(a));
        request.setAttribute("sc", sc);
        request.getRequestDispatcher("studentupdate.jsp").forward(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String x = request.getParameter("cc");
        String a = request.getParameter("studentid"); 
        String b = request.getParameter("name");
        String c = request.getParameter("gender");
        String d = request.getParameter("dob");
        String e = request.getParameter("classid");
        String f = request.getParameter("majorid");
        String g = request.getParameter("cname");
        String h = request.getParameter("pob");
        String i = request.getParameter("ht");
        String k = request.getParameter("prr");
        String l = request.getParameter("nation");
        String m = request.getParameter("religion");
        String n = request.getParameter("academicl");
        String p = request.getParameter("nien");
        String q = request.getParameter("CMND");
        String r = request.getParameter("phone");
        String s = request.getParameter("gmail");

        StudentDAO sc = new StudentDAO();
        
        if( n== null || n.isEmpty()) {
            
        }else {
        try {
            sc.updateStudent(x, a, b, c, d, e, f, g, h, i, k, l, m, n, p, q, r, s);
        } catch (SQLException ex) {
            Logger.getLogger(StudentUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.sendRedirect("studentload");
        }
            
    }

    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
