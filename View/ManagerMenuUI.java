package View;

import Controller.MethodController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public final class ManagerMenuUI extends JFrame {
    private JPanel mainPanel;
    private JLabel titleLabel;
    private JLabel note;
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

        // Title label
        titleLabel = new JLabel("Manage Library", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLUE);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        mainPanel.add(titleLabel, constraints);

        // Note label
        note = new JLabel("(Version for Manager)", SwingConstants.CENTER);
        note.setFont(new Font("Arial", Font.BOLD, 12));
        note.setForeground(Color.RED);
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        mainPanel.add(note, constraints);

        // List books button
        listBooksButton = new JButton("1. List all books");
        listBooksButton.addActionListener((ActionEvent e) -> {
            System.out.println("Hello1");
        });
        listBooksButton.setPreferredSize(new Dimension(200, 50));
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        mainPanel.add(listBooksButton, constraints);

        // List customers button
        listCustomersButton = new JButton("2. List all customers");
        listCustomersButton.addActionListener((ActionEvent e) -> {
            System.out.println("Hello2");
        });
        listCustomersButton.setPreferredSize(new Dimension(200, 50));
        constraints.gridx = 1;
        mainPanel.add(listCustomersButton, constraints);

        // Search book button
        searchBookButton = new JButton("3. Search book");
        searchBookButton.addActionListener((ActionEvent e) -> {

        });
        searchBookButton.setPreferredSize(new Dimension(200, 50));
        constraints.gridx = 0;
        constraints.gridy = 3;
        mainPanel.add(searchBookButton, constraints);

        // Search customer button
        searchCustomerButton = new JButton("4. Search customer");
        searchCustomerButton.addActionListener((ActionEvent e) -> {
            System.out.println("Hello4");
        });
        searchCustomerButton.setPreferredSize(new Dimension(200, 50));
        constraints.gridx = 1;
        mainPanel.add(searchCustomerButton, constraints);

        // Add account button
        addAccountButton = new JButton("5. Add account");
        addAccountButton.addActionListener((ActionEvent e) -> {
            // Handle add account action
        });
        addAccountButton.setPreferredSize(new Dimension(200, 50));
        constraints.gridx = 0;
        constraints.gridy = 4;
        mainPanel.add(addAccountButton, constraints);

        // Remove account button
        removeAccountButton = new JButton("6. Remove account");
        removeAccountButton.addActionListener((ActionEvent e) -> {
        SwingUtilities.invokeLater(() -> {
                JFrame frame = new JFrame();

                frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

                AccountManagementUI panel = new AccountManagementUI();
                frame.getContentPane().add(panel);

                frame.pack();
                frame.setVisible(true);
            });
        });
        removeAccountButton.setPreferredSize(new Dimension(200, 50));
        constraints.gridx = 1;
        mainPanel.add(removeAccountButton, constraints);

        // Remove book button
        removeBookButton = new JButton("7. Remove book");
        removeBookButton.addActionListener((ActionEvent e) -> {
            // Handle remove book action
        });
        removeBookButton.setPreferredSize(new Dimension(200, 50));
        constraints.gridx = 0;
        constraints.gridy = 5;
        mainPanel.add(removeBookButton, constraints);

        // Exit button
        exitButton = new JButton("8. Exit");
        exitButton.addActionListener((ActionEvent e) -> {
            MethodController.exit();
        });
        exitButton.setPreferredSize(new Dimension(200, 50));
        constraints.gridx = 1;
        constraints.gridy = 5;
        mainPanel.add(exitButton, constraints);

        setContentPane(mainPanel);
        
        JPanel versionPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        versionPanel.setBackground(Color.WHITE);
        versionPanel.setPreferredSize(new Dimension(200, 20));
        
        JLabel versionLabel = new JLabel("(Version 1.0)");
        versionLabel.setFont(new Font("Arial", Font.PLAIN, 10));
        versionLabel.setForeground(Color.GRAY);
        versionPanel.add(versionLabel);

        constraints.gridx = 1;
        constraints.gridy = 6;
        constraints.anchor = GridBagConstraints.SOUTHEAST;
        mainPanel.add(versionPanel, constraints);
        
        setResizable(false);
    }

    
    public void run() {
        initializeUI();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

}