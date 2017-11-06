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
}
