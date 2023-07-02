package Controller;

import Model.Account;
import Model.Customer;
import View.Menu;
import java.time.LocalDate;
import java.util.Random;

public class LoginController {
    
    public static void LoginVerify(){
        String [] options = {"Login Account","Create Account", "Exit"};
        Menu menu = new Menu("Welcome to Form Login Menu ",options) {
            @Override
            public void execute(int i) {
                switch (i) {
                    case 1:
                        String us = Validate.stringWithNumberUserInput("Username: ");
                        String pd = Validate.stringWithNumberUserInput("Password: ");  
                        int level = Account.checkAccount(new Account(us,pd));
                        switch (level) {
                            case 1:
                                System.out.println("WELCOME CUSTOMER");
                                break;
                            case 2:
                                System.out.println("\u001B[32m" + "WELCOME MANAGER" + "\u001B[0m");
                                ManagerController.managerMenu();
                                break;
                            default:
                                System.out.println("\u001B[31m" + "WRONG USERNAME OR PASSWORD. PLEASE DOUBLE CHECK OR CREATE ACCOUNT." + "\u001B[0m");
                                break;
                        }
                        break;
                        
                    case 2:
                        int id;
                        boolean valid = false;
                        Random random = new Random();

                        if (ManagementLibrary.account.isEmpty()) {
                            valid = true;
                        }

                        do {
                            id = random.nextInt();                         
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
                        String username = Validate.stringWithNumberUserInput("Username: ");
                        String password = Validate.stringWithNumberUserInput("Password: ");
                        String email = Validate.stringUserInput("Email: ");
                        String phone = Validate.stringPhoneInput("Phone: ");
                        LocalDate birthday = Validate.parseDate(Validate.getBirthdayString("Birthday: "));

                        Customer c = new Customer(id, username, password, email, phone, birthday, 1);
                        ManagementLibrary.account.add(new Account(username, password, 1, id));
                        ManagementLibrary.customer.add(c);

                        break;

                    case 3:
                    System.out.println("Goodbye");
                    IOReader.saveFileAccount(ManagementLibrary.account,"D:\\Java-PRO192\\ManagementLibrary\\src\\ListAccounts.txt");               
                    System.exit(0);
                    break;
                }
            };
        };
        
        menu.run();
    }
}
