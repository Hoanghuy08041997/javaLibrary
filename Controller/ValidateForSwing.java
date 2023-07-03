package Controller;

import Model.Customer;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class ValidateForSwing {
    //Username
    public static boolean isValidUsername(String username) {
        if (!username.startsWith(" ") && !username.isEmpty()) {
            if (isDuplicateUsername(username)) {
                JOptionPane.showMessageDialog(null, "Username is already used by another account. Please enter a different username.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            } else {
                return true;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid username. Username only include number and character. Please enter again.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    public static boolean isDuplicateUsername(String username) {
        for (Customer existingCustomer : ManagementLibrary.customer) {
            if (existingCustomer.getName().equals(username)) {
                return true; // Found a duplicate username
            }
        }

        return false; // No duplicate username found
    }    
    
    //Password
    public static String getPasswordInput(JPasswordField passwordField) {
        char[] passwordChars = passwordField.getPassword();
        return new String(passwordChars);
    }
    public static boolean checkPassword(JPasswordField passwordField) {
        char[] passwordChars = passwordField.getPassword();
        String password = new String(passwordChars);
        return password.length() >= 8 && password.matches("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=]).*$");
    }
    //Phone
    public static String getPhoneInput() {
        JTextField textField = new JTextField();
        boolean valid = false;
        String phoneNumber = null;
        
        while (!valid) {
            int result = JOptionPane.showConfirmDialog(null, textField, "Input", JOptionPane.OK_CANCEL_OPTION);
            
            if (result == JOptionPane.OK_OPTION) {
                String phoneStr = textField.getText();
                
                if (!phoneStr.isEmpty() && phoneStr.matches("^(0|\\+84)\\d{9}$")) {
                    phoneStr = phoneStr.trim();
                    phoneNumber = phoneStr;
                    valid = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong format. Please enter a valid 10-digit phone number with prefix 0 or +84.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                System.exit(0);
            }
        }
        
        return phoneNumber;
    }
    public static String getPhone09Input() {
        JTextField textField = new JTextField();
        boolean valid = false;
        String phoneNumber = null;
        
        while (!valid) {
            int result = JOptionPane.showConfirmDialog(null, textField, "Phone", JOptionPane.OK_CANCEL_OPTION);
            
            if (result == JOptionPane.OK_OPTION) {
                String phoneStr = textField.getText();
                
                if (!phoneStr.isEmpty() && phoneStr.matches("^(09|\\+849)\\d{8}$")) {
                    if (ValidateForSwing.isValidPhone(phoneStr)){
                        phoneStr = phoneStr.trim();
                        phoneNumber = phoneStr;
                        valid = true;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong format. Please enter a valid 10-digit phone number with prefix 09 or +849.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                System.exit(0);
            }
        }
        
        return phoneNumber;
    }   
    public static boolean isValidPhone(String phone) {
        if (!phone.startsWith(" ") && phone.matches("[0-9]{10}")) {
            if (isDuplicatePhone(phone)) {
                JOptionPane.showMessageDialog(null, "Phone number is already used by another account. Please enter a different phone number.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            } else {
                return true;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid phone number format. Please enter again.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    public static boolean isDuplicatePhone(String phone) {
        for (Customer existingCustomer : ManagementLibrary.customer) {
            if (existingCustomer.getPhone().equals(phone)) {
                return true; // Found a duplicate phone number
            }
        }

        return false; // No duplicate phone number found
    }  
    
    //Email
    public static String getEmailInput() {
        JTextField textField = new JTextField();
        boolean valid = false;
        String email = "";
        
        while (!valid) {
            int result = JOptionPane.showConfirmDialog(null, textField, "Email", JOptionPane.OK_CANCEL_OPTION);
            
            if (result == JOptionPane.OK_OPTION) {
                String inputEmail = textField.getText();
                
                if (!inputEmail.startsWith(" ") && inputEmail.matches("[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z0-9]+") && !inputEmail.isEmpty()) {
                    if (ValidateForSwing.isValidEmail(inputEmail)){
                        email = inputEmail.trim();
                        valid = true;
                    } else JOptionPane.showMessageDialog(null, "Email exited. Please enter again.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid email format. Please enter again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                System.exit(0);
            }
        }
        
        return email;
    }  
    public static boolean isValidEmail(String email) {

        if (!email.startsWith(" ") && email.matches("[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z0-9]+") && !email.isEmpty()) {
            if (isDuplicateEmail(email)) {
                JOptionPane.showMessageDialog(null, "Email is already used by another account. Please enter a different email.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            } else {
                return true;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Invalid email format. Please enter again.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    public static boolean isDuplicateEmail(String email) {
        for (Customer existingCustomer : ManagementLibrary.customer) {
            if (existingCustomer.getEmail().equals(email)) {
                return true; // Found a duplicate email
            }
        }

        return false; // No duplicate email found
    }
  
    //Day
    public static String getBirthdayString() {
        JTextField textField = new JTextField();
        boolean valid = false;
        String date = "";
        
        while (!valid) {
            int result = JOptionPane.showConfirmDialog(null, textField, "Birthday", JOptionPane.OK_CANCEL_OPTION);
            
            if (result == JOptionPane.OK_OPTION) {
                String birth = textField.getText();
                
                if (!birth.startsWith(" ")) {
                    String[] parts = birth.split("/");
                    
                    if (parts.length == 3) {
                        int day = Integer.parseInt(parts[0]);
                        int month = Integer.parseInt(parts[1]);
                        int year = Integer.parseInt(parts[2]);
                        
                        boolean isLeapYear = java.time.Year.of(year).isLeap();
                        
                        if (month >= 1 && month <= 12) {
                            boolean isValidDay = day >= 1 && day <= Month.of(month).maxLength();
                            
                            if (isValidDay || (month == 2 && day == 29 && isLeapYear)) {
                                // Format the string in "dd/MM/yyyy" format
                                date = String.format("%02d/%02d/%04d", day, month, year);
                                valid = true;
                            } else {
                                JOptionPane.showMessageDialog(null, "Invalid date. Please enter again.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid month. Please enter again.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid date format (dd/MM/yyyy). Please enter again.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Date cannot start with a space. Please enter again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                System.exit(0);
            }
        }
        
        return date;
    }
    public static LocalDate parseDate(String input) throws DateTimeParseException {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("[dd/MM/yyyy][yyyy-MM-dd]")
                .toFormatter();
        return LocalDate.parse(input, formatter);
    }
    
}
