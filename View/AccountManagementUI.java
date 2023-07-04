package View;

import Controller.ManagementLibrary;
import Controller.MethodController;
import Model.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class AccountManagementUI extends JPanel {
    private final JButton removeAccountButton;
    private JTextField searchField;
    private JComboBox<String> searchProperties;
    private final JTable accountTable;

    public AccountManagementUI() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        // Search properties
        String[] options = {"name", "email", "phone"};

        searchProperties = new JComboBox<>(options);
        searchProperties.setPreferredSize(new Dimension(100, 25));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0.1;
        add(searchProperties, constraints);

        // Search field
        searchField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 0.8; 
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(searchField, constraints);

        // Search button
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener((ActionEvent e) -> {
            String searchCriteria = searchField.getText();
            String selectedProperty = (String) searchProperties.getSelectedItem();
            List<Integer> searchResults = performSearch(selectedProperty, searchCriteria);
            updateAccountList(searchResults);
        });
        constraints.gridx = 2;
        constraints.weightx = 0.1;
        add(searchButton, constraints);

         // Account table
        accountTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(accountTable);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 3;
        constraints.weighty = 0.8;
        constraints.fill = GridBagConstraints.BOTH;
        add(scrollPane, constraints);

        // Remove account button
        removeAccountButton = new JButton("Remove account");
        removeAccountButton.addActionListener((ActionEvent e) -> {
            int selectedRow = accountTable.getSelectedRow();
            if (selectedRow != -1) {
                int accountId = (int) accountTable.getValueAt(selectedRow, 3);
                removeAccount(accountId);
            }
        });
        removeAccountButton.setPreferredSize(new Dimension(100, 30));
        constraints.gridy = 2;
        constraints.weighty = 0.1;
        constraints.insets = new Insets(0, 0, 0, 0); 
        add(removeAccountButton, constraints);

        // Set frame size
        Dimension size = new Dimension(800, 650);
        setPreferredSize(size);
        setSize(size);
    }

    // Method to perform search based on given criteria //Done
    private List<Integer> performSearch(String searchCriteria, String s) {
        List<Integer> matchingAccounts = MethodController.searchAccount(searchCriteria, s);
        return matchingAccounts;
    }

    // Method to update the account list with search results as a table
    private void updateAccountList(List<Integer> searchResults) {
        String[] columnNames = {"Username", "Password", "Level", "Id"};
        Object[][] data = new Object[searchResults.size()][4];

        for (int i = 0; i < searchResults.size(); i++) {
            int accountId = searchResults.get(i);

            for (Account account : ManagementLibrary.account) {
                if (account != null && account.getId() == accountId) {
                    data[i][0] = account.getUsername().trim(); // Username
                    data[i][1] = account.getPassword().trim(); // Password
                    data[i][2] = account.getLevel(); // Level
                    data[i][3] = account.getId(); // Id
                    break;
                }
            }
        }

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        accountTable.setModel(tableModel);
    }

    // Method to remove selected account
    private void removeAccount(int idCustomer) {
        // Hiển thị hộp thoại xác nhận
        int confirmed = JOptionPane.showConfirmDialog(
                this,
                "Bạn có chắc muốn xóa tài khoản?",
                "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION
        );

        // Kiểm tra xác nhận từ người dùng
        if (confirmed == JOptionPane.YES_OPTION) {
            // Tìm và xóa tài khoản trong ManagementLibrary.account
            for (int i = 0; i < ManagementLibrary.account.size(); i++) {
                if (ManagementLibrary.account.get(i).getId() == idCustomer) {
                    ManagementLibrary.account.remove(i);
                    break;
                }
            }

            // Tìm và xóa tài khoản trong ManagementLibrary.customer
            for (int i = 0; i < ManagementLibrary.customer.size(); i++) {
                if (ManagementLibrary.customer.get(i).getId() == idCustomer) {
                    ManagementLibrary.customer.remove(i);
                    break;
                }
            }
        }
    }
}
