package view;

import controller.Controller;
import models.Invoice;
import models.InvoicesTableModel;
import models.ItemsTableModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Layout extends JFrame {

    //Declare the Layout Panel
    private JPanel p1;
    private JPanel p2;
    private JPanel mainPanel;

    //Declare the menu bar elements
    private JMenuBar fileMenuBar;
    private JMenu fileMenu;
    private JMenuItem loadFileItem;
    private JMenuItem saveFileItem;

    //Declare the left panel items
    private JTable invoicesTable;

    private JLabel invoicesTableLbl;
    private JButton createInvoiceBtn;
    private JButton deleteInvoiceBtn;
    //private String[] invoicesTableHeader={"No.","Date","Customer","Total"};
    /*
    private String[][] invoicesTableData={
            {"No.1","Date1","Customer1","Total1"},
            {"No.2","Date2","Customer2","Total2"},
            {"No.3","Date3","Customer3","Total3"}
    };
    */

    //Declare the right panel items
    private JLabel invoiceNumberLbl;
    private JLabel invoiceNumberLbl2;
    private JLabel invoiceDateLbl;
    private JTextField invoiceDateTf;
    private JLabel customerNameLbl;
    private JTextField customerNameTf;
    private JLabel invoiceTotalLbl;
    private JLabel invoiceTotalLbl2;


    private JTable invoiceItems;



    private JLabel invoiceItemsLbl;


  /*
    private String[] invoicesItemsHeader={"No.","Item Name","Item Price","Count","Item Total"};

    private String[][] invoicesItemsData={
            {"No.1","Item Name1","Item Price1","Count1","Item Total1"},
            {"No.2","Item Name2","Item Price2","Count2","Item Total2"},
            {"No.3","Item Name3","Item Price3","Count3","Item Total3"}
    };


*/



    private JButton createItemBtn;
    private JButton deleteItemBtn;

    private ArrayList<Invoice> invoices;

    Controller controller =new Controller(this);


    //getters and setters
    public ArrayList<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(ArrayList<Invoice> invoices) {
        this.invoices = invoices;
    }


    private InvoicesTableModel invoicesTableModel;
    private ItemsTableModel itemsTableModel;

    public ItemsTableModel getItemsTableModel() {
        return itemsTableModel;
    }

    public void setItemsTableModel(ItemsTableModel itemsTableModel) {
        this.itemsTableModel = itemsTableModel;
    }

    public InvoicesTableModel getInvoicesTableModel() {
        return invoicesTableModel;
    }

    public void setInvoicesTableModel(InvoicesTableModel invoicesTableModel) {
        this.invoicesTableModel = invoicesTableModel;
    }

    public JTable getInvoiceItems() {
        return invoiceItems;
    }

    public JTable getInvoicesTable() {
        return invoicesTable;
    }
    public JMenuItem getLoadFileItem() {
        return loadFileItem;
    }

    public void setLoadFileItem(JMenuItem loadFileItem) {
        this.loadFileItem = loadFileItem;
    }

    public JMenuItem getSaveFileItem() {
        return saveFileItem;
    }

    public void setSaveFileItem(JMenuItem saveFileItem) {
        this.saveFileItem = saveFileItem;
    }

    public void setInvoicesTable(JTable invoicesTable) {
        this.invoicesTable = invoicesTable;
    }

    public JButton getCreateInvoiceBtn() {
        return createInvoiceBtn;
    }

    public void setCreateInvoiceBtn(JButton createInvoiceBtn) {
        this.createInvoiceBtn = createInvoiceBtn;
    }

    public JButton getDeleteInvoiceBtn() {
        return deleteInvoiceBtn;
    }

    public void setDeleteInvoiceBtn(JButton deleteInvoiceBtn) {
        this.deleteInvoiceBtn = deleteInvoiceBtn;
    }

    public JLabel getInvoiceNumberLbl() {
        return invoiceNumberLbl;
    }

    public void setInvoiceNumberLbl(JLabel invoiceNumberLbl) {
        this.invoiceNumberLbl = invoiceNumberLbl;
    }

    public JLabel getInvoiceNumberLbl2() {
        return invoiceNumberLbl2;
    }

    public void setInvoiceNumberLbl2(JLabel invoiceNumberLbl2) {
        this.invoiceNumberLbl2 = invoiceNumberLbl2;
    }

    public JLabel getInvoiceDateLbl() {
        return invoiceDateLbl;
    }

    public void setInvoiceDateLbl(JLabel invoiceDateLbl) {
        this.invoiceDateLbl = invoiceDateLbl;
    }

    public JTextField getInvoiceDateTf() {
        return invoiceDateTf;
    }

    public void setInvoiceDateTf(JTextField invoiceDateTf) {
        this.invoiceDateTf = invoiceDateTf;
    }

    public JLabel getCustomerNameLbl() {
        return customerNameLbl;
    }

    public void setCustomerNameLbl(JLabel customerNameLbl) {
        this.customerNameLbl = customerNameLbl;
    }

    public JTextField getCustomerNameTf() {
        return customerNameTf;
    }

    public void setCustomerNameTf(JTextField customerNameTf) {
        this.customerNameTf = customerNameTf;
    }

    public JLabel getInvoiceTotalLbl() {
        return invoiceTotalLbl;
    }

    public void setInvoiceTotalLbl(JLabel invoiceTotalLbl) {
        this.invoiceTotalLbl = invoiceTotalLbl;
    }

    public JLabel getInvoiceTotalLbl2() {
        return invoiceTotalLbl2;
    }

    public void setInvoiceTotalLbl2(JLabel invoiceTotalLbl2) {
        this.invoiceTotalLbl2 = invoiceTotalLbl2;
    }

    public JLabel getInvoiceItemsLbl() {
        return invoiceItemsLbl;
    }

    public void setInvoiceItemsLbl(JLabel invoiceItemsLbl) {
        this.invoiceItemsLbl = invoiceItemsLbl;
    }

    public void setInvoiceItems(JTable invoiceItems) {
        this.invoiceItems = invoiceItems;
    }



    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Layout()
    {
        //Set the main frame characteristics
        super("SIG");
        setSize(1100,700);
        setLocation(50,50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        //Create the Menu
        fileMenuBar =new JMenuBar();
        fileMenu =new JMenu("File");
        loadFileItem =new JMenuItem("Load File");
        loadFileItem.addActionListener(controller);
        loadFileItem.setActionCommand("loadFile");
        saveFileItem =new JMenuItem("Save File");
        saveFileItem.setActionCommand("saveFile");
        saveFileItem.addActionListener(controller);
        fileMenu.add(loadFileItem);
        fileMenu.add(saveFileItem);
        fileMenuBar.add(fileMenu);
        add("North",fileMenuBar);

        //Create the frame panels
        p1 =new JPanel();
        p2 =new JPanel();
        mainPanel =new JPanel();
        p1.setBounds(20,30,500,600);
        //p1.setBackground(Color.gray);
        p2.setBounds(530,30,500,600);
        // p2.setBackground(Color.PINK);
        mainPanel.setBounds(60,60,500,600);
        //mainPanel.setBackground(Color.red);


        //Handle the left panel attributes


         invoicesTable=new JTable();
         invoicesTableLbl =new JLabel("Invoices Table");
         //invoicesTable =new JTable();
        //invoicesTable.setModel(controller.csv_data);
        invoicesTable.getSelectionModel().addListSelectionListener(controller);

        p1.add(invoicesTableLbl);
        p1.add(new JScrollPane(invoicesTable));
        createInvoiceBtn =new JButton("Create New Invoice");
        deleteInvoiceBtn =new JButton("Delete Invoice");
        p1.add(createInvoiceBtn);
        createInvoiceBtn.addActionListener(controller);
        createInvoiceBtn.setActionCommand("createInvoice");

        p1.add(deleteInvoiceBtn);
        deleteInvoiceBtn.addActionListener(controller);
        deleteInvoiceBtn.setActionCommand("deleteInvoice");

       // invoicesTable.setModel();

        //Handle the right panel attributes
        invoiceNumberLbl =new JLabel("Invoice Number");
        invoiceNumberLbl.setPreferredSize(new Dimension(120,20));
        invoiceNumberLbl2 =new JLabel();
        invoiceNumberLbl2.setPreferredSize(new Dimension(300,20));
        invoiceDateLbl =new JLabel("Invoice Date");
        invoiceDateLbl.setPreferredSize(new Dimension(120,20));
        invoiceDateTf =new JTextField();
        invoiceDateTf.setPreferredSize(new Dimension(300,20));
        customerNameLbl =new JLabel("Customer Name");
        customerNameLbl.setPreferredSize(new Dimension(120,20));
        customerNameTf =new JTextField();
        customerNameTf.setPreferredSize(new Dimension(300,20));
        invoiceTotalLbl =new JLabel("Invoice Total");
        invoiceTotalLbl.setPreferredSize(new Dimension(120,20));
        invoiceTotalLbl2 =new JLabel();
        invoiceTotalLbl2.setPreferredSize(new Dimension(300,20));
        invoiceItemsLbl =new JLabel("Invoice Items");
        p2.add(invoiceNumberLbl);
        p2.add(invoiceNumberLbl2);
        p2.add(invoiceDateLbl);
        p2.add(invoiceDateTf);
        p2.add(customerNameLbl);
        p2.add(customerNameTf);
        p2.add(invoiceTotalLbl);
        p2.add(invoiceTotalLbl2);
        p2.add(invoiceItemsLbl);
        //invoiceItems=new JTable(invoicesItemsData,invoicesItemsHeader);
        invoiceItems=new JTable();
        invoiceItemsLbl =new JLabel("Invoices Table");


        p2.add(new JScrollPane(invoiceItems));
        createItemBtn =new JButton("Create Item");
        deleteItemBtn =new JButton("Delete Item");
        p2.add(createItemBtn);
        createItemBtn.addActionListener(controller);
        createItemBtn.setActionCommand("createItem");

        p2.add(deleteItemBtn);
        deleteItemBtn.addActionListener(controller);
        deleteItemBtn.setActionCommand("deleteItem");
        add("Center",p1);
        add("Center",p2);
        add("Center", mainPanel);



    }



    public static void main(String[] arg)
    {
        Layout l1 =new Layout();
        l1.setVisible(true);


    }
}
