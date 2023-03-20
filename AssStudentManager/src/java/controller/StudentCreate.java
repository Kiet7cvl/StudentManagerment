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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.StudentDAO;

/**
 *
 * @author ADMIN
 */
@WebServlet(name="StudentCreate", urlPatterns={"/studentcreate"})
public class StudentCreate extends HttpServlet {
   
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
        new StudentDAO().deleteStudent(Integer.parseInt(a));
        response.sendRedirect("studentload");
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

        if(a.trim() == null || a.isEmpty()) {
            request.setAttribute("error","StudentId has not empty");
            request.getRequestDispatcher("studentcreate.jsp").forward(request, response);
        }
        else {
        if(new StudentDAO().getStudentByStudentId(a)==null){
            new StudentDAO().insertStudent(a, b, c, d, e, f, g, h, i, k, l, m, n, p, q, r, s);
            response.sendRedirect("studentload");  
        }
        else{
            request.setAttribute("error","StudentId has already exist");
            request.getRequestDispatcher("studentcreate.jsp").forward(request, response);
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
