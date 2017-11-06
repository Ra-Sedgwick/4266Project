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
public class User {
    
    private String firstName;
    private String lastName;
    private String email;
    private String addressField_1;
    private String addressField_2;
    private String city;
    private String state;
    private String postCode;
    private String country;
    private String id;
    private String password;
    
    public User() {};
    
    public void setId(String _id) {
        id = _id;
    }
    
    public String getId() {
        return id;
    }
    
    public void setPassword(String _password) {
        password = _password;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setFirstName(String _firstName) {
        firstName = _firstName;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setLastName(String _lastName) {
        lastName = _lastName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setEmail(String _email) {
        email = _email;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setAddressField_1(String _address) {
        addressField_1 = _address;
    }
    
    public String getAddressField_1() {
        return addressField_1;
    }
    
    public void setAddressField_2(String _address) {
        addressField_2 = _address;
    }
    
    public String getAddressField_2() {
        return addressField_2;
    }
    
    public void setCity(String _city) {
        city = _city;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setState(String _state) {
        state = _state;
    }
    
    public String getState() {
        return state;
    }
    
    public void setPostCode(String _postCode) {
        postCode = _postCode;
    }
    
    public String getPostCode() {
        return postCode;
    }
    
    public void setCountry(String _country) {
        country = _country;
    }
    
    public String getCountry() {
        return country;
    }
}
