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
public class UserController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        
        if (action.equals("create")) {
            create(request, response, session);
        }
        
        if (action.equals("edit")) {
            edit(request, response, session);
        }
        
        if (action.equals("update")) {
            update(request, response, session);
        }
        
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public void create(HttpServletRequest request, HttpServletResponse response, HttpSession session) 
        throws ServletException, IOException {
        
        session.removeAttribute("registerError");
        User user = new User();
        boolean incompleteForm = false;
        
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setEmail(request.getParameter("email"));
        user.setAddressField_1(request.getParameter("address-1"));
        user.setAddressField_2(request.getParameter("address-2"));
        user.setCity(request.getParameter("city"));
        user.setState(request.getParameter("state"));
        user.setPostCode(request.getParameter("postCode"));
        user.setCountry(request.getParameter("country"));
        user.setPassword(request.getParameter("password"));
        
        
        if (user.getFirstName().equals("") ||
            user.getLastName().equals("") ||
            user.getEmail().equals("") ||
            user.getPassword().equals("") 
        ) {
            incompleteForm = true;
        }
        
        
        // Check for current user;
        
        if (incompleteForm) {
            session.setAttribute("registerError", "Fields marked with a (*) must be completed");
            
            getServletContext()
                .getRequestDispatcher("/register.jsp")
                .forward(request, response);
        }
        else if (validUser(user)) {
            
            UserDB.insert(user);
            session.setAttribute("theUser", UserDB.getUserByEmail(user.getEmail()));
        
            getServletContext()
                    .getRequestDispatcher("/index.jsp")
                    .forward(request, response);
        }
        
        else {
            
            session.setAttribute("registerError", "Email already in use, try again.");
            
            getServletContext()
                .getRequestDispatcher("/register.jsp")
                .forward(request, response);
        }
        
        
    }
    
    private static boolean validUser(User _user) {
       
       User user = UserDB.getUserByEmail(_user.getEmail());
       
       if (user != null) {
           return false;
       }
       
       return true;
       
   }
    
    public void edit(HttpServletRequest request, HttpServletResponse response, HttpSession session) 
        throws ServletException, IOException { 
        
        String userId = request.getParameter("userId");
        User user;
        
        if (userId == null) {
            user = (User) session.getAttribute("theUser");
        } else {
            int id = Integer.parseInt(userId);
            user = UserDB.getUser(id);
        }
        
        session.setAttribute("updateUser", user);
        
        getServletContext()
                .getRequestDispatcher("/updateUser.jsp")
                .forward(request, response);
    
    }
    
    public void update(HttpServletRequest request, HttpServletResponse response, HttpSession session) 
        throws ServletException, IOException { 
        
        User user = (User) session.getAttribute("updateUser" );
        String inputText;
        
        inputText = request.getParameter("firstName");
        if (!inputText.equals("")); 
           user.setFirstName(inputText);
        
        inputText = request.getParameter("lastName");
        if (!inputText.equals("")); 
           user.setLastName(inputText);
           
        inputText = request.getParameter("email");
        if (!inputText.equals(""))
            user.setEmail(inputText);
        
        inputText = request.getParameter("addressField_1");
        if (!inputText.equals("")); 
           user.setAddressField_1(inputText);
                   
        inputText = request.getParameter("addressField_2");
        if (!inputText.equals("")); 
           user.setAddressField_2(inputText);       
            
        inputText = request.getParameter("city");
        if (!inputText.equals(""))
            user.setCity(inputText);
        
        inputText = request.getParameter("state");
        if (!inputText.equals(""))
            user.setState(inputText);
        
        inputText = request.getParameter("postCode");
        if (!inputText.equals(""))
            user.setPostCode(inputText);
        
        inputText = request.getParameter("country");
        if (!inputText.equals(""))
            user.setCountry(inputText);
        
        inputText = request.getParameter("password");
        if (!inputText.equals(""))
            user.setPassword(inputText);
    }
    
}
