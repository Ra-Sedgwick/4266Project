/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import store.business.Order;
import store.business.User;
import store.data.AdminDB;
import store.data.OrderDB;
import store.data.UserDB;

/**
 *
 * @author rased
 */
public class AdminController extends HttpServlet {



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
        
        if (action.equals("viewOrders")) {
            
            ArrayList<Order> orders = OrderDB.getOrders();
            session.setAttribute("orderList", orders);
            
            getServletContext()
                .getRequestDispatcher("/orderList.jsp")
                .forward(request, response);
            
        } else if (action.equals("viewUsers")) {
            
            ArrayList<User> users = UserDB.getAllUsers();
            session.setAttribute("userList", users);
            
            getServletContext()
                .getRequestDispatcher("/userList.jsp")
                .forward(request, response);
            
        } else if (action.equals("reset-password")) {
            
            String inputUserName = request.getParameter("userName");
            String inputSecret = request.getParameter("secret");
            
            User user = AdminDB.getUser(inputUserName);
            
            if (user != null ) {
                
                String userSecret = user.getSecret().toLowerCase();
                inputSecret = inputSecret.toLowerCase();
            
            if (userSecret.equals(inputSecret)) {
                session.setAttribute("loginError", "Password: " + user.getPassword());
            } else {
                session.setAttribute("loginError", "Incorrect secret question answere.");
            }
                
            } else {
                session.setAttribute("loginError", "Error: User not found");
            }
            
            
            getServletContext()
                .getRequestDispatcher("/resetPasswordAdmin.jsp")
                .forward(request, response);
            
        }  else {
            
            getServletContext()
                .getRequestDispatcher("/admin.jsp")
                .forward(request, response);
            
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
