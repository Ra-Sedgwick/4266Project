/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import store.business.User;
import store.data.UserDB;

/**
 *
 * @author rased
 */
public class LoginController extends HttpServlet {

   
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
        
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        
        if (action.equals("signOut")) {
            session.removeAttribute("theUser");
            getServletContext()
                .getRequestDispatcher("./")
                .forward(request, response);
        } 
        else if (action.equals("register")) {
            getServletContext()
                .getRequestDispatcher("/register.jsp")
                .forward(request, response);
        }
        else {
            
           
            
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (username != null && password != null) {

                User user = UserDB.getUserByEmail(username);

                if (user == null) {

                    session.setAttribute("loginError", "Username not found");

                    // Redirect with user not found
                    getServletContext()
                        .getRequestDispatcher("/login.jsp")
                        .forward(request, response);

                }


                if (password.equals(user.getPassword())) {

                    session.setAttribute("theUser", user);
                    session.removeAttribute("loginError");

                    getServletContext()
                        .getRequestDispatcher("/")
                        .forward(request, response);
                }

                else {

                    session.setAttribute("loginError", "Incorrect Password");

                    // Redirect with wrong password
                    getServletContext()
                        .getRequestDispatcher("/login.jsp")
                        .forward(request, response);
                }

            }
        }  
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
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
