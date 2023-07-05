package Controller;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Validate {
    
    //input Option
    public static int twoOptionUserInput(String msg){
        if (!msg.isEmpty()) System.out.println("\u001B[34m" + msg + "\u001B[0m");
        Scanner input = new Scanner(System.in);
        int option = 0;
        boolean valid = false;
        while (!valid) {
        String numStr = input.nextLine();
            if (!numStr.contains("  ") && !numStr.startsWith(" ") && numStr.matches("[12]") && !numStr.isEmpty() ) {
                option = Integer.parseInt(numStr); 
                valid = true;
            } else System.out.println("That wrong. Please following.");
        }
        return option;
    }    
    public static int threeOptionUserInput(String msg){
        if (!msg.isEmpty()) System.out.println("\u001B[34m" + msg + "\u001B[0m");
        Scanner input = new Scanner(System.in);
        int option = 0;
        boolean valid = false;
        while (!valid) {
        String numStr = input.nextLine();
            if (!numStr.contains("  ") && !numStr.startsWith(" ") && numStr.matches("[123]") && !numStr.isEmpty() ) {
                option = Integer.parseInt(numStr); 
                valid = true;
            } else System.out.println("That wrong. Please following from 1 -> 3.");
        }
        return option;
    }  
    public static int fourOptionUserInput(String msg){
        if (!msg.isEmpty()) System.out.println("\u001B[34m" + msg + "\u001B[0m");
        Scanner input = new Scanner(System.in);
        int option = 0;
        boolean valid = false;
        while (!valid) {
        String numStr = input.nextLine();
            if (!numStr.contains("  ") && !numStr.startsWith(" ") && numStr.matches("[1234]") && !numStr.isEmpty() ) {
                option = Integer.parseInt(numStr); 
                valid = true;
            } else System.out.println("That wrong. Please following 1 -> 4.");
        }
        return option;
    }      
    public static int fiveOptionUserInput(){
        Scanner input = new Scanner(System.in);
        int option = 0;
        boolean valid = false;
        while (!valid) {
        String numStr = input.nextLine();
            if (!numStr.contains("  ") && !numStr.startsWith(" ") && numStr.matches("[12345]") && !numStr.isEmpty() ) {
                option = Integer.parseInt(numStr); 
                valid = true;
            } else System.out.println("That wrong. Please following 1 -> 5.");
        }
        return option;
    }  
    public static int sixOptionUserInput(){
        Scanner input = new Scanner(System.in);
        int option = 0;
        boolean valid = false;
        while (!valid) {
        String numStr = input.nextLine();
            if (!numStr.contains("  ") && !numStr.startsWith(" ") && numStr.matches("[123456]") && !numStr.isEmpty() ) {
                option = Integer.parseInt(numStr); 
                valid = true;
            } else System.out.println("That wrong. Please following 1 -> 6.");
        }
        return option;
    }  
    public static int sevenOptionUserInput(){
        Scanner input = new Scanner(System.in);
        int option = 0;
        boolean valid = false;
        while (!valid) {
        String numStr = input.nextLine();
            if (!numStr.contains("  ") && !numStr.startsWith(" ") && numStr.matches("[1234567]") && !numStr.isEmpty() ) {
                option = Integer.parseInt(numStr); 
                valid = true;
            } else System.out.println("That wrong. Please following 1 -> 7.");
        }
        return option;
    }  
    public static int eightOptionUserInput(){
        Scanner input = new Scanner(System.in);
        int option = 0;
        boolean valid = false;
        while (!valid) {
        String numStr = input.nextLine();
            if (!numStr.contains("  ") && !numStr.startsWith(" ") && numStr.matches("[12345678]") && !numStr.isEmpty() ) {
                option = Integer.parseInt(numStr); 
                valid = true;
            } else System.out.println("That wrong. Please following 1 -> 8.");
        }
        return option;
    } 
    public static int menuOptionUserInput(int i){
        Scanner input = new Scanner(System.in);
        int option = 0;
        boolean valid = false;
        while (!valid) {
            String numStr = input.nextLine();
            if (numStr.trim().matches("^\\d+$") && !numStr.isEmpty()) {
                option = Integer.parseInt(numStr); 
                if (option > 0 && option <= i) {
                    valid = true; 
                    System.out.println("\u001B[32m" + "==========You have chosen option " + option +" ===========" + "\u001B[0m");
                }
                else {
                    System.out.println("\u001B[31m" + "Invalid input. Please enter a number between 1 and " + i + "\u001B[0m");
                }    
            } 
            else {
                System.out.println("\u001B[31m" + "Invalid input. Please enter a number between 1 and " + i + "\u001B[0m");
            }
        }
        return option;
    }
      
    //Yes No user input
    public static String continueProgramUserInput() {
            Scanner scanner = new Scanner(System.in);
            String userInput = "";
            boolean isValidInput = false;

            while (!isValidInput) {
                userInput = scanner.nextLine().toLowerCase();

                if (userInput.equals("y") || userInput.equals("n")) {
                    isValidInput = true;
                } else {
                    System.out.println("\u001B[31m" + "Invalid input. Please try again." + "\u001B[0m");
                }
            }        
            return userInput;
    }
       
    //User input type of Data
    public static int intUserInput(String msg){
        if (!msg.isEmpty()) System.out.println("\u001B[34m" + msg + "\u001B[0m");
        Scanner input = new Scanner(System.in);
        int option = 0;
        boolean valid = false;
        while (!valid) {
        String numStr = input.nextLine();
            if (!numStr.contains("  ") && !numStr.startsWith(" ") && numStr.matches("\\d+") && !numStr.isEmpty() ) {
                option = Integer.parseInt(numStr); 
                valid = true;
            } else System.out.println("\u001B[31m" + "That wrong. Please following integer number." + "\u001B[0m");
        }
        return option;
    }
    public static long longUserInput(){
        Scanner input = new Scanner(System.in);
        long option = 0;
        boolean valid = false;
        while (!valid) {
            String numStr = input.nextLine();
            if (!numStr.contains("  ") && !numStr.startsWith(" ") && numStr.matches("\\d+") && !numStr.isEmpty() ) {
                option = Long.parseLong(numStr); 
                valid = true;
            } else System.out.println("\u001B[31m" + "That wrong. Please following integer number." + "\u001B[31m");
        }
        return option;
    }
    public static double doubleUserInput() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                double result = Double.parseDouble(input.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.out.print("\u001B[31m" + "Invalid input. Please enter a number: " + "\u001B[0m");
            }
        }
    }
    public static float floatUserInput() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                float result = Float.parseFloat(input.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.out.print("\u001B[31m" + "Invalid input. Please enter a number: " + "\u001B[0m");
            }
        }
    }   
    public static String stringUserInput(String msg) {
        if (!msg.isEmpty()) System.out.println("\u001B[34m" + msg + "\u001B[0m");
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        String string = "";
        while (!valid) {
            String temple = input.nextLine();
            if (!temple.startsWith(" ") && temple.matches("[A-Za-z]*") && !temple.isEmpty()) {
                string = temple.trim();
                valid = true;
            } else {
                System.out.println("\u001B[31m" + "String cannot be validated. Please enter again." + "\u001B[0m");
            }
        }
        return string;
    }
    public static String stringWithNumberUserInput(String msg) {
        if (!msg.isEmpty()) System.out.println("\u001B[34m" + msg + "\u001B[0m");
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        String string = "";
        while (!valid) {
            String temple = input.nextLine();
            if (!temple.startsWith(" ") && temple.matches("[A-Za-z0-9]*") && !temple.isEmpty()) {
                string = temple.trim();
                valid = true;
            } else {
                System.out.println("\u001B[31m" + "Name cannot be validated. Please enter again." + "\u001B[0m");
            }
        }
        return string;
    }
    public static String checkedPass(String msg){
         if (!msg.isEmpty()) System.out.println("\u001B[34m" + msg + "\u001B[0m");
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        String string = "";
        while (!valid) {
            String temple = input.nextLine();
            if (temple.length() >= 8 && temple.matches("^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=]).*$")) {
                string = temple.trim();
                valid = true;
            } else {
                System.out.println("\u001B[31m" + "Password must be at least 8 characters long and contain at least one digit, one letter, and one special character." + "\u001B[0m");
            }
        }
        return string;
    }
    public static String nameUserInput(String msg) {
        if (!msg.isEmpty()) System.out.println(msg);
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        String string = "";
        while (!valid) {
            String name = input.nextLine();
            if (!name.startsWith(" ") && name.matches("[A-Za-z]+( [A-Za-z]+)*") && !name.isEmpty()) {
                string = name.trim();
                valid = true;
            } else {
                System.out.println("\u001B[31m" + "Name cannot be validated. Please enter again." + "\u001B[31m");
            }
        }
        return string;
    }
    public static String getBirthdayString(String msg) {
        if (!msg.isEmpty())
            System.out.println("\u001B[34m" + msg + "\u001B[0m");
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        String date = "";
        while (!valid) {
            String birth = input.nextLine();
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
                            // Định dạng lại chuỗi theo định dạng "dd/MM/yyyy"
                            date = String.format("%02d/%02d/%04d", day, month, year);
                            valid = true;
                        } else {
                            System.out.println("\u001B[31m" + "Invalid date. Please enter again." + "\u001B[0m");
                        }
                    } else {
                        System.out.println("\u001B[31m" + "Invalid month. Please enter again." + "\u001B[0m");
                    }
                } else {
                    System.out.println("\u001B[31m" + "Invalid date format (dd/MM/yyyy). Please enter again." + "\u001B[0m");
                }
            } else {
                System.out.println("\u001B[31m" + "Date cannot start with a space. Please enter again." + "\u001B[0m");
            }
        }
        return date;
    }
    public static int dayUserInput(){
        Scanner input = new Scanner(System.in);
        int option = 0;
        boolean valid = false;
        while (!valid) {
        String numStr = input.nextLine();
            if (!numStr.contains("  ") && !numStr.startsWith(" ") && numStr.matches("^(?:[1-9]|[12]\\d|30)$") && !numStr.isEmpty() ) {
                option = Integer.parseInt(numStr); 
                valid = true;
            } else System.out.println("\u001B[31m" + "That wrong. Please following integer number from 1 to 30." + "\u001B[0m");
        }
        return option;
    }
    public static String stringPhoneInput(String msg) {
        if (!msg.isEmpty()) System.out.println(msg);
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        String phoneNumber = null;
        while (!valid) {
            String phoneStr = input.nextLine();
            if (!phoneStr.isEmpty() && phoneStr.matches("^(0|\\+84)\\d{9}$")) { // Fix regex pattern
                phoneStr = phoneStr.trim();
                phoneNumber = phoneStr;
                valid = true;
            } else {
                System.out.println("\u001B[31m" + "Wrong format. Please enter a valid 10-digit phone number with prefix 0 or +84." + "\u001B[0m");
            }
        }

        return phoneNumber;
    }   
    public static String stringPhone09Input(String msg) {
        if (!msg.isEmpty()) System.out.println(msg);
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        String phoneNumber = null;
        while (!valid) {
            String phoneStr = input.nextLine();
            if (!phoneStr.isEmpty() && phoneStr.matches("^(09|\\+849)\\d{8}$")) {
                phoneStr = phoneStr.trim();
                phoneNumber = phoneStr;
                valid = true;
            } else {
                System.out.println("\u001B[31m" + "Wrong format. Please enter a valid 10-digit phone number with prefix 09 or +849." + "\u001B[0m");
            }
        }

        return phoneNumber;
    }
    public static String stringEmailInput(String msg) {
        if (!msg.isEmpty())
            System.out.println("\u001B[34m" + msg + "\u001B[0m");
        Scanner input = new Scanner(System.in);
        boolean valid = false;
        String email = "";
        while (!valid) {
            String inputEmail = input.nextLine();
            if (!inputEmail.startsWith(" ") && inputEmail.matches("[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z0-9]+") && !inputEmail.isEmpty()) {
                email = inputEmail.trim();
                valid = true;
            } else {
                System.out.println("\u001B[31m" + "Invalid email format. Please enter again." + "\u001B[0m");
            }
        }
        return email;
    }
    
    //Random
    public static int generateRandomId() {
        Random random = new Random();
        int id;
        boolean valid = false;
        
        do {
            id = random.nextInt(Integer.MAX_VALUE); // Tạo số ngẫu nhiên

            // Kiểm tra xem id có tồn tại trong danh sách đã có hay không
            for (int k = 0; k < ManagementLibrary.account.size(); k++) {
                if (id == ManagementLibrary.account.get(k).getId()) {
                    valid = false;
                    break;
                } else {
                    valid = true;
                }
            }
        } while (!valid);
        
        return id;
    }
    
    //Others checking
    public static boolean checkArrayListEmpty(ArrayList<?> Arr) {
        boolean valid = false;
        if (Arr.isEmpty()) valid = true;
        return valid;
    }
    public static String idCustomerCheckSixcharacter(String msg){
        if (!msg.isEmpty()) System.out.println(msg);        
        Scanner input = new Scanner(System.in);
        String Stringid = "";
        boolean valid = false;
        while (!valid){
            String s = input.nextLine();
            if (!s.startsWith(" ") && !s.contains("  ") && !s.isEmpty() && s.matches("^KH0*(?!0{4})[1-9]\\d{0,3}|KH[1-9]\\d{3}$") ){
                Stringid = s;
                valid = true;
            } else System.out.println("\u001B[31m" + "Please input KH + number(0<number<10000)" + "\u001B[0m");
        }
        return Stringid;             
    }
    public static LocalDate parseDate(String input) throws DateTimeParseException {
        DateTimeFormatter formatter = new DateTimeFormatterBuilder()
                .appendPattern("[dd/MM/yyyy][yyyy-MM-dd]")
                .toFormatter();
        return LocalDate.parse(input, formatter);
    }
//    public static <T> boolean checkPropertyNull(ArrayList<Customer> arr, int i) {
//        boolean check = true;
//        Function<Customer, T> propertyAccessor = null;
//
//        switch (i) {
//            case 1:
//                propertyAccessor = (Customer c) -> (T) c.getId();
//                break;
//            case 2:
//                propertyAccessor = (Customer c) -> (T) c.getName();
//                break;
//            case 3:
//                propertyAccessor = (Customer c) -> (T) c.getPhone();
//                break;
//            case 4:
//                propertyAccessor = (Customer c) -> (T) c.getBirthday();
//                break;
//        }
//        
//        try {
//            for (Customer customer : arr) {
//                if (propertyAccessor.apply(customer) == null) {
//                    check = false;
//                    throw new IllegalArgumentException("\u001B[31m" + " Property is null" + "\u001B[0m");
//                }
//            }
//        } catch (IllegalArgumentException e) { System.out.println("Error: " + e.getMessage());}
//
//        return check;
//    }   
    
}
