package view;

import javax.swing.*;
import java.awt.*;

public class ItemDialog extends JDialog {

    private JLabel itemNameLbl;
    private JLabel itemPriceLbl;
    private JLabel itemCountLbl;
    private JTextField itemNameTf;
    private JTextField itemPriceTf;
    private JTextField itemCountTf;
    private JButton okBtn;
    private JButton cancelBtn;

    public ItemDialog(Layout layout) {
        setSize(500,200);
        setLayout(new GridLayout(4, 2));
        setLocation(500,300);
        itemNameTf = new JTextField();
        itemNameLbl = new JLabel("Item Name");

        itemPriceTf = new JTextField();
        itemPriceLbl = new JLabel("Item Price");

        itemCountTf = new JTextField();
        itemCountLbl = new JLabel("Item Count");

        okBtn = new JButton("OK");
        cancelBtn = new JButton("Cancel");

        okBtn.setActionCommand("createItemOK");
        cancelBtn.setActionCommand("createItemCancel");

        okBtn.addActionListener(layout.getController());
        cancelBtn.addActionListener(layout.getController());


        add(itemNameLbl);
        add(itemNameTf);

        add(itemPriceLbl);
        add(itemPriceTf);
        add(itemCountLbl);
        add(itemCountTf);
        add(okBtn);
        add(cancelBtn);


    }

    public JLabel getItemNameLbl() {
        return itemNameLbl;
    }

    public void setItemNameLbl(JLabel itemNameLbl) {
        this.itemNameLbl = itemNameLbl;
    }

    public JLabel getItemPriceLbl() {
        return itemPriceLbl;
    }

    public void setItemPriceLbl(JLabel itemPriceLbl) {
        this.itemPriceLbl = itemPriceLbl;
    }

    public JLabel getItemCountLbl() {
        return itemCountLbl;
    }

    public void setItemCountLbl(JLabel itemCountLbl) {
        this.itemCountLbl = itemCountLbl;
    }

    public JTextField getItemNameTf() {
        return itemNameTf;
    }

    public void setItemNameTf(JTextField itemNameTf) {
        this.itemNameTf = itemNameTf;
    }

    public JTextField getItemPriceTf() {
        return itemPriceTf;
    }

    public void setItemPriceTf(JTextField itemPriceTf) {
        this.itemPriceTf = itemPriceTf;
    }

    public JTextField getItemCountTf() {
        return itemCountTf;
    }

    public void setItemCountTf(JTextField itemCountTf) {
        this.itemCountTf = itemCountTf;
    }

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
