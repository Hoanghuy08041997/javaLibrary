package Controller;

import static Controller.ManagementLibrary.account;
import static Controller.ManagementLibrary.customer;
import Model.Customer;
import java.util.ArrayList;
import java.util.List;

public class MethodController {

    public static void loadData(){
        account.addAll(IOReader.readFileAccount("./src/ListAccounts.txt"));
        customer.addAll(IOReader.readFileCustomer("./src/ListCustomer.txt"));
        
    }
    public static void exit(){
        IOReader.saveFileAccount(ManagementLibrary.account, "./src/ListAccounts.txt");
        IOReader.saveFileCustomer(ManagementLibrary.customer, "./src/ListCustomer.txt");
        System.exit(0);
    }
    
    public static List<Integer> searchAccount(String searchCriteria, String s) {
        List<Integer> matchingAccounts = new ArrayList<>();
        SearchPredicate<Customer> searchCriteriaByProperties = new SearchPredicate<>(searchCriteria, s);
        for (Customer customer : ManagementLibrary.customer) {
            if (searchCriteriaByProperties.test(customer)) {
                matchingAccounts.add(customer.getId());
            }
        }
        return matchingAccounts;
    }
    
}