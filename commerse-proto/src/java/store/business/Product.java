/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.business;

import java.io.Serializable;
import java.text.NumberFormat;

/**
 *
 * @author Robert Sedgwick
 */
public class Product implements Serializable {
    
    private String productCode;
    private String productName;
    private String catalogCategory;
    private String description; 
    private double price; 
    
    public Product() {}
    
    public String getProductCode() {
        return productCode;
    }
    
    public void setProductCode(String _productCode) {
        productCode = _productCode;
    }
    
    public String getProductName() {
        return productName; 
    }
    
    public void setProductName(String _productName) {
        productName = _productName;
    }
    
    public String getCatalogCategory() {
        return catalogCategory;
    }
    
    public void setCatalogCategory(String _catalogCategory) {
        catalogCategory = _catalogCategory; 
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String _description) {
        description = _description; 
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double _price) {
        price = _price;
    }
    
    
    public String getPriceCurrencyFormat() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(price);
    }
    
    public String getImageURL() {
        //String imageURL = "images/" + code + ".png";
        //return imageURL;

        return "/images/pedal.jpg";
    }
}
