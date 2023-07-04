package View;

import Controller.ManagementLibrary;
import Controller.MethodController;
import Controller.ValidateForSwing;
import Model.Account;
import Model.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.Random;

public class CreateAccountUI extends JPanel {
    private final JTextField usernameTextField;
    private final JPasswordField passwordField;
    private final JButton createAccountButton;
    private final JButton saveButton;

    public CreateAccountUI() {
        setLayout(new GridLayout(3, 2));

        JLabel usernameLabel = new JLabel("Username: ");
        usernameTextField = new JTextField();

        JLabel passwordLabel = new JLabel("Password: ");
        passwordField = new JPasswordField();

        createAccountButton = new JButton("Create Account");
        saveButton = new JButton("Save Data");

        add(usernameLabel);
        add(usernameTextField);
        add(passwordLabel);
        add(passwordField);
        add(createAccountButton);
        add(saveButton);

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
                    Account account = new Account(username, password, 1, id);
                    ManagementLibrary.account.add(account);
                    ManagementLibrary.customer.add(c);
                    // Thêm tài khoản vào danh sách và hiển thị thông báo
                    JOptionPane.showMessageDialog(null, "Account created successfully!");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid password. Password must be at least 8 characters long and contain at least one digit, one letter, and one special character.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        saveButton.addActionListener((ActionEvent e) -> {
            MethodController.saveData();
        });
        
        Dimension size = new Dimension(300, 650);
        setPreferredSize(size);
        setSize(size);
    }

    private int generateRandomId() {
        int id;
        boolean valid = false;
        Random random = new Random();

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
            } else {
                valid = true;
            }
        } while (!valid);
        return id;
    }
}
