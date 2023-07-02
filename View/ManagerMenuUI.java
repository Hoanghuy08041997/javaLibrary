package View;

import Controller.MethodController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public final class ManagerMenuUI extends JFrame {
    private JPanel mainPanel;
    private JLabel titleLabel;
    private JButton listBooksButton;
    private JButton listCustomersButton;
    private JButton searchBookButton;
    private JButton searchCustomerButton;
    private JButton addAccountButton;
    private JButton removeAccountButton;
    private JButton removeBookButton;
    private JButton exitButton;

    public ManagerMenuUI() {
        setTitle("Manager Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(600, 450));
        run();
    }

    private void initializeUI() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        mainPanel.setBackground(Color.WHITE);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 20, 10, 20);

        titleLabel = new JLabel("Manage Book", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLUE);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        mainPanel.add(titleLabel, constraints);

        listBooksButton = new JButton("List all books");
        listBooksButton.addActionListener((ActionEvent e) -> {
            System.out.println("Hello1");
        });
        listBooksButton.setPreferredSize(new Dimension(200, 50));
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        mainPanel.add(listBooksButton, constraints);

        listCustomersButton = new JButton("List all customers");
        listCustomersButton.addActionListener((ActionEvent e) -> {
            System.out.println("Hello2");
        });
        listCustomersButton.setPreferredSize(new Dimension(200, 50));
        constraints.gridx = 1;
        mainPanel.add(listCustomersButton, constraints);

        searchBookButton = new JButton("Search book");
        searchBookButton.addActionListener((ActionEvent e) -> {
            System.out.println("Hello3");
        });
        searchBookButton.setPreferredSize(new Dimension(200, 50));
        constraints.gridx = 0;
        constraints.gridy = 2;
        mainPanel.add(searchBookButton, constraints);

        searchCustomerButton = new JButton("Search customer");
        searchCustomerButton.addActionListener((ActionEvent e) -> {
            System.out.println("Hello4");
        });
        searchCustomerButton.setPreferredSize(new Dimension(200, 50));
        constraints.gridx = 1;
        mainPanel.add(searchCustomerButton, constraints);

        addAccountButton = new JButton("Add account");
        addAccountButton.addActionListener((ActionEvent e) -> {
            // Handle add account action
        });
        addAccountButton.setPreferredSize(new Dimension(200, 50));
        constraints.gridx = 0;
        constraints.gridy = 3;
        mainPanel.add(addAccountButton, constraints);

        removeAccountButton = new JButton("Remove account");
        removeAccountButton.addActionListener((ActionEvent e) -> {
            // Handle remove account action
        });
        removeAccountButton.setPreferredSize(new Dimension(200, 50));
        constraints.gridx = 1;
        mainPanel.add(removeAccountButton, constraints);

        removeBookButton = new JButton("Remove book");
        removeBookButton.addActionListener((ActionEvent e) -> {
            // Handle remove book action
        });
        removeBookButton.setPreferredSize(new Dimension(200, 50));
        constraints.gridx = 0;
        constraints.gridy = 4;
        mainPanel.add(removeBookButton, constraints);

        exitButton = new JButton("Exit");
        exitButton.addActionListener((ActionEvent e) -> {
            MethodController.exit();
        });
        exitButton.setPreferredSize(new Dimension(200, 50));
        constraints.gridx = 1;
        constraints.gridy = 4; // Update the gridy value to match the position of removeBookButton
        mainPanel.add(exitButton, constraints);

        setContentPane(mainPanel);
    }
    
    public void run() {
        initializeUI();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}
