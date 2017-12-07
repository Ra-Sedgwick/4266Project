/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


// TODO cannot change user data only user, list user name and email
package store.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import store.business.Order;
import store.business.Product;
import store.business.User;
import store.data.AdminDB;
import store.data.OrderDB;
import store.data.ProductDB;
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
        session.setAttribute("admin", "true");
        String action = request.getParameter("action");
        
        if (action.equals("viewOrders"))
            viewOrders(request, response, session);
            
            
        if (action.equals("viewUsers")) 
            viewUsers(request, response, session);
            
        if (action.equals("reset-password")) 
            resetPassword(request, response, session);
            
            
        if (action.equals("editOrder")) 
            edit(request, response, session);

        if (action.equals("Update")) 
            update(request, response, session);
        
        if (action.equals("deleteOrder"))
            deleteOrder(request, response, session);
        
        if (action.equals("viewProducts"))
            viewProducts(request, response, session);
         
        
        if (action.equals("deleteProduct"))
            deleteProduct(request, response, session);
            
        if (action.equals("signOut")) 
            signOut(request, response, session);
        
        if (action.equals("newProduct"))
            newProduct(request, response, session);
            
        if (action.equals("Create"));
            Create(request, response, session);
      
    }
    
    public void newProduct(HttpServletRequest request, HttpServletResponse response, HttpSession session)
    throws ServletException, IOException {
        getServletContext()
                .getRequestDispatcher("/createProduct.jsp")
                .forward(request, response);
    }
    
    public void Create(HttpServletRequest request, HttpServletResponse response, HttpSession session)
    throws ServletException, IOException {
        
        session.removeAttribute("registerError");
        Product product = new Product();
        boolean incompleteForm = false;
        
        product.setProductName(request.getParameter("productName"));
        product.setCatalogCategory(request.getParameter("category").toLowerCase());
        String price = request.getParameter("price");
        product.setImageURL("images/NoImage.png");
        
        
        if (product.getProductName().equals("") ||
            product.getCatalogCategory().equals("") ||
            price.equals("")
            ) {
            incompleteForm = true;
        }
        
        if (incompleteForm) {
            session.setAttribute("registerError", "Complete All Fields");
            
            getServletContext()
                .getRequestDispatcher("/createProduct.jsp")
                .forward(request, response);
        } else {
            product.setPrice(Integer.parseInt(price));
            ProductDB.addProduct(product);
            
            getServletContext()
                .getRequestDispatcher("/admin.jsp")
                .forward(request, response);
        }
    }
    
    public void viewProducts(HttpServletRequest request, HttpServletResponse response, HttpSession session)
    throws ServletException, IOException {
        
        List<Product> pp = ProductDB.getAllProducts();
        String url = "/editProducts.jsp";
        String requestProductCode = request.getParameter("productCode");
        session.setAttribute("products", ProductDB.getAllProducts());
        session.setAttribute("clipless", ProductDB.getByCatagory("clipless"));
        session.setAttribute("platform", ProductDB.getByCatagory("platform"));

        if (requestProductCode != null) {

            // Look up product in DB
            Product product = ProductDB.getProduct(requestProductCode);
    
       
        }

        // Redirect to catalog
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
    
    
    public void viewOrders(HttpServletRequest request, HttpServletResponse response, HttpSession session)
    throws ServletException, IOException {
        
        ArrayList<Order> orders = OrderDB.getOrders();
        session.setAttribute("orderList", orders);

        getServletContext()
            .getRequestDispatcher("/orderList.jsp")
            .forward(request, response);
    }
    
    public void viewUsers(HttpServletRequest request, HttpServletResponse response, HttpSession session)
    throws ServletException, IOException {
        
        ArrayList<User> users = UserDB.getAllUsers();
        session.setAttribute("userList", users);

        getServletContext()
            .getRequestDispatcher("/userList.jsp")
            .forward(request, response);
        
    }
    
    public void resetPassword(HttpServletRequest request, HttpServletResponse response, HttpSession session)
    throws ServletException, IOException {
        
        String inputUserName = request.getParameter("userName");
        String inputSecret = request.getParameter("secret");

        User user = AdminDB.getUser(inputUserName);

        if (user != null ) {

            String userSecret = user.getSecret().toLowerCase();
            inputSecret = inputSecret.toLowerCase();

        if (userSecret.equals(inputSecret)) {
            session.setAttribute("adminLoginError", "Password: " + user.getPassword());
        } else {
            session.setAttribute("adminLoginError", "Incorrect secret question answere.");
        }

        } else {
            session.setAttribute("adminLoginError", "Error: User not found");
        }


        getServletContext()
            .getRequestDispatcher("/resetPasswordAdmin.jsp")
            .forward(request, response);
    }
    
    public void signOut(HttpServletRequest request, HttpServletResponse response, HttpSession session)
    throws ServletException, IOException {
        
        session.invalidate();
            
            getServletContext()
                .getRequestDispatcher("/")
                .forward(request, response);
        
    }

    public void deleteOrder(HttpServletRequest request, HttpServletResponse response, HttpSession session)
    throws ServletException, IOException {
        
        String deleteId = request.getParameter("deleteId");
        OrderDB.delete(deleteId);
        this.viewOrders(request, response, session);
    }
    
    
    public void deleteProduct(HttpServletRequest request, HttpServletResponse response, HttpSession session)
    throws ServletException, IOException {
        
        String deleteId = request.getParameter("deleteId");
        ProductDB.delete(deleteId);
        this.viewProducts(request, response, session);
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
