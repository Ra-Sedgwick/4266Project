/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import store.business.Product;
import store.business.User;

/**
 *
 * @author rased
 */
public class DBProduct {
    
    public static ArrayList<Product> getProducts() {
        
        ArrayList<Product> products = new ArrayList<Product>();
        Product product = null;
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Product";
        
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery(query);

            if (rs.first()) {
                do {
                        product = new Product();
                        product.setProductName(rs.getString("Name"));
                        product.setCatalogCategory(rs.getString("CatelogCategory"));
                        product.setDescription(rs.getString("Description"));
                        product.setPrice(rs.getInt("Price"));
                        products.add(product);
                } while (rs.next());
            }
            
            return products;
            
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }   
    
    public static void addProduct(
            String name, 
            String category,
            double price,
            String description) {
        
        Product p = new Product();
        p.setProductName(name);
        p.setCatalogCategory(category);
        p.setPrice(price);
        p.setDescription(description);
        
        addProduct(p);
    }
    
    public static int addProduct(Product product) {
         ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO Product (Name, CatelogCategory, Description, Price, ImageURL)"
                + "VALUES (?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, product.getProductName());
            ps.setString(2, product.getCatalogCategory());
            ps.setString(3, product.getDescription());
            ps.setDouble(4, product.getPrice());
            ps.setString(5, "C:\\Users\\rased\\projects\\4166Project\\commerse-proto\\web\\images\\pedal.jpg");
            
            return ps.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static Product getProduct(String productCode) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT * FROM Product "
                + "WHERE ProductCode = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, productCode);
            rs = ps.executeQuery();
            
            Product product = null;
            
            if (rs.first()) {
                product = new Product();
                product.setProductName(rs.getString("Name"));
                product.setCatalogCategory(rs.getString("CatelogCategory"));
                product.setDescription(rs.getString("Description"));
                product.setPrice(rs.getInt("Price"));
            }
            
            return product;
            
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
