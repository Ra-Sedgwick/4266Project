/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.business;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author robert
 */
public class Cart {
    
    ArrayList<OrderItem> orderItems;
    
    public Cart() {};
    
    public int Count() {
        return orderItems.size();
    }
    
   public static Cart copy(Cart _cart) {
       Cart cart = new Cart();
       cart.setOrderItems();
       List<OrderItem> oi = _cart.getOrderItems();
       
       for (int i = 0; i < _cart.Count(); i++) {
           OrderItem o = oi.get(i);
           cart.addItem(o.getProduct(), o.getQuantity());
       }
       
       return cart;
   }
    
    public void addItem(Product product, int quantity) {
        
        boolean isNew = true; 
        
        //Check for existing product
        for (OrderItem i : orderItems) {
            if (i.getProduct().equals(product)) {
                i.setQuantity(quantity);
                isNew = false;
            }
        }
        
        // Add New product if not found
        if (isNew) {
            OrderItem item = new OrderItem();
            item.setProduct(product);
            item.setQuantity(quantity);
            orderItems.add(item);
        }
    }
    
    public OrderItem getItem(Product product) {
        for (OrderItem i : orderItems) {
            if (i.getProduct().getProductCode() == product.getProductCode()){
                return i;
            }
        }
        return null; 
    }
    
    public void removeItem(Product product) {
        ArrayList<OrderItem> toRemove = new ArrayList<OrderItem>();
        
        
        
        for (OrderItem i : orderItems) {
            if (i.getProduct().equals(product)) {
                toRemove.add(i);
            }
        }
        
        for (OrderItem i : toRemove) {
            orderItems.remove(i);
        }
    }
    
    
    
    public ArrayList<OrderItem> getOrderItems() {
        return orderItems;
    }
    
    public void setOrderItems() {
        this.orderItems = new ArrayList<OrderItem>();
    }
    
    public void emptyCart() {
        orderItems.clear();
    }
    
}
