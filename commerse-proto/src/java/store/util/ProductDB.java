/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import store.business.Product;

//    private String productCode;
//    private String productName;
//    private String catalogCategory;
//    private String description; 
//    private double price; 

/**
 *
 * @author robert
 */
public class ProductDB {
    
    private List<Product> products;
    
    public ProductDB() {
        products = new ArrayList<Product>();
        buildProducts();
    }
    
    public List<Product> getProducts() {
        return products;
    }
    
    public List<Product> getByCatagory(String catagory) {
        
        List<Product> filteredProducts = new ArrayList<Product>();
        
        for (Product p : products)
            if (p.getCatalogCategory().equals(catagory))
                filteredProducts.add(p);
        
        return filteredProducts;
    }
    
    public Product getProduct(String productCode) {
        
        int pc = Integer.parseInt(productCode);
        
        for (Product p : products) 
            if (p.getProductCode() == pc)
                return p; 
        
        
        return null; 
    }
    
    
    private List<Product> buildProducts() {
       
        Product p; 
       
        p = new Product();
        p.setProductCode(1);
        p.setProductName("Shimano");
        p.setCatalogCategory("clipless");
        p.setPrice(199.99);
        p.setDescription("Shimano Ultegra PD-6800 SPD-SL Carbon Road Pedas");
        products.add(p);
        
        p = new Product();
        p.setProductCode(2);
        p.setProductName("Crank Brothers");
        p.setCatalogCategory("clipless");
        p.setPrice(94.99);
        p.setDescription("Cranckbrothers Candy 2 Pedals");
        products.add(p);
        
        p = new Product();
        p.setProductCode(3);
        p.setProductName("Look");
        p.setCatalogCategory("clipless");
        p.setPrice(40.64);
        p.setDescription("Look Keo Classic 3");
        products.add(p);
        
        p = new Product();
        p.setProductCode(4);
        p.setProductName("Crank Brothers");
        p.setCatalogCategory("platform");
        p.setPrice(120.00);
        p.setDescription("Crank Brothers 5050 Flat Pedals");
        products.add(p);
        
        p = new Product();
        p.setProductCode(5);
        p.setProductName("Shimano");
        p.setCatalogCategory("platform");
        p.setPrice(89.50);
        p.setDescription("Shimano Saint MX80");
        products.add(p);
        
        p = new Product();
        p.setProductCode(6);
        p.setProductName("DMR");
        p.setCatalogCategory("platform");
        p.setPrice(53.30);
        p.setDescription("DRM v12 Alloy Pedals");
        products.add(p);
        
        
        
        return products;

    }
}
