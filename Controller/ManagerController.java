package Controller;

import View.Menu;


public class ManagerController {
    public static void managerMenu(){
        String tt = "Manager Menu";
        String[] ls = {"List all book",
        "List all customer",
        "List book borrow",
        "Sreach book",
        "Sreach customer",
        "Update book",
        "Update customer",
        "Remove account",
        "Remove book",
        "Exit"};
        Menu m = new Menu(tt, ls) {
            @Override
            public void execute(int i) {
                switch (i) {
                    case 1:
                        MethodController.listAllBooks("List book", ManagementLibrary.book);
                        break;
                    case 2:
                        MethodController.listAllCustomer("List customer", ManagementLibrary.customer);
                        break;
                    case 3:
                        MethodController.listAllBooks("List book borrow", ManagementLibrary.bookBorrow);
                        break;
                    case 4:
                        MethodController.searchBooks();
                        break;                   
                    case 5:
                        MethodController.searchCustomer();
                        break;
                    case 6:
                        MethodController.menuUpdateBook();
                        break;                   
                    case 7:
                        MethodController.menuUpdateCustomer();
                        break;                   
                    case 8:
                        MethodController.removeAccount();
                        break;                   
                    case 9:
                        MethodController.removeBook();
                        break;                   
                }
            }
        };
        m.run();
    }
}
