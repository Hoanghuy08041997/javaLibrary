package View;

import Model.BookBorrow;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BookBorrowListUI extends JPanel {
    public BookBorrowListUI(ArrayList<BookBorrow> books) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        String[] columnNames = {"ID", "Name", "Author", "Type" ,"Price","Date lend","Status return" };
        
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        
        for (BookBorrow bb : books) {
            Object[] rowData = {bb.getId(), bb.getName(), bb.getAuthor(),bb.getType(),
                                 bb.getPrice(),bb.getDateBorrow(),bb.getStatus()};
            tableModel.addRow(rowData);
        }
        
        // Tạo JTable với DefaultTableModel
        JTable table = new JTable(tableModel);
        
        // Đặt kích thước ưu tiên cho các cột
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(100);  // ID
        table.getColumnModel().getColumn(1).setPreferredWidth(200); // Name
        table.getColumnModel().getColumn(2).setPreferredWidth(100); // Author
        table.getColumnModel().getColumn(3).setPreferredWidth(80); //Type
        table.getColumnModel().getColumn(4).setPreferredWidth(120); // Price 
        table.getColumnModel().getColumn(5).setPreferredWidth(80); //Date lend
        table.getColumnModel().getColumn(6).setPreferredWidth(80); //Status return

        
        JScrollPane scrollPane = new JScrollPane(table);
        
        scrollPane.setPreferredSize(new Dimension(800, 550));
        
        add(scrollPane);
    }
}