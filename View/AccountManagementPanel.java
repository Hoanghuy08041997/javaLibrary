package View;

import Controller.ManagementLibrary;
import Controller.MethodController;
import Model.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class AccountManagementPanel extends JPanel {
    private final JButton removeAccountButton;
    private JTextField searchField;
    private JComboBox<String> searchProperties;
    private JList<String> accountList;

    public AccountManagementPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        // Search properties
        String[] options = {"name", "email", "phone"};

        searchProperties = new JComboBox<>(options);
        searchProperties.setPreferredSize(new Dimension(75, 25));
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(searchProperties, constraints);

        // Search field
        searchField = new JTextField(10);
        constraints.gridx = 1;
        constraints.gridy = 0;
        add(searchField, constraints);

        // Search button
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener((ActionEvent e) -> {
            String searchCriteria = searchField.getText();
            String selectedProperty = (String) searchProperties.getSelectedItem();
            List<String> searchResults = performSearch(selectedProperty, searchCriteria);
            updateAccountList(searchResults);
        });
        constraints.gridx = 2;
        add(searchButton, constraints);

        // Account list
        accountList = new JList<>();
        JScrollPane scrollPane = new JScrollPane(accountList);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.BOTH;
        add(scrollPane, constraints);

        // Remove account button
        removeAccountButton = new JButton("Remove account");
        removeAccountButton.addActionListener((ActionEvent e) -> {
            int selectedIndex = accountList.getSelectedIndex();
            if (selectedIndex != -1) {
                String selectedAccountString = accountList.getSelectedValue();
                int selectedAccountId = 0;
                for (Account acc : ManagementLibrary.account){
                    if (acc.toString().equals(selectedAccountString))
                        selectedAccountId = acc.getId();
                }
                removeAccount(selectedAccountId);
            }
        });
        removeAccountButton.setPreferredSize(new Dimension(200, 50));
        constraints.gridy = 2;
        add(removeAccountButton, constraints);
        
    }

    // Method to perform search based on given criteria //Done
    private List<String> performSearch(String searchCriteria, String s) {
        List<Integer> matchingAccounts = MethodController.searchAccount(searchCriteria, s);
        List<String> searchResults = new ArrayList<>();

        for (Integer accountId : matchingAccounts) {
            for (Account account : ManagementLibrary.account) {
                if (account.getId() == accountId) {
                    searchResults.add(account.toString());
                    break;
                }
            }
        }

        return searchResults;
    }

    // Method to update the account list with search results
    private void updateAccountList(List<String> searchResults) {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String account : searchResults) {
            listModel.addElement(account);
        }
        accountList.setModel(listModel);
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
                if ( ManagementLibrary.account.get(i).getId() == idCustomer) {
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
