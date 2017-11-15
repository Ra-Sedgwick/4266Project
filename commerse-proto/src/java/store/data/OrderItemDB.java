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
import store.business.Product;

/**
 *
 * @author rased
 */
public class OrderItemDB {
    
    public static ArrayList<OrderItem> getOrderItems(String orderNumber) {
            
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        OrderItem orderItem;
        Product product;
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM Order_Item WHERE `Order`.User_ID = " + orderNumber;
        
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery(query);
            
            if (rs.first()) {
                do {
                    orderItem = new OrderItem();
                    product = ProductDB.getProduct(rs.getString("ProductCode"));
                    
                    
                    orderItem.setOrderNumber(rs.getString("OrderNumber"));
                    orderItem.setProduct(product);
                    orderItem.setQuantity(rs.getInt("Quantity"));
                    orderItems.add(orderItem);
                    
                } while (rs.next());
            }
            
            return orderItems;
            
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
