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
import java.util.List;
import model.TeacherDAO;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "TeacherSearch", urlPatterns = {"/teachersearch"})
public class TeacherSearch extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MajorSearch</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MajorSearch at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TeacherDAO sc = new TeacherDAO();
        String a = request.getParameter("teacheridname") == null ? "" : request.getParameter("teacheridname");
        String b = request.getParameter("subjectid");
        String c = request.getParameter("classid");
        
        if(b == null || b.isEmpty()) {
            if(c == null || c.isEmpty()) {
                List<Teacher> teacherlist = sc.searchTeacher(a);
            request.setAttribute("teacherlist", teacherlist);
            request.setAttribute("teachername", a);
            request.getRequestDispatcher("teachersearch.jsp").forward(request, response);
            }
            else {
                List<Teacher> teacherlist = sc.searchTeacherByClassId(a, c);
            request.setAttribute("teacherlist", teacherlist);
            request.setAttribute("teachername", a);
            request.setAttribute("classid", c);

            request.getRequestDispatcher("teachersearch.jsp").forward(request, response);
            }
        }else {
            if(c == null || c.isEmpty()) {
                List<Teacher> teacherlist = sc.searchTeacherBySubjectId(a, b);
            request.setAttribute("teacherlist", teacherlist);
            request.setAttribute("teachername", a);
            request.setAttribute("subjectid", b);
            request.getRequestDispatcher("teachersearch.jsp").forward(request, response);
            }
            else {
                 List<Teacher> teacherlist = sc.searchTeacherBySubClassId(a, b, c);
            request.setAttribute("teacherlist", teacherlist);
            request.setAttribute("teachername", a);
            request.setAttribute("subjectid", b);
            request.setAttribute("classid", c);
            request.getRequestDispatcher("teachersearch.jsp").forward(request, response);
            }
        }
        
            

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
