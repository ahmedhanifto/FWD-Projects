package models;


import java.util.ArrayList;
import java.util.Date;

public class Invoice {
    private  int invoiceNumber;
    private String invoiceDate;
    private String customerName;
    private double invoiceTotal;

    private ArrayList<InvoiceItem> items ;


    public Invoice() {
        //invoiceNumber++;
        //invoiceDate=new Date();
        //customerName=new String();



    }

    public  int getInvoiceNumber() {
        return invoiceNumber;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getInvoiceTotal() {
        double total=0;
        for(InvoiceItem item: getItems())
        {
            total+=item.getItemTotal();

        }

        return total ;
    }
    public ArrayList<InvoiceItem> getItems() {
        if (items == null) {
            items = new ArrayList<>();
        }
        return items;
    }

    public void setItems(ArrayList<InvoiceItem> items) {
        this.items = items;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }




}
