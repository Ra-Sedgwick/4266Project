/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
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


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        
        if (action.equals("viewOrders")) {
            
            viewOrders(request, response, session);
            
            
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
            
        } else if (action.equals("editOrder")) {

            edit(request, response, session);

        } else if (action.equals("update")) {
            
            update(request, response, session);
            
        } else if (action.equals("signOut")) { 

            session.invalidate();
            
            getServletContext()
                .getRequestDispatcher("/")
                .forward(request, response);

        } else {
            
            getServletContext()
                .getRequestDispatcher("/admin.jsp")
                .forward(request, response);
            
        }   
    }
    
    public void viewOrders(HttpServletRequest request, HttpServletResponse response, HttpSession session)
    throws ServletException, IOException {
        
        ArrayList<Order> orders = OrderDB.getOrders();
        session.setAttribute("orderList", orders);

        getServletContext()
            .getRequestDispatcher("/orderList.jsp")
            .forward(request, response);
    }

    public void update(HttpServletRequest request, HttpServletResponse response, HttpSession session)
    throws ServletException, IOException {
        
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    
        Order order = (Order) session.getAttribute("orderToUpdate");
        String originalOrderNumber = order.getOrderNumber();
        Date date;
        String inputText;
        
        inputText = request.getParameter("orderNumber");
        if (!inputText.isEmpty())
            order.setOrderNumber(inputText);
        
        inputText = request.getParameter("userEmail");
        if (!inputText.isEmpty())
            order.getUser().setEmail(inputText);
        
        inputText = request.getParameter("date");
        if (!inputText.isEmpty()) {
            try {
                date = format.parse(inputText);
                order.setDate(date);
            } catch (ParseException ex) {
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        inputText = request.getParameter("totalCost");
        if (!inputText.isEmpty())
            order.setTotalCost(Double.parseDouble(inputText));
        
        OrderDB.updateOrder(order, originalOrderNumber);
        
        this.viewOrders(request, response, session);
    }
    
    public void edit(HttpServletRequest request, HttpServletResponse response, HttpSession session)
    throws ServletException, IOException {

        String id = request.getParameter("updateOrderNumber");
        Order order = OrderDB.getOrder(id);
        session.setAttribute("orderToUpdate", order);
        
        getServletContext()
                .getRequestDispatcher("/updateOrder.jsp")
                .forward(request, response);
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
