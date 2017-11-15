/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.controllers;

import stron.data.ProductDB;
import stron.data.UserDB;
import java.io.IOException;
import java.util.Date;
import java.util.List;
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

/**
 *
 * @author robert
 */
@WebServlet(name = "OrderController", urlPatterns = {"/order"})

public class OrderController extends HttpServlet {

    Cart cart;
    Cart requestCart;
    List<Product> products = ProductDB.getAllProducts();

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        

        String[] str_quantity;
        String[] productList;
        
         // Get Cart from session
        requestCart = (Cart) session.getAttribute("theShoppingCart");       

        
        // If a Cart was not found create one
        if (requestCart == null) {
            
            cart = new Cart();
            cart.setOrderItems();
            
            // Parallel arrays representing the Cart items. 
            productList = request.getParameterValues("productList[]");
            str_quantity = request.getParameterValues("quantity[]");
            
            
            if (productList != null) {
                
                for (int i = 0; i < productList.length; i++) {
                
                    for (Product p : products) {      

                        if (p.getStringProductCode().equals(productList[i])){

                            int q = Integer.parseInt(str_quantity[i]);
                            cart.addItem(p, q);
                        }

                    }

                }
            
            }
            // Add every Item in product list to Cart. 
            
            session.setAttribute("theShoppingCart", cart);
        }
        else {
            
            productList = request.getParameterValues("productList[]");
            str_quantity = request.getParameterValues("quantity[]");
            
            if (productList != null) {
                for (int i = 0; i < productList.length; i++) {
                
                    for (Product p : products) {         

                        if (p.getStringProductCode().equals(productList[i])){

                            int q = Integer.parseInt(str_quantity[i]);
                            requestCart.addItem(p, q);

                        }

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
            
            List<User> users = UserDB.getAllUsers();
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
        
        if (action.equals("confirmOrder")) {
            int x = 10;
        }
        
        if (action.equals("viewOrders")) {
            User sessionUser = (User) session.getAttribute("theUser");
            
            if (sessionUser == null) {
                response.sendRedirect("catalog");
            }
            else {
                int x = 10;
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
