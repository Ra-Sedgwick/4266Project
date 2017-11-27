package store.data;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import store.business.Product;
import store.business.User;
import store.data.ConnectionPool;
import store.data.DBUtil;
import store.data.ProductDB;
import store.data.UserDB;

// Create Product and User Tables
// Insert sameple data
public class DbSetup {
    
    public static void initializeTables() {
        
        createTables();
        insertUser();
        insertProduct();
    }
    
    private static boolean createTables() {
        
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String dropUserScript = "DROP TABLE IF EXISTS User;";
        String dropProductScript = "DROP TABLE IF EXISTS Product;";
        
        String createUserScript = "CREATE TABLE User (" +
          "UserID int(11) NOT NULL AUTO_INCREMENT," +
          "LastName varchar(50) DEFAULT NULL," +
          "FirstName varchar(50) DEFAULT NULL," +
          "Email varchar(50) DEFAULT NULL," +
          "Address_1 varchar(50) DEFAULT NULL," +
          "Address_2 varchar(50) NOT NULL," +
          "City varchar(50) DEFAULT NULL," +
          "State varchar(50) DEFAULT NULL," +
          "Postal_Code int(11) DEFAULT NULL," +
          "Country varchar(50) DEFAULT NULL," +
          "Password varchar(50) NOT NULL," +
          "PRIMARY KEY (`UserID`)" +
        ");";
        
        
        String createProductScript = "CREATE TABLE Product (" +
            "ProductCode int(11) NOT NULL AUTO_INCREMENT," +
            "Name varchar(50) DEFAULT NULL," +
            "CatelogCategory varchar(50) DEFAULT NULL," +
            "Description varchar(255) DEFAULT NULL," +
            "Price decimal(10,2) DEFAULT NULL," +
            "ImageURL varchar(250) DEFAULT NULL," +
            "PRIMARY KEY (`ProductCode`)" +
          ");";
        
        
        try {
            
            ps = connection.prepareStatement(dropUserScript);
            rs = ps.executeQuery(dropUserScript);
            
            ps = connection.prepareStatement(createUserScript);
            rs = ps.executeQuery(createUserScript);
            
            ps = connection.prepareStatement(dropProductScript);
            rs = ps.executeQuery(dropProductScript);
            
            ps = connection.prepareStatement(createProductScript);
            rs = ps.executeQuery(createProductScript);
            
            
            
            return true;
            
        } catch (SQLException e) {
            
            System.out.println(e);
            return false;
            
        } finally {
            
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
            
        }
    }
    
    private static void insertUser() {
        User user = new User();
        user.setFirstName("Test");
        user.setLastName("User");
        user.setAddressField_1("123 Fake Street");
        user.setAddressField_2("");
        user.setEmail("testUser@gmail.com");
        user.setPassword("toor");
        user.setCountry("USA");
        user.setState("NC");
        user.setPostCode("55555");
        user.setCity("Charlotte");
        
        UserDB.addUser(user);
    }
    
    private static void insertProduct() {
        Product product = new Product();
        product.setProductCode(99);
        product.setCatalogCategory("99");
        product.setProductName("Test Product");
        product.setImageURL("./test");
        product.setDescription("A Test Product");
        product.setPrice(99.99);
        
        ProductDB.addProduct(product);
    }
    
    
}
