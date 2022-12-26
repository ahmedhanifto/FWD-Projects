package view;

import javax.swing.*;
import java.awt.*;

public class InvoiceDialog extends JDialog {
    private JTextField customerNameTf;
   // private JTextField dateTf;
    private JLabel customerNameLbl;
   // private JLabel dateLbl;
    private JButton okBtn;
    private JButton cancelBtn;


    public InvoiceDialog(Layout layout) {

        setSize(300,200);
        setLayout(new GridLayout(3, 2));
        setLocation(500,300);
        customerNameLbl = new JLabel("Customer Name:");

        customerNameTf = new JTextField();

        //dateLbl = new JLabel("Invoice Date:");

        //dateTf = new JTextField();

        okBtn = new JButton("OK");
        cancelBtn = new JButton("Cancel");

        okBtn.setActionCommand("createInvoiceOK");
        cancelBtn.setActionCommand("createInvoiceCancel");

        okBtn.addActionListener(layout.getController());
        cancelBtn.addActionListener(layout.getController());



        add(customerNameLbl);
        add(customerNameTf);
        //add(dateLbl);
        //add(dateTf);
        add(okBtn);
        add(cancelBtn);



    }

    public JTextField getCustomerNameTf() {
        return customerNameTf;
    }

    public void setCustomerNameTf(JTextField customerNameTf) {
        this.customerNameTf = customerNameTf;
    }

    /*
    public JTextField getDateTf() {
        return dateTf;
    }

    public void setDateTf(JTextField dateTf) {
        this.dateTf = dateTf;
    }
    */
    public JLabel getCustomerNameLbl() {
        return customerNameLbl;
    }

    public void setCustomerNameLbl(JLabel customerNameLbl) {
        this.customerNameLbl = customerNameLbl;
    }
    /*
    public JLabel getDateLbl() {
        return dateLbl;
    }

    public void setDateLbl(JLabel dateLbl) {
        this.dateLbl = dateLbl;
    }
    */
    public JButton getOkBtn() {
        return okBtn;
    }

    public void setOkBtn(JButton okBtn) {
        this.okBtn = okBtn;
    }

    public JButton getCancelBtn() {
        return cancelBtn;
    }

    public void setCancelBtn(JButton cancelBtn) {
        this.cancelBtn = cancelBtn;
    }
}



