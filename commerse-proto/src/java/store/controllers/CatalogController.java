/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.controllers;

import data.ProductDB;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import store.business.Product;


/**
 *
 * @author robert
 */
@WebServlet(name = "CatalogController", urlPatterns = {"/catalog"})
public class CatalogController extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = "/catalog.jsp";
        HttpSession session = request.getSession();
        String requestProductCode = request.getParameter("productCode");
        session.setAttribute("products", ProductDB.getAllProducts());
        session.setAttribute("clipless", ProductDB.getByCatagory("clipless"));
        session.setAttribute("platform", ProductDB.getByCatagory("platform"));

        if (requestProductCode != null) {

            // Look up product in DB
            Product product = ProductDB.getProduct(requestProductCode);
            
            // If the a product was found add it to the session
            if (product != null) {
                url = "/item.jsp";
                session.setAttribute("product", product); 
            } else { 
                List<Product> ps = ProductDB.getAllProducts();          
            }
       
        }

        // Redirect to catalog
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
