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
        
        if (action.equals("reset-password")) {
            resetPassword(request, response, session);
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
        user.setSecret(request.getParameter("secret"));
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
        else if (validUser(user.getEmail())) {
            
            session.setAttribute("registerError", "Email already in use, try again.");
            
            getServletContext()
                .getRequestDispatcher("/register.jsp")
                .forward(request, response);
            
        } else {
            
            UserDB.insert(user);
            session.setAttribute("theUser", UserDB.getUserByEmail(user.getEmail()));
        
            getServletContext()
                    .getRequestDispatcher("/index.jsp")
                    .forward(request, response);
            
        }
        
        
    }
    
    private static boolean validUser(String userEmail) {
       
       User user = UserDB.getUserByEmail(userEmail);
       
       if (user != null) {
           return true;
       }
       
       return false;
       
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
        if (!inputText.isEmpty())
           user.setFirstName(inputText);
        
        inputText = request.getParameter("lastName");
        if (!inputText.isEmpty())
           user.setLastName(inputText);
           
        inputText = request.getParameter("email");
        if (!inputText.isEmpty())
            user.setEmail(inputText);
        
        inputText = request.getParameter("address-1");
        if (!inputText.isEmpty())
           user.setAddressField_1(inputText);
                   
        inputText = request.getParameter("address-2");
        if (!inputText.isEmpty())
           user.setAddressField_2(inputText);       
            
        inputText = request.getParameter("city");
        if (!inputText.isEmpty())
            user.setCity(inputText);
        
        inputText = request.getParameter("state");
        if (!inputText.isEmpty())
            user.setState(inputText);
        
        inputText = request.getParameter("postCode");
        if (!inputText.isEmpty())
            user.setPostCode(inputText);
        
        inputText = request.getParameter("country");
        if (!inputText.isEmpty())
            user.setCountry(inputText);
        
        inputText = request.getParameter("secret");
        if (!inputText.isEmpty())
            user.setSecret(inputText);
        
        inputText = request.getParameter("password");
        if (!inputText.isEmpty())
            user.setPassword(inputText);
        
        UserDB.updateUser(user);
        
        String admin = (String) session.getAttribute("admin");
        
        if (admin == null) {
            
            session.setAttribute("theUser", user);

            getServletContext()
                    .getRequestDispatcher("/user.jsp")
                    .forward(request, response);
        }
        
        session.setAttribute("updateUser", user);
        
        getServletContext()
                .getRequestDispatcher("/userList.jsp")
                .forward(request, response);
    }
    
    public void resetPassword(HttpServletRequest request, HttpServletResponse response, HttpSession session) 
        throws ServletException, IOException {
        
        String userEmail = request.getParameter("userEmail");
        
        if (validUser(userEmail)) {
            
            String inputSecret = request.getParameter("secret");
            User user = UserDB.getUserByEmail(userEmail);
            
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
                .getRequestDispatcher("/resetPassword.jsp")
                .forward(request, response);
    }
}
