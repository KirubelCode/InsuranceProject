/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package insurance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;


public class CustomerDAO {
    final String DATABASE_URL = "jdbc:mysql://localhost/customers";
    
    
    
public void deleteCustomer(Customer customer) {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            int result = 0;
   

    try {
        // establish connection to database
        connection = DriverManager.getConnection(DATABASE_URL, "root", "password");

        // create Prepared Statement for deleting data from table
        preparedStatement  = connection.prepareStatement(
                "DELETE FROM customer WHERE customerId = ?");
        
        preparedStatement.setInt(1, customer.getCustomerId());
        
        

        // execute the update
        result = preparedStatement.executeUpdate();
    } catch (SQLException sqlException) {
        sqlException.printStackTrace();
    } finally {
        // close the resources
        try {
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    if (result > 0) {
        System.out.println("Customer deleted successfully!");
    } else {
        System.out.println("Failed to delete customer!");
    }



       
    
    }
        
public void deletePlan(Plan plans) {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            int result = 0;
   

    try {
        // establish connection to database
        connection = DriverManager.getConnection(DATABASE_URL, "root", "password");

        // create Prepared Statement for deleting data from table
        preparedStatement  = connection.prepareStatement(
                "DELETE FROM plan WHERE plansId = ?");
        
        preparedStatement.setInt(1, plans.getPlanId());
        
        

        // execute the update
        result = preparedStatement.executeUpdate();
    } catch (SQLException sqlException) {
        sqlException.printStackTrace();
    } finally {
        // close the resources
        try {
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    if (result > 0) {
        System.out.println("Plan deleted successfully!");
    } else {
        System.out.println("Failed to delete Invoice!");
    }



       
    
    }
        
public void deleteInvoice(Invoice invoice) {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            int result = 0;
   

    try {
        // establish connection to database
        connection = DriverManager.getConnection(DATABASE_URL, "root", "password");

        // create Prepared Statement for deleting data from table
        preparedStatement  = connection.prepareStatement(
                "DELETE FROM invoice WHERE invoiceId = ?");
        
        preparedStatement.setInt(1, invoice.getInvoiceID());
        
        

        // execute the update
        result = preparedStatement.executeUpdate();
    } catch (SQLException sqlException) {
        sqlException.printStackTrace();
    } finally {
        // close the resources
        try {
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    if (result > 0) {
        System.out.println("Invoice deleted successfully!");
    } else {
        System.out.println("Failed to delete Invoice!");
    }



       
    
    }

public void insertPlan(Plan plan) {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    
    try {
        // establish connection to database
        connection = DriverManager.getConnection(DATABASE_URL, "root", "password");

        // prepare the SQL statement for inserting a new row into the Plan table
        preparedStatement = connection.prepareStatement(
                "INSERT INTO plan (customer_id, invoice_id) " +
                "SELECT c.customerId, i.invoiceId " +
                "FROM customer c " +
                "INNER JOIN invoice i ON c.customerId = i.customerID " +
                "LEFT JOIN plan p ON c.customerId = p.customer_id AND i.invoiceId = p.invoice_id " +
                "WHERE p.customer_id IS NULL AND p.invoice_id IS NULL;");

        // execute the prepared statement
        int rowsUpdated = preparedStatement.executeUpdate();

        if (rowsUpdated > 0) {
            System.out.println("Plan inserted successfully!");
        } else {
            System.out.println("Failed to insert plan!");
        }
    } catch (SQLException sqlException) {
        sqlException.printStackTrace();
    } finally {
        // close the resources
        try {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



public void insertInvoice(Invoice invoice) {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            int result = 0;
            int rowsUpdated =0;
    
            try {
                // establish connection to database
                connection = DriverManager.getConnection(DATABASE_URL, "root", "password");
    
                // create Prepared Statement for inserting data into table
                preparedStatement = connection.prepareStatement(
                        "INSERT INTO invoice (paymentType,planType) VALUES (?, ?)");
                
                // set the parameter values
                preparedStatement.setString(1, invoice.getPaymentType());
                preparedStatement.setString(2, invoice.getPlanType());
                
                // execute the update
                result = preparedStatement.executeUpdate();
                
                
               PreparedStatement updateStatement = connection.prepareStatement(
                    "UPDATE invoice " +
                    "INNER JOIN customer " +
                    "ON invoice.invoiceId = customer.customerId " +
                    "SET invoice.customerID = customer.customerId " +
                    "WHERE invoice.customerID IS NULL"
                );

                rowsUpdated = updateStatement.executeUpdate();

                // close the resources
                updateStatement.close();
                connection.close();


                            } catch (SQLException sqlException) {
                                sqlException.printStackTrace();
                            } finally {
                                // close the resources
                                        try {
                            preparedStatement.close();
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }
    
            if (result > 0) {
                System.out.println("Invoice inserted successfully!");
            } else {
                System.out.println("Failed to insert invoice!");
            }
            
            if (rowsUpdated > 0) {
                System.out.println("Invoice inserted YESSSSS!");
            } else {
                System.out.println("Failed to insert invoice!");
            }
        }
      
public void insertCustomer(Customer customer) {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            int result = 0;
    
            try {
                // establish connection to database
                connection = DriverManager.getConnection(DATABASE_URL, "root", "password");
    
                // create Prepared Statement for inserting data into table
                preparedStatement = connection.prepareStatement(
                        "INSERT INTO customer (fName, lName, date_of_birth, phone, address) VALUES (?, ?, ?, ?, ?)");
    
                // set the parameter values
                preparedStatement.setString(1, customer.getFirstName());
                preparedStatement.setString(2, customer.getLastName());
                preparedStatement.setDate(3, customer.getDateOfBirth());
                preparedStatement.setInt(4, customer.getPhone());
                preparedStatement.setString(5, customer.getAddress());
    
                // execute the update
                result = preparedStatement.executeUpdate();
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } finally {
                // close the resources
                try {
                    preparedStatement.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
    
            if (result > 0) {
                System.out.println("Customer inserted successfully!");
            } else {
                System.out.println("Failed to insert customer!");
            }
        }


   public Customer getCustomerById(int customerId) {
    Customer customer = null;
    String query = "SELECT customerId,fName,lName,date_of_birth,address,phone FROM customer WHERE customerId = ?";
    try (Connection connection = DriverManager.getConnection(DATABASE_URL,"root", "password");
         PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, customerId);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String firstName = resultSet.getString("fName");
            String lastName = resultSet.getString("lName");
            Date date = resultSet.getDate("date_of_birth");
            java.sql.Date sqlDateOfBirth = new java.sql.Date(date.getTime());
            int phone = resultSet.getInt("phone");
            String address = resultSet.getString("address");
            
            customer = new Customer(customerId, firstName, lastName, sqlDateOfBirth, phone, address);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return customer;
}
   
        public Invoice getInvoiceById(int invoiceId) {
    Invoice invoice = null;
    String query = "SELECT invoiceId,paymentType,planType,customerId FROM invoice WHERE invoiceId = ?";
    try (Connection connection = DriverManager.getConnection(DATABASE_URL,"root", "password");
         PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, invoiceId);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            String paymentType = resultSet.getString("paymentType");
            String planType = resultSet.getString("planType");
            int customerId = resultSet.getInt("customerID");

            
            invoice = new Invoice(invoiceId, paymentType, planType, customerId);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return invoice;
}
        
  
 public Plan getPlanById(int planId) {
    Plan plan = null;
    String query = "SELECT plansId,customer_id,invoice_id FROM plan WHERE plansId = ?";
    try (Connection connection = DriverManager.getConnection(DATABASE_URL,"root", "password");
         PreparedStatement statement = connection.prepareStatement(query)) {
        statement.setInt(1, planId);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            int customerid = resultSet.getInt("customer_id");
            int invoiceid = resultSet.getInt("invoice_id");
            

            
            plan = new Plan(planId, customerid, invoiceid);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return plan;
}
      


      public void updateInvoice(Invoice invoice) {
       
       int result = 0;
    try (Connection connection = DriverManager.getConnection(DATABASE_URL,"root", "password");
         PreparedStatement statement = connection.prepareStatement(
                 "UPDATE invoice SET paymentType = ?, planType = ? WHERE invoiceId = ?")) 
    {
        
        // set the parameter values
        statement.setString(1, invoice.getPaymentType());
        statement.setString(2, invoice.getPlanType());
        statement.setInt(3, invoice.getInvoiceID());
        
        
        // execute the update
       result= statement.executeUpdate();
       
       
       
       
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    if (result > 0) {
                System.out.println("Invoice updated successfully!");
            } else {
                System.out.println("Failed to update invoice!");
            }
}
      
      
      
   public void updateCustomer(Customer customer) {
       
       int result = 0;
    try (Connection connection = DriverManager.getConnection(DATABASE_URL,"root", "password");
         PreparedStatement statement = connection.prepareStatement(
                 "UPDATE customer SET fName = ?, lName = ?, date_of_birth = ?, phone = ?, address = ? WHERE customerId = ?")) 
    {
        
        // set the parameter values
        statement.setString(1, customer.getFirstName());
        statement.setString(2, customer.getLastName());
        statement.setDate(3, customer.getDateOfBirth());
        statement.setInt(4, customer.getPhone());
        statement.setString(5, customer.getAddress());
        statement.setInt(6, customer.getCustomerId());
        
        // update the Customer object with the new values from the GUI components


        // execute the update
       result= statement.executeUpdate();
       
       
       
       
    } catch (SQLException e) {
        e.printStackTrace();
    }
    
    if (result > 0) {
                System.out.println("Customer updated successfully!");
            } else {
                System.out.println("Failed to update customer!");
            }
}

    public ArrayList<String> getCustomerNames() {
        ArrayList<String> customerNames = new ArrayList<>();
        String query = "SELECT customerId, CONCAT(fName, ' ', lName) AS fullName FROM customer";
        
        try (Connection connection = DriverManager.getConnection(DATABASE_URL,"root", "password");
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            
            while (resultSet.next()) {
                int customerId = resultSet.getInt("customerId");
                String fullName = resultSet.getString("fullName");
                String customerInfo = customerId + ": " + fullName;
                customerNames.add(customerInfo);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return customerNames;
    }
    
   
}
