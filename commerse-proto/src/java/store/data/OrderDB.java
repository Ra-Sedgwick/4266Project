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
    
    
    public static int insert(Order order) {
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "INSERT INTO `Order`"
                + "(OrderNumber, date, user_id, tax_rate, total_cost, paid) "
                + "Values (?, ?, ?, ?, ?, ?)";
        
        java.sql.Timestamp sqlDate = new java.sql.Timestamp(order.getDate().getTime());
        order.setTotalCost();
        
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, order.getOrderNumber());
            ps.setTimestamp(2, sqlDate);
            ps.setInt(3, order.getUser().getId());
            ps.setDouble(4, order.getTaxRate());
            ps.setDouble(5, order.getTotalCost());
            ps.setBoolean(6, order.getIsPaid());
            
            return ps.executeUpdate();
           
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DbUtil.closeResultSet(rs);
            DbUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
                
        
    }
    
    public static ArrayList<Order> getOrders() {
        ArrayList<Order> orders = new ArrayList<>();
        ArrayList<OrderItem> orderItems;
        Order order;
        User user;
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM `Order`";
        
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            
            if (rs.first()) {
                do {
                    order = new Order();
                    user = UserDB.getUser(rs.getInt("User_ID"));
                    
                    orderItems = new ArrayList<>();
                    orderItems = OrderItemDB.getOrderItems(rs.getString("OrderNumber"));
                    
                    order.setUser(user);
                    order.setOrderNumber(rs.getString("OrderNumber"));
                    order.setDate(rs.getDate("Date"));
                    order.setOrderItems(orderItems);
                    order.setTaxRate(rs.getDouble("Tax_Rate"));
                    order.setTotalCost(rs.getDouble("Total_Cost"));
                    
                    
                    orders.add((order));
                    
                } while (rs.next());
            }
            
            return orders;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DbUtil.closeResultSet(rs);
            DbUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static ArrayList<Order> getOrders(int userID) {
        
        ArrayList<Order> orders = new ArrayList<>();
        ArrayList<OrderItem> orderItems;
        Order order;
        User user;
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM `Order` WHERE User_ID=?";
        
        try {
            ps = connection.prepareStatement(query);
            ps.setInt(1, userID);
            rs = ps.executeQuery();
            
            if (rs.first()) {
                do {
                    order = new Order();
                    user = UserDB.getUser(rs.getInt("User_ID"));
                    
                    orderItems = new ArrayList<>();
                    orderItems = OrderItemDB.getOrderItems(rs.getString("OrderNumber"));
                    
                    order.setUser(user);
                    order.setOrderNumber(rs.getString("OrderNumber"));
                    order.setDate(rs.getDate("Date"));
                    order.setOrderItems(orderItems);
                    order.setTaxRate(rs.getDouble("Tax_Rate"));
                    order.setTotalCost(rs.getDouble("Total_Cost"));
                    
                    
                    orders.add((order));
                    
                } while (rs.next());
            }
            
            return orders;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DbUtil.closeResultSet(rs);
            DbUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static Order getOrder(String orderNumber) {
        
        ArrayList<OrderItem> orderItems;
        Order order = new Order();
        User user;
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT * FROM `Order` WHERE OrderNumber = ?";
        
        try {
            
            ps = connection.prepareStatement(query);
            ps.setString(1, orderNumber);
            rs = ps.executeQuery();
            
            if (rs.first()) {
                do {
                    order = new Order();
                    user = UserDB.getUser(rs.getInt("User_ID"));
                    
                    orderItems = new ArrayList<>();
                    orderItems = OrderItemDB.getOrderItems(rs.getString("OrderNumber"));
                    
                    order.setUser(user);
                    order.setOrderNumber(rs.getString("OrderNumber"));
                    order.setDate(rs.getDate("Date"));
                    order.setOrderItems(orderItems);
                    order.setTaxRate(rs.getDouble("Tax_Rate"));
                    order.setTotalCost(rs.getDouble("Total_Cost"));
                    
                    

                    
                } while (rs.next());
            }
            
            return order;
        } catch (SQLException e) {
            System.out.println(e);
            return order;
        } finally {
            DbUtil.closeResultSet(rs);
            DbUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    
    public static int updateOrder(Order order, String orderNumber) {
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        java.sql.Timestamp sqlDate = new java.sql.Timestamp(order.getDate().getTime());
        
        String query = "UPDATE `Order` SET " +
                "OrderNumber = ?, " +
                "Date = ?, " +
                "Total_Cost = ? " +
                "WHERE OrderNumber = ?";
        
        try {
            
            ps = connection.prepareStatement(query);
            ps.setString(1, order.getOrderNumber());
            ps.setTimestamp(2, sqlDate);
            ps.setDouble(3, order.getTotalCost());
            ps.setString(4, orderNumber);

            
            
            return ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DbUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static int delete(String orderNumber) {
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        
        String query = "DELETE FROM `Order` WHERE OrderNumber = ?";
        
        try {
            
            ps = connection.prepareStatement(query);
            ps.setString(1, orderNumber);
            
            return ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DbUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
}
