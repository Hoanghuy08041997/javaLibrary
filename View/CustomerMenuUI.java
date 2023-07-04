package View;

import Controller.MethodController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public final class CustomerMenuUI extends JFrame {
    private JPanel mainPanel;
    private JLabel titleLabel;
    private JButton listBooksButton;
    private JButton searchBookButton;
    private JButton lendBookButton;
    private JButton returnBookButton;
    private JButton listLendingBooksButton;
    private JButton exitButton;

    public CustomerMenuUI() {
        setTitle("Customer Menu");
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

        titleLabel = new JLabel("Customer Menu", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLUE);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        mainPanel.add(titleLabel, constraints);

        listBooksButton = new JButton("1. List all books");
        listBooksButton.addActionListener((ActionEvent e) -> {
            // Handle list all books action
        });
        listBooksButton.setPreferredSize(new Dimension(200, 50));
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        mainPanel.add(listBooksButton, constraints);

        searchBookButton = new JButton("2. Search book");
        searchBookButton.addActionListener((ActionEvent e) -> {
            // Handle search book action
        });
        searchBookButton.setPreferredSize(new Dimension(200, 50));
        constraints.gridx = 1;
        mainPanel.add(searchBookButton, constraints);

        lendBookButton = new JButton("3. Lend book");
        lendBookButton.addActionListener((ActionEvent e) -> {
            // Handle lend book action
        });
        lendBookButton.setPreferredSize(new Dimension(200, 50));
        constraints.gridx = 0;
        constraints.gridy = 2;
        mainPanel.add(lendBookButton, constraints);

        returnBookButton = new JButton("4. Return book");
        returnBookButton.addActionListener((ActionEvent e) -> {
            // Handle return book action
        });
        returnBookButton.setPreferredSize(new Dimension(200, 50));
        constraints.gridx = 1;
        mainPanel.add(returnBookButton, constraints);

        listLendingBooksButton = new JButton("5. List lending books");
        listLendingBooksButton.addActionListener((ActionEvent e) -> {
            // Handle list lending books action
        });
        listLendingBooksButton.setPreferredSize(new Dimension(200, 50));
        constraints.gridx = 0;
        constraints.gridy = 3;
        mainPanel.add(listLendingBooksButton, constraints);

        exitButton = new JButton("Exit");
        exitButton.addActionListener((ActionEvent e) -> {
            MethodController.exit();
        });
        exitButton.setPreferredSize(new Dimension(200, 50));
        constraints.gridx = 1;
        constraints.gridy = 3; // Update the gridy value to match the position of listLendingBooksButton
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
