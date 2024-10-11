/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package insurance;


import java.sql.Date;
import javax.swing.JOptionPane;

public class Customer {
    private int customerId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private int phone;
    private String address;

    public Customer() {
        // empty constructor
    }

    
    public Customer(int customerId, String firstName, String lastName, Date dateOfBirth, int phone, String address) {
       
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.address = address;
        this.customerId = customerId;
    }
    
    
    public Customer(String firstName, String lastName, Date dateOfBirth, int phone, String address) {
       
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
        this.address = address;
    }

    public Customer(String firstName, String lastName, int phone, String address) {
       
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    

    
     public boolean isValid() {
      
         return (firstName.matches("[a-zA-Z]+") && lastName.matches("[a-zA-Z]+") && phone > 0 )  ;
    }
}
