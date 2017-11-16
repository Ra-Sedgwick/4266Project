/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.business;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author robert
 */
public class Order {
    
    private String orderNumber;
    private Date date;
    private User user;
    private ArrayList<OrderItem> orderItems;
    private double taxRate;
    private double totalCost;
    private boolean isPaid;
    
    public Order() {};
    
    public void setOrderNumber(String _orderNumber) {
        orderNumber = _orderNumber;
    }
    
    public String getOrderNumber() {
        return orderNumber;
    }
    
    public void setDate(Date _date) {
        date = _date;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setUser(User _user) {
        user = _user;
    }
    
    public User getUser() {
        return user;
    }
    
    public void setOrderItems(ArrayList<OrderItem> _items) {
        orderItems = _items;
    }
    
    public ArrayList<OrderItem> getOrderItems() {
        return orderItems;
    }
    
    public void setTaxRate(double _taxRate) {
        taxRate = _taxRate;
    }
    
    public double getTaxRate() {
        return taxRate;
    }
    
    public void setTotalCost() {
        
        totalCost = 0.0;
        
        for (OrderItem i : orderItems) {
            totalCost += (i.getProduct().getPrice() * i.getQuantity());
        }
        
        totalCost = totalCost + (totalCost * taxRate);
        int x = 10;
    }
    
    public double getSubTotal() {
        double subTotal = 0.0;
        for (OrderItem i : orderItems) {
            subTotal += (i.getProduct().getPrice() * i.getQuantity());
        }
        return subTotal;
    }
    
    public double getTotalCost() {   
        return totalCost;
    }
    
    public void setIsPaid(boolean _isPaid) {
        isPaid = _isPaid;
    }
    
    public boolean getIsPaid() {
        return isPaid;
    }
}
