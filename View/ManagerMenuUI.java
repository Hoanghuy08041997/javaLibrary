package View;

import Controller.MethodController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ManagerMenuUI extends JFrame {
    private JSplitPane splitPane;
    private JPanel functionPanel;
    private JPanel contentPanel;
    private JButton listBooksButton;
    private JButton listCustomersButton;
    private JButton searchBookButton;
    private JButton searchCustomerButton;
    private JButton addAccountButton;
    private JButton removeAccountButton;
    private JButton removeBookButton;
    private JButton exitButton;

    private final AccountManagementUI accountManagementUI; 
    public ManagerMenuUI() {
        setTitle("Manager Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000, 750));
        run();
        accountManagementUI = new AccountManagementUI();
    }

    private void initializeUI() {
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerSize(5);

        functionPanel = new JPanel();
        functionPanel.setLayout(new GridLayout(8, 1));
        splitPane.setLeftComponent(functionPanel);

        contentPanel = new JPanel(new GridBagLayout());

        // List books button
        listBooksButton = new JButton("1. List all books");
        listBooksButton.addActionListener((ActionEvent e) -> {
            System.out.println("Hello1");
        });
        functionPanel.add(listBooksButton);

        // List customers button
        listCustomersButton = new JButton("2. List all customers");
        listCustomersButton.addActionListener((ActionEvent e) -> {
            System.out.println("Hello2");
        });
        functionPanel.add(listCustomersButton);

        // Search book button
        searchBookButton = new JButton("3. Search book");
        searchBookButton.addActionListener((ActionEvent e) -> {

        });
        functionPanel.add(searchBookButton);

        // Search customer button
        searchCustomerButton = new JButton("4. Search customer");
        searchCustomerButton.addActionListener((ActionEvent e) -> {
            System.out.println("Hello4");
        });
        functionPanel.add(searchCustomerButton);

        // Add account button
        addAccountButton = new JButton("5. Add account");
        addAccountButton.addActionListener((ActionEvent e) -> {
            // Handle add account action
        });
        functionPanel.add(addAccountButton);

        // Remove account button
        removeAccountButton = new JButton("6. Remove account");
        removeAccountButton.addActionListener((ActionEvent e) -> {
            contentPanel.removeAll();
            contentPanel.add(accountManagementUI);
            contentPanel.revalidate();
            contentPanel.repaint();
        });
        functionPanel.add(removeAccountButton);

        // Remove book button
        removeBookButton = new JButton("7. Remove book");
        removeBookButton.addActionListener((ActionEvent e) -> {
            // Handle remove book action
        });
        functionPanel.add(removeBookButton);

        // Exit button
        exitButton = new JButton("8. Exit");
        exitButton.addActionListener((ActionEvent e) -> {
            MethodController.exit();
        });
        functionPanel.add(exitButton);

        splitPane.setRightComponent(new JScrollPane(contentPanel)); // Sử dụng JScrollPane để cuộn nếu nội dung quá lớn

        setContentPane(splitPane);
        setResizable(false);
    }

    public final void run() {
        initializeUI();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
