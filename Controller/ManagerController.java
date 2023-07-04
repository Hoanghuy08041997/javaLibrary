package Controller;

import static Controller.ManagementLibrary.account;
import Model.Account;
import View.Menu;
import java.util.List;
import java.util.stream.Collectors;

public class ManagerController {
    public static void managerMenu(){
        String tt = "Manager Menu";
        String[] ls = {"List all book",
        "List all customer",
        "Sreach book",
        "Sreach customer",
        "Add account",
        "Remove account",
        "Remove book"};
        Menu m = new Menu(tt, ls) {
            @Override
            public void execute(int i) {
                switch (i) {
                    case 1:
                        System.out.println("Hello1");
                        break;
                    case 2:
                        System.out.println(ManagementLibrary.customer);
                        break;
                    case 3:
                        System.out.println("Hello3");
                        break;
                    case 4:
                        System.out.println("Hello4");
                        break;                   
                    case 5:
                        System.out.println("Hello");
                        break;
                    case 6:

                        break;                   
                }
            }
        };
        m.run();
    }
}
