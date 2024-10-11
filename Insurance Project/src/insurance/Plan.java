/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package insurance;

/**
 *
 * @author kirut
 */
public class Plan {
    
    
    private int planID;
    private int customerID;
    private int invoiceID;



    public Plan()//empty constructor
    {

    }

    
     public Plan (int planID, int customerID, int invoiceID)//overloaded constructor
    {
     
        this.planID = planID;
        this.customerID = customerID;
       this.invoiceID = invoiceID;
    }

public Plan (int customerID, int invoiceID)//overloaded constructor
    {
     
        
        this.customerID = customerID;
       this.invoiceID = invoiceID;
    }

    public void setPlanId(int planID)
    {

       this.planID = planID;
    }

    public void setInvoiceID(int invoiceID)
    {

       this.invoiceID = invoiceID;
    }


    public void setCustId(int customerID)
    {

        this.customerID = customerID;
    }



    public int getInvoiceID()
    {

        return invoiceID;
    }

    public int getCustId()
    {

        return customerID;
    }

    public int getPlanId()
    {
        return planID;
      
    }

 


}
