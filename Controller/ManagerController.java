
package Controller;

import View.Menu;

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
                        System.out.println("Hello2");
                        break;
                    case 3:
                        System.out.println("Hello3");
                        break;
                    case 4:
                        System.out.println("Hello4");
                        break;                   
                }
            }
        };
        m.run();
    }
}
