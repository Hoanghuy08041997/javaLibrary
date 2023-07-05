package View;

import Model.Book;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BookListUI extends JPanel {
    public BookListUI(ArrayList<Book> books) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        String[] columnNames = {"ID", "Name", "Author", "Total Book", "Price"};
        
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        
        for (Book book : books) {
            Object[] rowData = {book.getId(), book.getName(), book.getAuthor(),
                                book.getNumber(), book.getPrice()};
            tableModel.addRow(rowData);
        }
        
        // Tạo JTable với DefaultTableModel
        JTable table = new JTable(tableModel);
        
        // Đặt kích thước ưu tiên cho các cột
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(100);  // ID
        table.getColumnModel().getColumn(1).setPreferredWidth(250); // Name
        table.getColumnModel().getColumn(2).setPreferredWidth(200); // Author
        table.getColumnModel().getColumn(3).setPreferredWidth(120); // Total Book
        table.getColumnModel().getColumn(4).setPreferredWidth(80);  // Price

        
        JScrollPane scrollPane = new JScrollPane(table);
        
        scrollPane.setPreferredSize(new Dimension(800, 550));
        
        add(scrollPane);
    }
}