package models;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ItemsTableModel extends AbstractTableModel {
    private ArrayList<InvoiceItem> Items;


    public ItemsTableModel(ArrayList<InvoiceItem> Items) {
        this.Items = Items;
    }

    public ArrayList<InvoiceItem> getItems() {
        return Items;
    }


    @Override
    public int getRowCount() {
        return Items.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int column) {

        switch(column)
        {
            case 0:
                return "NO.";

            case 1:
                return "Item Name";

            case 2:
                return "Item Price";

            case 3:
                return "Count";

            case 4:
                return "Item Total";

            default: return "";

        }

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceItem Item = Items.get(rowIndex);

        switch(columnIndex) {

            case 0: return Item.getItemNo();
            case 1: return Item.getItemName();
            case 2: return Item.getItemPrice();
            case 3: return Item.getItemCount();
            case 4: return Item.getItemTotal();
            default : return "";
        }
    }
}
