package View;

import Controller.ManagementLibrary;
import Controller.MethodController;
import Model.Customer;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class SearchCustomerUI extends JPanel {
    private final JButton removeAccountButton;
    private final JButton lendBookButton; // New button
    private final JButton returnBookButton; // New button
    private JTextField searchField;
    private JComboBox<String> searchProperties;
    private final JTable accountTable;

    public SearchCustomerUI() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        // Search properties
        String[] options = {"name", "email", "phone"};

        searchProperties = new JComboBox<>(options);
        searchProperties.setPreferredSize(new Dimension(100, 25));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.insets = new Insets(5, 5, 5, 5);
        add(searchProperties, constraints);

        // Search field
        searchField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 1.1;
        constraints.insets = new Insets(5, 5, 5, 5);
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
        constraints.gridy = 0;
        constraints.weightx = 0.0;
        constraints.insets = new Insets(5, 5, 5, 5);
        add(searchButton, constraints);

        // Account table
        accountTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(accountTable);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 3;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(5, 5, 5, 5);
        add(scrollPane, constraints);

        // Calculate button size based on table size
        int buttonWidth = scrollPane.getPreferredSize().width / 3;
        int buttonHeight = 30;

        // Lend book button
        lendBookButton = new JButton("Lend Book");
        lendBookButton.addActionListener((ActionEvent e) -> {
            int selectedRow = accountTable.getSelectedRow();
            if (selectedRow != -1) {
                int accountId = (int) accountTable.getValueAt(selectedRow, 0);
                lendBook(accountId);
            }
        });
        lendBookButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.weightx = 1.0;
        constraints.weighty = 0.1;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(5, 5, 5, 5);
        add(lendBookButton, constraints);

        // Return book button
        returnBookButton = new JButton("Return Book");
        returnBookButton.addActionListener((ActionEvent e) -> {
            int selectedRow = accountTable.getSelectedRow();
            if (selectedRow != -1) {
                int accountId = (int) accountTable.getValueAt(selectedRow, 0);
                returnBook(accountId);
            }
        });
        returnBookButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.weightx = 1.0;
        constraints.weighty = 0.1;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(5, 5, 5, 5);
        add(returnBookButton, constraints);

        // Remove account button
        removeAccountButton = new JButton("Remove Account");
        removeAccountButton.addActionListener((ActionEvent e) -> {
            int selectedRow = accountTable.getSelectedRow();
            if (selectedRow != -1) {
                int accountId = (int) accountTable.getValueAt(selectedRow, 0);
                removeAccount(accountId);
            }
        });
        removeAccountButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.weightx = 1.0;
        constraints.weighty = 0.1;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(5, 5, 5, 5);
        add(removeAccountButton, constraints);

        // Set frame size
        Dimension size = new Dimension(800, 650);
        setPreferredSize(size);
        setSize(size);
    }

    // Method to perform search based on given criteria
    private List<Integer> performSearch(String searchCriteria, String s) {
        List<Integer> matchingAccounts = MethodController.searchAccount(searchCriteria, s);
        return matchingAccounts;
    }

    // Method to update the account list with search results as a table
    private void updateAccountList(List<Integer> searchResults) {
        String[] columnNames = {"ID", "Username", "Email", "Phone", "Birthday", "Level"};
        Object[][] data = new Object[searchResults.size()][6];

        for (int i = 0; i < searchResults.size(); i++) {
            int accountId = searchResults.get(i);

            for (Customer customer : ManagementLibrary.customer) {
                if (customer != null && customer.getId() == accountId) {
                    data[i][0] = customer.getId(); // ID
                    data[i][1] = customer.getName().trim(); // Name
                    data[i][2] = customer.getEmail(); // Email
                    data[i][3] = customer.getPhone(); // Phone
                    data[i][4] = customer.getBirthday(); // Birthday
                    data[i][5] = customer.getLevelUser(); // Level
                    break;
                }
            }
        }

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        accountTable.setModel(tableModel);
    }

    // Method to remove selected account
    private void removeAccount(int idCustomer) {
        // Display confirmation dialog
        int confirmed = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to remove the account?",
                "Confirm Remove",
                JOptionPane.YES_NO_OPTION
        );

        if (confirmed == JOptionPane.YES_OPTION) {
            boolean foundAndDeleted = false;

            for (int i = 0; i < ManagementLibrary.account.size(); i++) {
                if (ManagementLibrary.account.get(i).getId() == idCustomer) {
                    if (ManagementLibrary.account.get(i).getLevel() > ManagementLibrary.logged.get(0).getLevelUser()) {
                        JOptionPane.showMessageDialog(null, "You cannot remove an account that has a higher level or higher.");
                        foundAndDeleted = true;
                        break;
                    } else if (ManagementLibrary.account.get(i).getLevel() == ManagementLibrary.logged.get(0).getLevelUser()) {
                        JOptionPane.showMessageDialog(null, "You cannot remove an account that has the same level or higher.");
                        foundAndDeleted = true;
                        break;
                    } else {
                        ManagementLibrary.account.remove(i);
                        break;
                    }
                }
            }

            if (!foundAndDeleted) {
                // Find and check customer in ManagementLibrary.customer
                for (int i = 0; i < ManagementLibrary.customer.size(); i++) {
                    if (ManagementLibrary.customer.get(i).getId() == idCustomer
                            && ManagementLibrary.customer.get(i).getLevelUser() < ManagementLibrary.logged.get(0).getLevelUser()) {
                        ManagementLibrary.customer.remove(i);
                        break;
                    }
                }
            }
        }
    }

    // Method to lend book for selected account
    private void lendBook(int idCustomer) {
        JPanel searchPanel = SearchBookUI.createPanel(idCustomer);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(searchPanel);
        frame.pack();
        frame.setVisible(true); 
    }
    
    // Method to return book for selected account
    private void returnBook(int idCustomer) {
        JPanel searchPanel = SearchBookUI.createPanel(idCustomer);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(searchPanel);
        frame.pack();
        frame.setVisible(true); 
    }
    
}
