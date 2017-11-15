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
import store.business.Order;
import store.business.OrderItem;
import store.business.User;

/**
 *
 * @author rased
 */
public class OrderDB {
    
    
    public static ArrayList<Order> getOrders(int userID) {
        
        ArrayList<Order> orders = new ArrayList<>();
        ArrayList<OrderItem> orderItems;
        Order order;
        User user;
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM `Order` WHERE `Order`.User_ID = " + userID;
        
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery(query);
            
            if (rs.first()) {
                do {
                    order = new Order();
                    user = UserDB.getUser(rs.getString("User_ID"));
                    
                    orderItems = new ArrayList<OrderItem>();
                    orderItems = OrderItemDB.getOrderItems(rs.getString("OrderNumber"));
                    
                    order.setUser(user);
                    order.setDate(rs.getDate("Date"));
                    order.setOrderItems(orderItems);
                    order.setTaxRate(rs.getDouble("Tax_Rate"));
                    
                    
                    orders.add((order));
                    
                } while (rs.next());
            }
            
            return orders;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            UtilDb.closeResultSet(rs);
            UtilDb.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    
    
}
