package View;

import Controller.IOReader;
import Controller.ManagementLibrary;
import Controller.ValidateForSwing;
import Model.Account;
import Model.Customer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.Random;

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
                int level = Account.checkAccount(new Account(us, pd));
                switch (level) {
                    case 0:
                        JOptionPane.showMessageDialog(null, "WRONG USERNAME OR PASSWORD. PLEASE DOUBLE CHECK OR CREATE ACCOUNT.", "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null, "WELCOME CUSTOMER");
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(null, "WELCOME MANAGER");
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid password. Password must be at least 8 characters long and contain at least one digit, one letter, and one special character.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        createAccountButton.addActionListener((ActionEvent e) -> {
            int id = generateRandomId();
            String username = usernameTextField.getText();
            if (ValidateForSwing.isValidUsername(username)){
            String password = new String(passwordField.getPassword());           
            boolean validPassword = ValidateForSwing.checkPassword(passwordField);
                if (validPassword) {
                    String email = ValidateForSwing.getEmailInput();
                    String phone = ValidateForSwing.getPhone09Input();
                    LocalDate birthday = ValidateForSwing.parseDate(ValidateForSwing.getBirthdayString());
                    Customer c = new Customer(id, username, email, phone, birthday, 1);
                    ManagementLibrary.account.add(new Account(username, password, 1, id));
                    ManagementLibrary.customer.add(c);

                    JOptionPane.showMessageDialog(null, "Account created successfully!");         
                } else JOptionPane.showMessageDialog(null, "Invalid password. Password must be at least 8 characters long and contain at least one digit, one letter, and one special character.", "Error", JOptionPane.ERROR_MESSAGE);  
            }           
        });

        exitButton.addActionListener((ActionEvent e) -> {
            IOReader.saveFileAccount(ManagementLibrary.account, "D:\\Java-PRO192\\ManagementLibrary\\src\\ListAccounts.txt");
            IOReader.saveFileCustomer(ManagementLibrary.customer, "D:\\Java-PRO192\\ManagementLibrary\\src\\ListCustomer.txt");
            System.exit(0);
        });
    }

    private int generateRandomId() {
        int id;
        boolean valid = false;
        Random random = new Random();

        if (ManagementLibrary.account.isEmpty()) {
            valid = true;
        }

        do {
            id = random.nextInt(Integer.MAX_VALUE);                         
            if (!ManagementLibrary.account.isEmpty()) {
                for (int k = 0; k < ManagementLibrary.account.size(); k++) {
                    if (id == ManagementLibrary.account.get(k).getId()) {
                       valid = false;
                        break;
                    } else {
                        valid = true;
                    }
                }
            }
        } while (!valid);
        return id;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ManagementLibrary.loadData();
            LoginSwingUI loginSwingUI = new LoginSwingUI();
            loginSwingUI.setVisible(true);
        });
    }
    
}
