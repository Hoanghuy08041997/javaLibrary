/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.Menu;

/**
 *
 * @author Hoang
 */
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
                        listAllBooks();
                        break;
                    case 2:
                        searchBooks();
                        break;
                    case 3:
                        lendBooks();
                        break;
                    case 4:
                        returnBooks();
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
    
    public static void listAllBooks(){
        
}
    public static void searchBooks(){
        
    }
    
    public static void lendBooks(){
        
    } 
    
    public static void returnBooks(){
        
    }
    
    public static void listLendingBooks(){
        
    }
}
