package Controller;

import View.Menu;

public class CustomerController {
    public static void customerMenu(){
        String tt = "Customer Menu";
        String[] ls = {
        "List all books",
        "Search books",
        "Lend books",
        "Return books",
        "List lending books"
        };
        Menu m = new Menu(tt, ls) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1:
                        MethodController.listAllBooks();
                        break;
                    case 2:
                        MethodController.searchBooks();
                        break;
                    case 3:
                        MethodController.lendBooks();
                        break;
                    case 4:
                        MethodController.returnBooks();
                        break;   
                    case 5:
                        break;
                    case 6:
                        break;
                }
            }
        };
        m.run();
    }
    

}
