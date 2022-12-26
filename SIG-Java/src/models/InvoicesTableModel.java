package models;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class InvoicesTableModel extends AbstractTableModel {
    private ArrayList<Invoice> invoices;


    public InvoicesTableModel(ArrayList<Invoice> invoices) {
        this.invoices = invoices;
    }

    @Override
    public int getRowCount() {
        return invoices.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        switch(column)
        {
            case 0:
                return "NO.";

            case 1:
                return "Date";

            case 2:
                return "Customer";

            case 3:
                return "Total";

            default: return "";

        }


    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Invoice invoice = invoices.get(rowIndex);

        switch (columnIndex) {
            case 0: return invoice.getInvoiceNumber();
            case 1: return invoice.getInvoiceDate();
            case 2: return invoice.getCustomerName();
            case 3: return invoice.getInvoiceTotal();
            default : return "";
        }
    }

}
