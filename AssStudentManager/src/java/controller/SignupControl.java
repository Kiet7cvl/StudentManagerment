/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.Account;
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
import model.AccountDAO;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "SignupControl", urlPatterns = {"/signup"})
public class SignupControl extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SignupControl</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SignupControl at " + request.getContextPath() + "</h1>");
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
        String a = request.getParameter("username");
        String b = request.getParameter("password");
        String c = request.getParameter("re-password");
        if (!b.equals(c)) {
            request.setAttribute("mess", "Re-password is not equal password");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        } else {
            AccountDAO cc = new AccountDAO();
            Account x = cc.checkAcountExist(a);
            if (x == null) {
                try {
                    cc.insertAccount(a, b);
                    request.setAttribute("mess_s", "Create account successfully !!");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
                } catch (SQLException ex) {
                    Logger.getLogger(SignupControl.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                request.setAttribute("mess", "Username has exist");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
            }
        }
    }

    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
