/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
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
    
    public static ArrayList<User> getUsers() {
        
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
                        user.setFirstName(rs.getString("FirstName"));
                        user.setLastName(rs.getString("LastName"));
                        user.setEmail(rs.getString("Email"));
                        user.setAddressField_1(rs.getString("Address_1"));
                        user.setAddressField_2(rs.getString("Address_2"));
                        user.setCity(rs.getString("City"));
                        user.setState(rs.getString("State"));
                        user.setPostCode(rs.getString("Postal_Code"));
                        user.setCountry(rs.getString("Country"));
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
}
