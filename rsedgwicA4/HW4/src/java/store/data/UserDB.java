/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import store.business.User;

/**
 *
 * @author rased
 */
public class UserDB {
    
    public static ArrayList<User> getAllUsers() {
        
        ArrayList<User> users = new ArrayList<User>();
        User user = null;
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        

        String query = "SELECT * FROM User";
        
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery(query);

            if (rs.first()) {
                do {
                        user = new User();
                        user.setId(rs.getInt("UserId"));
                        user.setFirstName(rs.getString("FirstName"));
                        user.setLastName(rs.getString("LastName"));
                        user.setEmail(rs.getString("Email"));
                        user.setAddressField_1(rs.getString("Address_1"));
                        user.setAddressField_2(rs.getString("Address_2"));
                        user.setCity(rs.getString("City"));
                        user.setState(rs.getString("State"));
                        user.setPostCode(rs.getString("Postal_Code"));
                        user.setCountry(rs.getString("Country"));
                        user.setPassword(rs.getString("Password"));
                        users.add(user);
                } while (rs.next());
            }
            
            return users;
            
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }    
    
    public static User getUser(String id) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM User "
                + "WHERE UserId = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            User user = null;
            
            if (rs.first()) {
                user = new User();
                user.setId(rs.getInt("UserID"));
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setEmail(rs.getString("Email"));
                user.setAddressField_1(rs.getString("Address_1"));
                user.setAddressField_2(rs.getString("Address_2"));
                user.setCity(rs.getString("City"));
                user.setState(rs.getString("State"));
                user.setPostCode(rs.getString("Postal_Code"));
                user.setCountry(rs.getString("Country"));
                user.setPassword(rs.getString("Password"));
            }
            return user;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static void addUser(
            String lastName,
            String firstName,
            String email,
            String address_1,
            String address_2,
            String city,
            String state,
            String postalCode,
            String country,
            String password
    ) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setAddressField_1(address_1);
        user.setAddressField_2(address_2);
        user.setCity(city);
        user.setState(state);
        user.setPostCode(postalCode);
        user.setCountry(country);
        user.setPassword(password);
        
        addUser(user);
    }
    
    public static int addUser(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO User (LastName, FirstName, Email, Address_1, Address_2, City, State, Postal_Code, Country, Password)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getLastName());
            ps.setString(2, user.getFirstName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getAddressField_1());
            ps.setString(5, user.getAddressField_2());
            ps.setString(6, user.getCity());
            ps.setString(7, user.getState());
            ps.setString(8, user.getPostCode());
            ps.setString(9, user.getCountry());
            ps.setString(10, user.getPassword());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
}
