/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.controllers;

import data.UserDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import store.business.Product;
import store.business.User;
import store.util.ProductDB;

/**
 *
 * @author robert
 */
@WebServlet(name = "CatalogController", urlPatterns = {"/catalog"})
public class CatalogController extends HttpServlet {

    ProductDB db = new ProductDB();

    
    public void doGet(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = "/catalog.jsp";
        HttpSession session = request.getSession();
        String requestURI = request.getRequestURI();
        String requestProductCode = request.getParameter("productCode");
        
        session.setAttribute("products", db.getProducts());
        session.setAttribute("clipless", db.getByCatagory("clipless"));
        session.setAttribute("platform", db.getByCatagory("platform"));
        
        if (requestProductCode != null) {
            
            Product p = db.getProduct(requestProductCode); 
            ArrayList<User> users = UserDB.getUsers();
            
            if (p != null) {
                url = "/item.jsp";
                session.setAttribute("product", p); 
            } else { 
                List<Product> ps = db.getProducts();          
            }
       
        }

        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
