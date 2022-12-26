package models;

public class InvoiceItem {

    private int itemNo;
    private String itemName;
    private double itemPrice;
    private int itemCount;

    //private double itemTotal;
    private Invoice Invoice;


    public Invoice getInvoice() {
        return Invoice;
    }

    public void setInvoice(models.Invoice invoice) {
        Invoice = invoice;
    }

    public InvoiceItem()
    {

        itemName=new String();

    }

    public int getItemNo() {
        return itemNo;
    }

    public void setItemNo(int itemNo) {
        this.itemNo = itemNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public double getItemTotal() {
        return itemPrice*itemCount;
    }

    /*
    public void setItemTotal() {
        this.itemTotal = itemPrice*itemCount;
    }
    */





}
