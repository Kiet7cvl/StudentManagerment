
package controller;

import model.AccountDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import dal.Account;

/**
 *
 * @author macbookair
 */
public class LoginSession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();

        for (Cookie cooky : cookies) {
            if (cooky.getName().equals("user_C")) {
                request.setAttribute("username", cooky.getValue());
            }
            if (cooky.getName().equals("pass_C")) {
                request.setAttribute("password", cooky.getValue());
            }
        }  
            
            request.getRequestDispatcher("login.jsp").forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        AccountDAO db = new AccountDAO();
        Account account = db.getAccountByUsernameAndPassword(username, password);
        if (account != null) // login successfully!
        {
            String remember = request.getParameter("remember");
            if (remember != null) {
                Cookie c_user = new Cookie("user_C", username); // luu acc tren cookie
                Cookie c_pass = new Cookie("pass_C", password);
                c_user.setMaxAge(3600 * 24 * 30);  // set time ton tai cookie tren web
                c_pass.setMaxAge(3600 * 24 * 30);
                response.addCookie(c_pass);   // luu user, pass len chrome
                response.addCookie(c_user);
            }
            HttpSession session = request.getSession();
            session.setAttribute("user", account);
            request.setAttribute("account", account);
            session.setAttribute("username", username);
            request.setAttribute("username",username);
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else //login fail
        {
            request.setAttribute("mess", "Wrong username or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
           
        }
    }
}
