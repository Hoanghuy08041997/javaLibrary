package Controller;

import Model.Account;
import Model.Book;
import Model.Customer;
import Model.Manager;
import java.util.ArrayList;

public class ManagementLibrary {
    public static ArrayList<Customer> customer = new ArrayList<>();
    public static ArrayList<Manager> manager = new ArrayList<>(); 
    public static ArrayList<Book> book = new ArrayList<>();
    public static ArrayList<Account> account = new ArrayList<>();
    
    public static void loadData(){
        account.addAll(IOReader.readFileAccount("D:\\Java-PRO192\\ManagementLibrary\\src\\ListAccounts.txt"));
    }
    
}