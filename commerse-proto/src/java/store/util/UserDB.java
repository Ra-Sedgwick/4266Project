/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.util;

import java.util.ArrayList;
import java.util.List;
import store.business.User;

/**
 *
 * @author robert
 */
public class UserDB {
    
    private List<User> users;
    
    public UserDB() {
        users = new ArrayList<User>();
        buildUsers();
    }
    
    public List<User> getUsers() {
        return users;
    }
   
    
    private void buildUsers() {
        
        User u;
        
        u = new User();
        u.setFirstName("John");
        u.setLastName("Doe");
        u.setEmail("TeamJacob@earthlink.org");
        u.setAddressField_1("123 Fake Street");
        u.setAddressField_2("Appartment 1");
        u.setCity("Charltte");
        u.setState("NC");
        u.setPostCode("55555");
        u.setCountry("USA");
        
        users.add(u);
    } 
}
