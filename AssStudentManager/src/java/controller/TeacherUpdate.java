/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.Teacher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TeacherDAO;

/**
 *
 * @author ADMIN
 */
@WebServlet(name="TeacherUpdate", urlPatterns={"/teacherupdate"})
public class TeacherUpdate extends HttpServlet {
   
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
        Teacher sc = new TeacherDAO().getTeacher(a);
        request.setAttribute("sc", sc);
        request.getRequestDispatcher("teacherupdate.jsp").forward(request, response);
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
        String sid = request.getParameter("teacherid");
        String sname = request.getParameter("teachername");
        String sphone = request.getParameter("phone");
        String sliteracy = request.getParameter("literacy");
        String snationality = request.getParameter("nationality");
        String ssid = request.getParameter("subjectid");
        String scid = request.getParameter("classid");

        TeacherDAO sc = new TeacherDAO();
        sc.updateTeacher(sid,sname, sphone, sliteracy, snationality, ssid, scid);
        response.sendRedirect("teacherload");
    }

    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
