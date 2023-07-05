package View;

import Controller.*;
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
    private JButton exitButton;

    private final AccountManagementUI accountManagementUI;
    private final CreateAccountUI createAccountUI;
    private final SearchCustomerUI searchCustomerUI;

    public ManagerMenuUI() {
        setTitle("Manager Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000, 750));
        run();
        accountManagementUI = new AccountManagementUI();
        createAccountUI = new CreateAccountUI();
        searchCustomerUI = new SearchCustomerUI();
    }

    private void initializeUI() {
        // Tạo mainPanel với BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerSize(5);

        functionPanel = new JPanel();
        functionPanel.setLayout(new GridLayout(8, 1));
        splitPane.setLeftComponent(functionPanel);

        contentPanel = new JPanel(new GridBagLayout());

        // Nút "List all books"
        listBooksButton = new JButton("1. List all books");
        listBooksButton.addActionListener((ActionEvent e) -> {
            contentPanel.removeAll();
            contentPanel.add(new BookListUI(ManagementLibrary.book));
            contentPanel.revalidate();
            contentPanel.repaint();
        });
        functionPanel.add(listBooksButton);

        // Nút "List all customers"
        listCustomersButton = new JButton("2. List all customers");
        listCustomersButton.addActionListener((ActionEvent e) -> {
            contentPanel.removeAll();
            contentPanel.add(new CustomerListUI(ManagementLibrary.customer));
            contentPanel.revalidate();
            contentPanel.repaint();
        });
        functionPanel.add(listCustomersButton);

        searchBookButton = new JButton("3. Search book");
        searchBookButton.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(this, "Coming soon...");
        });
        functionPanel.add(searchBookButton);

        // Nút "Search customer"
        searchCustomerButton = new JButton("4. Search customer");
        searchCustomerButton.addActionListener((ActionEvent e) -> {          
            contentPanel.removeAll();
            contentPanel.add(searchCustomerUI);
            contentPanel.revalidate();
            contentPanel.repaint();
        });
        functionPanel.add(searchCustomerButton);

        // Nút "Add account"
        addAccountButton = new JButton("5. Add account");
        addAccountButton.addActionListener((ActionEvent e) -> {
            contentPanel.removeAll();
            contentPanel.add(createAccountUI);
            contentPanel.revalidate();
            contentPanel.repaint();
        });
        functionPanel.add(addAccountButton);

        // Nút "Remove account"
        removeAccountButton = new JButton("6. Remove account");
        removeAccountButton.addActionListener((ActionEvent e) -> {
            contentPanel.removeAll();
            contentPanel.add(accountManagementUI);
            contentPanel.revalidate();
            contentPanel.repaint();
        });
        functionPanel.add(removeAccountButton);

        // Nút "Exit"
        exitButton = new JButton("7. Exit");
        exitButton.addActionListener((ActionEvent e) -> {
            MethodController.exit();
        });
        functionPanel.add(exitButton);

        splitPane.setRightComponent(new JScrollPane(contentPanel));

        //Box Jpop
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
                LoginInfoUI loginInfoUI = new LoginInfoUI();
                loginInfoUI.showInfo();
            });
            popupMenu.add(showInfoItem);

            // Sự lựa chọn "Log out"
            JMenuItem logoutItem = new JMenuItem("Log out");
            logoutItem.addActionListener((ActionEvent event) -> {
                LoginInfoUI loginInfoUI = new LoginInfoUI();
                loginInfoUI.logout();
                JOptionPane.showMessageDialog(this, "Logged out successfully!");
            });
            popupMenu.add(logoutItem);

            popupMenu.show(loginInfoButton, 0, loginInfoButton.getHeight());
        });
        loginInfoPanel.add(loginInfoButton);

        mainPanel.add(splitPane, BorderLayout.CENTER);
        mainPanel.add(loginInfoPanel, BorderLayout.NORTH);

        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public final void run() {
        initializeUI();
        setVisible(true);
    }
}
