package insurance;

import javax.swing.JOptionPane;

public class Invoice {

    private int invoiceID;
    private int customerID;
    private String paymentType;
    private String planType;


    public Invoice()//empty constructor
    {

    }

    
     public Invoice (int invoiceID,String paymentType, String planType)//overloaded constructor
    {
     
        this.paymentType = paymentType;
        this.planType = planType;
       this.invoiceID = invoiceID;
    }

       public Invoice (int invoiceID,String paymentType, String planType, int customerID)//overloaded constructor
    {
     
        this.paymentType = paymentType;
        this.planType = planType;
       this.invoiceID = invoiceID;
        this.customerID = invoiceID;
       }
     public Invoice(String paymentType, String planType)//overloaded constructor
    {
     
        this.paymentType = paymentType;
        this.planType = planType;
       
    }




    public void setInvoiceID(int invoiceID)
    {

       this.invoiceID = invoiceID;
    }


    public void setCustId(int customerID)
    {

        this.customerID = customerID;
    }

    public void setPaymentType(String paymentType)
    {

        this.paymentType = paymentType;
    }

    public void setPlanType(String planType)
     {
        this.planType = planType;
     }


    public int getInvoiceID()
    {

        return invoiceID;
    }

    public int getCustId()
    {

        return customerID;
    }

    public String getPaymentType()
    {

        return paymentType;
    }

    public String getPlanType()
    {

        return planType;
    }


  public boolean isValid() {
    return paymentType != null && !paymentType.isEmpty() && planType != null && !planType.isEmpty();
}





}