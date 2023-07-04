package View;

import Model.Customer;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CustomerListUI extends JPanel {
    public CustomerListUI(ArrayList<Customer> customers) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        String[] columnNames = {"ID", "Name", "Email", "Phone", "Birthday", "Level"};
        
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        
        for (Customer customer : customers) {
            Object[] rowData = {customer.getId(), customer.getName(), customer.getEmail(),
                                customer.getPhone(), customer.getBirthday(), customer.getLevelUser()};
            tableModel.addRow(rowData);
        }
        
        // Tạo JTable với DefaultTableModel
        JTable table = new JTable(tableModel);
        
        // Đặt kích thước ưu tiên cho các cột
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(100);  // ID
        table.getColumnModel().getColumn(1).setPreferredWidth(200); // Name
        table.getColumnModel().getColumn(2).setPreferredWidth(250); // Email
        table.getColumnModel().getColumn(3).setPreferredWidth(100); // Phone
        table.getColumnModel().getColumn(4).setPreferredWidth(80);  // Birthday
        table.getColumnModel().getColumn(5).setPreferredWidth(65);  // Level
        
        JScrollPane scrollPane = new JScrollPane(table);
        
        scrollPane.setPreferredSize(new Dimension(800, 550));
        
        add(scrollPane);
    }
}

