/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.controllers;

import data.DBProduct;
import data.DBUser;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import store.business.Cart;
import store.business.Order;
import store.business.OrderItem;
import store.business.Product;
import store.business.User;
import store.util.ProductDB;
import store.util.UserDB;

/**
 *
 * @author robert
 */
@WebServlet(name = "OrderController", urlPatterns = {"/order"})

public class OrderController extends HttpServlet {

    List<Product> products = DBProduct.getProducts();
    Cart cart;
    Cart requestCart;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
        String url = "/order.jsp";
        HttpSession session = request.getSession();
        String requestURI = request.getRequestURI();
        requestCart = (Cart) session.getAttribute("theShoppingCart");
        String[] str_quantity = null;
        String[] productList = null;
        

        
        
        if (requestCart == null) {
            cart = new Cart();
            cart.setOrderItems();
            
            
            productList = request.getParameterValues("productList[]");
            str_quantity = request.getParameterValues("quantity[]");
            
            for (int i = 0; i < productList.length; i++) {
                for (Product p : products) {                    
                    if (p.getStringProductCode().equals(productList[i])){
                        int q = Integer.parseInt(str_quantity[i]);
                        cart.addItem(p, q);
                    }
                }
            }
            session.setAttribute("theShoppingCart", cart);
        }
        else {
            
            ;
            
            productList = request.getParameterValues("productList[]");
            str_quantity = request.getParameterValues("quantity[]");
            
            for (int i = 0; i < productList.length; i++) {
                for (Product p : products) {                    
                    if (p.getStringProductCode().equals(productList[i])){
                        int q = Integer.parseInt(str_quantity[i]);
                        requestCart.addItem(p, q);
                    }
                }
            }
            
            session.setAttribute("theShoppingCart", requestCart);
        }
        
        String action = request.getParameter("action");
        
        if (action == null) {
            
            getServletContext()
                    .getRequestDispatcher("/cart.jsp")
                    .forward(request, response);
        }
        

        
        if (action.equals("updateCart")) {
            productList = request.getParameterValues("productList[]");

            int i = 0; 
            for (String code : productList) {
                
                
                for (Product product : products) {
                    if (code.equals(product.getStringProductCode())) {
                        
                        
                        // Get quantity
                        //String str_quantity = request.getParameterValues(code);
                        str_quantity = request.getParameterValues("quantity[]");
                        
                        // If unspecifed increment quantity.
                        if (str_quantity == null) {
                            OrderItem oi = cart.getItem(product);
                            
                            cart.addItem(product, oi.getQuantity() + 1);
                        }
                        else {
                            int quantity = Integer.parseInt(str_quantity[i]);
                        
                            if (quantity == 0) {
                                cart.removeItem(product);
                            }

                            if (quantity > 0) {
                                cart.addItem(product, quantity);
                            }
                        }
                        
                        session.setAttribute("productList", productList);
                        session.setAttribute("quantities", str_quantity);
                        session.setAttribute("theShoppingCart", cart);
                        
                    }
                }
                i++;
                
            }
            
            
       

            getServletContext()
                    .getRequestDispatcher("/cart.jsp")
                    .forward(request, response);
        }
        
        if (action.equals("checkout")) {
            
            List<User> users = DBUser.getUsers();
            User user = users.get(0); 
            session.setAttribute("theUser", user);
            
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setDate( new Date() );
            order.setUser(user);
            order.setOrderItems(cart.getOrderItems());
            order.setTaxRate(0.06);
            session.setAttribute("currentOrder", order);
            getServletContext()
                    .getRequestDispatcher("/order.jsp")
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
