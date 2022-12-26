package controller;

import models.Invoice;
import models.InvoiceItem;
import models.InvoicesTableModel;
import models.ItemsTableModel;
import view.InvoiceDialog;
import view.ItemDialog;
import view.Layout;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;

public class Controller  implements ActionListener, ListSelectionListener {

     Layout layout ;
     InvoiceDialog invoiceDialog;
     ItemDialog itemDialog;
    //public DefaultTableModel csv_data =new DefaultTableModel();

    public Controller(Layout layout)
    {
        this.layout=layout;


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println(e.getActionCommand());
        switch (e.getActionCommand()) {
            case "loadFile":
                loadFile();
                break;
            case "saveFile":
                saveFile();
                break;
            case "createInvoice":
                createNewInvoice();
                break;
            case "deleteInvoice":
                deleteInvoice();
                break;
            case "createItem":
                createItem();
                break;
            case "deleteItem":
                deleteItem();
                break;
            case "createInvoiceOK":
                createInvoiceOk();
                break;
            case "createInvoiceCancel":
                createInvoiceCancel();
                break;
            case "createItemOK":
                createItemOk();
                break;
            case "createItemCancel":
                createItemCancel();
                break;


        }

    }




    @Override
    public void valueChanged(ListSelectionEvent e) {


        if (layout.getInvoicesTable().getSelectedRow() != -1) {
            Invoice currentInvoice = layout.getInvoices().get(layout.getInvoicesTable().getSelectedRow());
            layout.getInvoiceNumberLbl2().setText(String.valueOf(currentInvoice.getInvoiceNumber()));
            layout.getInvoiceDateTf().setText(currentInvoice.getInvoiceDate());
            layout.getCustomerNameTf().setText(currentInvoice.getCustomerName());
            layout.getInvoiceTotalLbl2().setText(String.valueOf(currentInvoice.getInvoiceTotal()));
            ItemsTableModel itemsTableModel = new ItemsTableModel(currentInvoice.getItems());
            layout.getInvoiceItems().setModel(itemsTableModel);

        }


    }


    public void loadFile()
    {
        ArrayList<Invoice> allInvoices =new ArrayList<>();
        JFileChooser fc = new JFileChooser();

        try{


            if(fc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {


                File invoicesFile = fc.getSelectedFile();
                Path invoicespath = Paths.get(invoicesFile.getAbsolutePath());


                ArrayList<String> invoices= (ArrayList<String>) Files.readAllLines(invoicespath);
                for(int i=0;i<invoices.size();i++)
                {

                    String[] invoiceData =invoices.get(i).split(",");
                    Invoice invoiceSelected = new Invoice();
                    invoiceSelected.setInvoiceNumber(Integer.parseInt(invoiceData[0]));
                    invoiceSelected.setInvoiceDate(invoiceData[1]);
                    invoiceSelected.setCustomerName(invoiceData[2]);
                    allInvoices.add(invoiceSelected);

                }
                JFileChooser fc2 =new JFileChooser();
                if (fc2.showOpenDialog(null)== JFileChooser.APPROVE_OPTION) {
                    File itemFile = fc2.getSelectedFile();
                    Path itemPath = Paths.get(itemFile.getAbsolutePath());

                    ArrayList<String> items=(ArrayList<String>) Files.readAllLines(itemPath);
                    for(int i=0;i<items.size();i++)
                    {


                            String[] itemData = items.get(i).split(",");



                            InvoiceItem item = new InvoiceItem();
                            item.setItemNo(Integer.parseInt(itemData[0]));
                            item.setItemName(itemData[1]);
                            item.setItemPrice(Double.parseDouble(itemData[2]));
                            item.setItemCount(Integer.parseInt(itemData[3]));


                        for (Invoice invoice : allInvoices) {
                            if (invoice.getInvoiceNumber() == Integer.parseInt(itemData[0])) {
                                item.setInvoice(invoice);
                                invoice.getItems().add(item);
                                break;
                            }
                        }




                    }
                }

                layout.setInvoices(allInvoices);
                InvoicesTableModel invoicesTableModel = new InvoicesTableModel(allInvoices);
                layout.setInvoicesTableModel(invoicesTableModel);
                layout.getInvoicesTable().setModel(invoicesTableModel);
                layout.getInvoicesTableModel().fireTableDataChanged();

                }



        }catch(Exception e)
        {
            e.printStackTrace();

        }




    }
    public void saveFile()
    {
        ArrayList<Invoice> allInvoices = layout.getInvoices();
        String csvFile = "";
        String items = "";
        for(int i=0;i<allInvoices.size();i++)
        {
            String invoiceToCSVFormat = allInvoices.get(i).getInvoiceNumber()+","+allInvoices.get(i).getInvoiceDate()+","+allInvoices.get(i).getCustomerName()+"\n";
            csvFile += invoiceToCSVFormat;


            for(int j=0;j<allInvoices.get(i).getItems().size();j++) {
                String itemToCSVFormat = allInvoices.get(i).getItems().get(j).getItemNo()+","+allInvoices.get(i).getItems().get(j).getItemName()+","+allInvoices.get(i).getItems().get(j).getItemPrice()+","+allInvoices.get(i).getItems().get(j).getItemCount()+"\n";
                items += itemToCSVFormat;

            }
        }

        try {
            JFileChooser fc = new JFileChooser();
            int choice = fc.showSaveDialog(layout);

            if (choice == JFileChooser.APPROVE_OPTION) {
                File invoicesFile = fc.getSelectedFile();
                FileWriter inv = new FileWriter(invoicesFile);
                inv.write(csvFile);
                inv.flush();
                inv.close();
                JFileChooser fc2 = new JFileChooser();
                int choice2 = fc2.showSaveDialog(layout);
                if (choice2 == JFileChooser.APPROVE_OPTION) {
                    File lineFile = fc2.getSelectedFile();
                    FileWriter itemsF = new FileWriter(lineFile);
                    itemsF.write(items);
                    itemsF.flush();
                    itemsF.close();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
    public void createNewInvoice()
    {

        invoiceDialog = new InvoiceDialog(layout);
        invoiceDialog.setVisible(true);




    }
    public void createItem()
    {

        itemDialog =new ItemDialog(layout);
        itemDialog.setVisible(true);



    }
    public void createInvoiceOk() {



        int invoiceNumber =(layout.getInvoices().size())+1;
        Date currentDate =new Date();
        String date=currentDate.toString();
        //String date = invoiceDialog.getDateTf().getText();
        String customerName = invoiceDialog.getCustomerNameTf().getText();


                    Invoice invoice = new Invoice();
                    invoice.setInvoiceNumber(invoiceNumber);
                    invoice.setInvoiceDate(date);
                    invoice.setCustomerName(customerName);
                    layout.getInvoices().add(invoice);
                    layout.getInvoicesTableModel().fireTableDataChanged();

                    invoiceDialog.dispose();


    }
    public void createInvoiceCancel() {
        invoiceDialog.dispose();
    }
    public void createItemOk() {
        String itemName = itemDialog.getItemNameTf().getText();
        int count = Integer.parseInt(itemDialog.getItemCountTf().getText());
        double price = Double.parseDouble(itemDialog.getItemPriceTf().getText());


        int selectedInvoice = layout.getInvoicesTable().getSelectedRow();
        if (selectedInvoice != -1) {
            Invoice invoice = layout.getInvoices().get(selectedInvoice);
            InvoiceItem item = new InvoiceItem();
            item.setItemNo(invoice.getInvoiceNumber());
            item.setItemName(itemName);
            item.setItemPrice(price);
            item.setItemCount(count);
            item.setInvoice(invoice);
            invoice.getItems().add(item);
            ItemsTableModel itemsTableModel = (ItemsTableModel)layout.getInvoiceItems().getModel();
            itemsTableModel.fireTableDataChanged();
            layout.getInvoicesTableModel().fireTableDataChanged();

        }


        itemDialog.dispose();

    }
    public void createItemCancel()
    {
        itemDialog.dispose();

    }
    public void deleteInvoice()
    {
        int selectedInvoice = layout.getInvoicesTable().getSelectedRow();
        if (selectedInvoice != -1) {
            //remove the invoice from invoices table
            layout.getInvoices().remove(selectedInvoice);

            //remove the invoice items from invoice items table
            ItemsTableModel itemsTableModel=(ItemsTableModel)layout.getInvoiceItems().getModel();
            itemsTableModel.getItems().clear();

            layout.getInvoicesTableModel().fireTableDataChanged();
            itemsTableModel.fireTableDataChanged();

        }
    }

    public void deleteItem()
    {

        int selectedItem =layout.getInvoiceItems().getSelectedRow();
        if (selectedItem != -1) {

            ItemsTableModel itemsTableModel=(ItemsTableModel)layout.getInvoiceItems().getModel();
            itemsTableModel.getItems().remove(selectedItem);
            itemsTableModel.fireTableDataChanged();
            layout.getInvoicesTableModel().fireTableDataChanged();


        }



    }




}
