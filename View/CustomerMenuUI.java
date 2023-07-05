package View;

import Controller.ManagementLibrary;
import Controller.MethodController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public final class CustomerMenuUI extends JFrame {
    private JSplitPane splitPane;
    private JPanel functionPanel;
    private JPanel contentPanel;
    private JButton listBooksButton;
    private JButton searchBookButton;
    private JButton lendBookButton;
    private JButton returnBookButton;
    private JButton listLendingBooksButton;
    private JButton exitButton;
    private LoginInfoUI loginInfoUI;

    public CustomerMenuUI() {
        setTitle("Customer Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000, 750));
        loginInfoUI = new LoginInfoUI();
        initializeUI();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeUI() {
        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel loginInfoPanel = new JPanel();
        loginInfoPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

        JButton loginInfoButton = new JButton("Your Account");
        loginInfoButton.addActionListener((ActionEvent e) -> {
            JPopupMenu popupMenu = new JPopupMenu();
            
            JMenuItem showNameAccount = new JMenuItem("Login as: " + ManagementLibrary.logged.get(0).getName());
            showNameAccount.setEnabled(false);
            showNameAccount.addActionListener((ActionEvent event) -> {
            });
            popupMenu.add(showNameAccount);

            // Sự lựa chọn "Show info"
            JMenuItem showInfoItem = new JMenuItem("Show info");
            showInfoItem.addActionListener((ActionEvent event) -> {          
                loginInfoUI.showInfo();
            });
            popupMenu.add(showInfoItem);

            // Sự lựa chọn "Log out"
            JMenuItem logoutItem = new JMenuItem("Log out");
            logoutItem.addActionListener((ActionEvent event) -> {
                loginInfoUI.logout();
                JOptionPane.showMessageDialog(this, "Logged out successfully!");
            });
            popupMenu.add(logoutItem);

            popupMenu.show(loginInfoButton, 0, loginInfoButton.getHeight());
        });

        // Add the loginInfoButton to the panel
        loginInfoPanel.add(loginInfoButton);

        // Add the loginInfoPanel to the north of the mainPanel
        mainPanel.add(loginInfoPanel, BorderLayout.NORTH);

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

        // Search book button
        searchBookButton = new JButton("2. Search Book");
        searchBookButton.addActionListener((ActionEvent e) -> {
            contentPanel.removeAll();
            contentPanel.revalidate();
            contentPanel.repaint();
        });
        functionPanel.add(searchBookButton);

        // Lend book button
        lendBookButton = new JButton("3. Lend book");
        lendBookButton.addActionListener((ActionEvent e) -> {
            // Handle lend book action
        });
        functionPanel.add(lendBookButton);

        // Return book button
        returnBookButton = new JButton("4. Return Book");
        returnBookButton.addActionListener((ActionEvent e) -> {
            System.out.println("Hello4");
        });
        functionPanel.add(returnBookButton);

        // List lending books button
        listLendingBooksButton = new JButton("5. List Lending Book");
        listLendingBooksButton.addActionListener((ActionEvent e) -> {
            // Handle list lending books action
        });
        functionPanel.add(listLendingBooksButton);

        // Exit button
        exitButton = new JButton("6. Exit");
        exitButton.addActionListener((ActionEvent e) -> {
            MethodController.exit();
        });
        functionPanel.add(exitButton);

        splitPane.setRightComponent(new JScrollPane(contentPanel));

        // Create a new JPanel for the version label
        JPanel versionPanel = new JPanel();
        versionPanel.setLayout(new BorderLayout());

        JLabel versionLabel = new JLabel("Version 1.0 ");
        versionLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        versionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        versionPanel.add(versionLabel, BorderLayout.EAST);

        mainPanel.add(versionPanel, BorderLayout.SOUTH);
        // Add the splitPane to the center of the mainPanel
        mainPanel.add(splitPane, BorderLayout.CENTER);

        setContentPane(mainPanel);
        setResizable(false);
    }
}
