/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.business;

/**
 *
 * @author robert
 */
public class OrderItem {
    
    private Product product;
    private int quantity;
    
    public OrderItem() {};
    
    public void setProduct(Product _product) {
        product = _product;
    }
    
    public Product getProduct() {
        return product;
    }
    
    public void setQuantity(int _quantity) {
        quantity = _quantity;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public double getTotal() {
        return product.getPrice() * quantity; 
    }
}
