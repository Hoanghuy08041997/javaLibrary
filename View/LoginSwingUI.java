package View;

import Controller.IOReader;
import Controller.ManagementLibrary;
import Controller.MethodController;
import Controller.ValidateForSwing;
import Model.Account;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginSwingUI extends JFrame {
    private final JTextField usernameTextField;
    private final JPasswordField passwordField;
    private final JButton loginButton;
    private final JButton createAccountButton;
    private final JButton exitButton;

    public LoginSwingUI() {
        
        setTitle("Form Login Menu");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 2));

        JLabel usernameLabel = new JLabel("Username: ");
        usernameTextField = new JTextField();

        JLabel passwordLabel = new JLabel("Password: ");
        passwordField = new JPasswordField();

        loginButton = new JButton("Login Account");
        createAccountButton = new JButton("Create Account");
        exitButton = new JButton("Exit");

        mainPanel.add(usernameLabel);
        mainPanel.add(usernameTextField);
        mainPanel.add(passwordLabel);
        mainPanel.add(passwordField);
        mainPanel.add(loginButton);
        mainPanel.add(createAccountButton);
        mainPanel.add(exitButton);

        add(mainPanel);

        loginButton.addActionListener((ActionEvent e) -> {
            String us = usernameTextField.getText();
            String pd = new String(passwordField.getPassword());
            boolean validPassword = ValidateForSwing.checkPassword(passwordField);

            if (validPassword) {
                Account s = new Account(us, pd);
                int level = Account.checkLevelAccount(s);
                switch (level) {
                    case 0:
                        JOptionPane.showMessageDialog(null, "WRONG USERNAME OR PASSWORD. PLEASE DOUBLE CHECK OR CREATE ACCOUNT.", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    case 1:
                        Account.returnAccount(s);
                        JOptionPane.showMessageDialog(null, "WELCOME CUSTOMER");
                        CustomerMenuUI customerMenu = new CustomerMenuUI();
                        customerMenu.setVisible(true);
                        dispose();
                        break;
                    case 2:
                        Account.returnAccount(s);
                        JOptionPane.showMessageDialog(null, "WELCOME MANAGER");
                        ManagerMenuUI managerMenu = new ManagerMenuUI();
                        managerMenu.setVisible(true);
                        dispose();
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid password. Password must be at least 8 characters long and contain at least one digit, one letter, and one special character.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        createAccountButton.addActionListener((ActionEvent e) -> {
            CreateAccountUI createAccountUI = new CreateAccountUI();
            
            String us = usernameTextField.getText();
            String pd = new String(passwordField.getPassword());
            boolean validPassword = ValidateForSwing.checkPassword(passwordField);
            if (validPassword) {
                createAccountUI.createAccountForCall(us,pd);
            }
        });


        exitButton.addActionListener((ActionEvent e) -> {
            MethodController.exit();
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MethodController.loadData();
            LoginSwingUI loginSwingUI = new LoginSwingUI();
            loginSwingUI.setVisible(true);
        });
    }    
}
