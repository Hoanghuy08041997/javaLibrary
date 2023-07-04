package Controller;

public class MethodController {

    public static void exit(){
        IOReader.saveFileAccount(ManagementLibrary.account, "D:\\Java-PRO192\\ManagementLibrary\\src\\ListAccounts.txt");
        IOReader.saveFileCustomer(ManagementLibrary.customer, "D:\\Java-PRO192\\ManagementLibrary\\src\\ListCustomer.txt");
        System.exit(0);
    }
}