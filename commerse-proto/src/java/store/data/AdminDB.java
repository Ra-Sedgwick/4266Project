/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.data;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import store.business.User;

/**
 *
 * @author rased
 */
public class AdminDB extends HttpServlet {
       
        
    public static User getUser(String userName) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM userpass "
                + "WHERE UserName = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, userName);
            rs = ps.executeQuery();
            User user = null;
            
            if (rs.first()) {
                user = new User();
                user.setEmail(rs.getString("UserName"));
                user.setSecret(rs.getString("Secret"));
                user.setPassword(rs.getString("Password"));
            }
            return user;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DbUtil.closeResultSet(rs);
            DbUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

}
