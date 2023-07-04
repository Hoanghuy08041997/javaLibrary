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
        setLayout(new GridLayout(4, 2));

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
            String us1 = usernameTextField.getText();
            String pd1 = new String(passwordField.getPassword());
            this.createAccount(us1,pd1);
        });

        saveButton.addActionListener((ActionEvent e) -> {
            MethodController.saveData();
        });
        
        Dimension size = new Dimension(600, 200);
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
    
    public void createAccount(String username,String password){
        int id = generateRandomId();
        if (ValidateForSwing.isValidUsername(username)) {
            boolean validPassword = ValidateForSwing.checkPassword(passwordField);
            
            if (validPassword) {
                String email = "";
                String phone = "";
                LocalDate birthday = null;

                boolean isCancelled = false; 

                // Hỏi thông tin email
                while (email.isEmpty() && !isCancelled) {
                    email = ValidateForSwing.getEmailInput();
                    if (email.isEmpty()) {
                        int option = JOptionPane.showConfirmDialog(null, "Do you want to cancel creating an account?", "Confirmation", JOptionPane.YES_NO_OPTION);
                        if (option == JOptionPane.YES_OPTION) {
                            isCancelled = true; // Đặt cờ nếu người dùng chọn Cancel
                        }
                    }
                }

                // Hỏi thông tin số điện thoại
                while (phone.isEmpty() && !isCancelled) {
                    phone = ValidateForSwing.getPhone09Input();
                    if (phone.isEmpty()) {
                        int option = JOptionPane.showConfirmDialog(null, "Do you want to cancel creating an account?", "Confirmation", JOptionPane.YES_NO_OPTION);
                        if (option == JOptionPane.YES_OPTION) {
                            isCancelled = true; // Đặt cờ nếu người dùng chọn Cancel
                        }
                    }
                }

                // Hỏi thông tin ngày sinh
                while (birthday == null && !isCancelled) {
                    String birthdayString = ValidateForSwing.getBirthdayString();
                    birthday = ValidateForSwing.parseDate(birthdayString);
                    if (birthday == null) {
                        int option = JOptionPane.showConfirmDialog(null, "Do you want to cancel creating an account?", "Confirmation", JOptionPane.YES_NO_OPTION);
                        if (option == JOptionPane.YES_OPTION) {
                            isCancelled = true; // Đặt cờ nếu người dùng chọn Cancel
                        }
                    }
                }

                if (!isCancelled) {
                    Customer c = new Customer(id, username, email, phone, birthday, 1);
                    ManagementLibrary.account.add(new Account(username, password, 1, id));
                    ManagementLibrary.customer.add(c);
                    JOptionPane.showMessageDialog(null, "Account created successfully!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid password. Password must be at least 8 characters long and contain at least one digit, one letter, and one special character.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public void createAccountForCall(String username,String password){
        int id = generateRandomId();
        String email = "";
        String phone = "";
        LocalDate birthday = null;
        boolean isCancelled = false; 

        while (email.isEmpty() && !isCancelled) {
            email = ValidateForSwing.getEmailInput();
            if (email.isEmpty()) {
                int option = JOptionPane.showConfirmDialog(null, "Do you want to cancel creating an account?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    isCancelled = true; 
                }
            }
        }
      
        while (phone.isEmpty() && !isCancelled) {
            phone = ValidateForSwing.getPhone09Input();
            if (phone.isEmpty()) {
                int option = JOptionPane.showConfirmDialog(null, "Do you want to cancel creating an account?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    isCancelled = true; 
                }
            }
        }

        while (birthday == null && !isCancelled) {
            String birthdayString = ValidateForSwing.getBirthdayString();
            birthday = ValidateForSwing.parseDate(birthdayString);
            if (birthday == null) {
                int option = JOptionPane.showConfirmDialog(null, "Do you want to cancel creating an account?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    isCancelled = true; 
                }
            }
        }

        if (!isCancelled) {
            Customer c = new Customer(id, username, email, phone, birthday, 1);
            ManagementLibrary.account.add(new Account(username, password, 1, id));
            ManagementLibrary.customer.add(c);
            JOptionPane.showMessageDialog(null, "Account created successfully!");
        }
    }
}

