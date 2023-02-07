/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author ADMIN
 */
public class LoginServlet extends HttpServlet {
   

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       
    } 


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    } 

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
        
                String u =req.getParameter("User");
  	  String p =req.getParameter("Pass");
          String a = getServletConfig().getInitParameter("acc");
          String b = getServletConfig().getInitParameter("pass");
          
	  resp.setContentType("text/html");
     	  PrintWriter out = resp.getWriter();
          if(u.equalsIgnoreCase(a) && p.equalsIgnoreCase(b)) {
              resp.sendRedirect("WelcomeServlet");
          }
          else resp.sendRedirect("login.html");
    }


}
