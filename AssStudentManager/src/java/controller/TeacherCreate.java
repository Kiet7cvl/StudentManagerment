/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.TeacherDAO;

/**
 *
 * @author ADMIN
 */
@WebServlet(name="TeacherCreate", urlPatterns={"/teachercreate"})
public class TeacherCreate extends HttpServlet {
   
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
            out.println("<title>Servlet MajorCreate</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MajorCreate at " + request.getContextPath () + "</h1>");
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
        new TeacherDAO().deleteTeacher(a);
        response.sendRedirect("teacherload");
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
        String a = request.getParameter("teacherid"); 
        String b = request.getParameter("teachername");
        String c = request.getParameter("phone");
        String d = request.getParameter("literacy");
        String e = request.getParameter("nationality");
        String f = request.getParameter("subjectid");
        String g = request.getParameter("classid");
        if(a.trim() == null) {
            request.setAttribute("error","TeacherId has not empty");
            request.getRequestDispatcher("teachercreate.jsp").forward(request, response);
        }
        else {
        if(new TeacherDAO().getTeacher(a)==null){
            new TeacherDAO().insertTeacher(a, b, c, d, e, f, g);
            response.sendRedirect("teacherload");  
        }
        else{
            request.setAttribute("error","TeacherId has already exist");
            request.getRequestDispatcher("teachercreate.jsp").forward(request, response);
        }
        }
            
        
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
