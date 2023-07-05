package Controller;

import static Controller.ManagementLibrary.*;
import Model.Book;
import Model.BookBorrow;
import Model.Customer;
import View.Menu;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MethodController {

    //Method Backup Data
    public static void loadData() {
        account.addAll(IOReader.readFileAccount("./src/ListAccounts.txt"));
        customer.addAll(IOReader.readFileCustomer("./src/ListCustomer.txt"));
        book.addAll(IOReader.readFileBook("./src/ListBook.txt"));
        bookBorrow.addAll(IOReader.readFileBookBorrow("./src/ListBookBorrow.txt"));
        

    }
    
     public static void saveData(){
        IOReader.saveFileAccount(ManagementLibrary.account, "./src/ListAccounts.txt");
        IOReader.saveFileCustomer(ManagementLibrary.customer, "./src/ListCustomer.txt"); 
        IOReader.saveFileBookBorrow(ManagementLibrary.bookBorrow, "./src/ListBookBorrow.txt");
        
    }
    
    public static void exit() {
        IOReader.saveFileAccount(ManagementLibrary.account, "./src/ListAccounts.txt");
        IOReader.saveFileCustomer(ManagementLibrary.customer, "./src/ListCustomer.txt");
        IOReader.saveFileBookBorrow(ManagementLibrary.bookBorrow, "./src/ListBookBorrow.txt");
        System.exit(0);
    }

    //Method Account
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

    //Method of the Customer
    public static <E> void listAllBooks(String ms, List<E> ls) {
        System.out.println("------" + ms + "------");
        if (ls.isEmpty()) {
            System.out.println("Not found");
        } else {
            for (E l : ls) {
                System.out.println(l);
            }
        }
        System.out.println("------------------");
        System.out.println("Total : " + ls.size() + " Books");
    }

    public static List<Book> searchForBook(String searchCriteria, Object s) {
        List<Book> rs = new ArrayList<>();
        SearchPredicate<Book> p = new SearchPredicate<>(searchCriteria, s);
        for (Book b : ManagementLibrary.book) {
            if (p.test(b)) {
                rs.add(b);
            }
        }
        return rs;
    }

    //Search Book
    public static List<Integer> searchBook(String searchCriteria, String s) {
        List<Integer> matchingAccounts = new ArrayList<>();
        SearchPredicate<Book> searchCriteriaByProperties = new SearchPredicate<>(searchCriteria, s);
        for (Book b : ManagementLibrary.book) {
            if (searchCriteriaByProperties.test(b)) {
                matchingAccounts.add(b.getId());
            }
        }
        return matchingAccounts;
    }
     public static void searchBooks() {
        String tt = "Search Book";
        String[] ms = {"Search by Id",
            "Search by Name",
            "Search by Author",
            "Search by Type",
            "Exit"};
        Menu m = new Menu(tt, ms) {
            @Override
            public void execute(int n) {

                List<Book> bl = new ArrayList<>();
                switch (n) {
                    case 1:
                        int id = Validate.intUserInput("Enter ID:");
                        bl = searchForBook("Id", id);
                        listAllBooks("List Searched Book", bl);
                        break;
                    case 2:
                        String name = Validate.stringWithNumberUserInput("Enter Name:");
                        bl = searchForBook("Name", name);
                        listAllBooks("List Searched Book", bl);
                        break;
                    case 3:
                        String author = Validate.nameUserInput("Enter Author:");
                        bl = searchForBook("Author", author);
                        listAllBooks("List Searched Book", bl);
                        break;
                    case 4:
                        String type = chooseType();
                        bl = searchForBook("Type", type);
                        listAllBooks("List Searched Book", bl);
                        break;
                }
            }
        };
        m.run();
    }

    public static String chooseType() {
        String tt = "Type Menu";
        String[] ls = {
            "Science",
            "Comic",
            "Manga",
            "Novel",
            "Fiction",
            "Dictionary"
        };
        String type = null;
        Menu m = new Menu(tt, ls) {
            @Override
            public void execute(int n) {
            }
        };
        int k = m.getSelected();
        switch (k) {
            case 1:
                type = "Science";
                break;
            case 2:
                type = "Comic";
                break;
            case 3:
                type = "Manga";
                break;
            case 4:
                type = "Novel";
                break;
            case 5:
                type = "Fiction";
                break;
            case 6:
                type = "Dictionary";
                break;

        }
        return type;
    }

    
    public static void lendBooks() {
        Scanner sc = new Scanner(System.in);
        List<Book> bl = new ArrayList<Book>();
        int id;
        while (true) {
            id = Validate.intUserInput("Enter ID:");
            bl = searchForBook("Id", id);
            if (!bl.isEmpty()) {
                if (bl.get(0).getNumber() == 0) {
                    System.out.println("Number of book is Zero");

                } else {
                    for (BookBorrow bb : ManagementLibrary.bookBorrow) {
                        if (bb.getIdCustomer() == ManagementLibrary.logged.get(0).getId()) 
                            if (bb.getId() == bl.get(0).getId()){ 
                                System.out.println("You have borrowed this book!");
                                check = false;
                                break;
                            }
                        

                    }
                    if (check==true) {
                        System.out.println("Do you want to borrow?(y/n)");
                        String yn = sc.next().toLowerCase().trim();
                        if (yn.equals("y")) {
                            for (Book b : ManagementLibrary.book) {
                                if (b.getId() == id) {
                                    b.setNumber(b.getNumber() - 1);
                                    System.out.println(b.toString());
                                    BookBorrow bb = new BookBorrow(b.getId(), b.getName(), b.getAuthor(), b.getNumber(),b.getPrice(), ManagementLibrary.logged.get(0).getId(), LocalDate.now(),false);

                                    ManagementLibrary.bookBorrow.add(bb);
                                }
                            }
                            System.out.println("Borrow successfully");
                        }
                    }

                }
            }
            System.out.println("Do you want to continue(y/n)");
            String yn = sc.next().toLowerCase().trim();
            if (!(yn.equals("y"))) {
                break;
            }
        }
    }
    
    public static void returnBooks() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int id = Validate.intUserInput("Enter ID:");
            int count = 0;
            if (ManagementLibrary.bookBorrow.isEmpty()) {
                System.out.println("You do not borrow any book");
            } else {
                for (BookBorrow bb : ManagementLibrary.bookBorrow) {
                    if ((bb.getIdCustomer() == ManagementLibrary.logged.get(0).getId()) && (bb.getId() == id)) {
                        System.out.println(bb.toString());
                        count++;
                    }
                }
                if (count == 0) {
                    System.out.println("You do not borrow this book.");
                } else {
                    System.out.println("Do you want to return?(y/n)");
                    String yn = sc.next().toLowerCase().trim();
                    if (yn.equals("y")) {
                        for (BookBorrow bb : ManagementLibrary.bookBorrow) {
                            if ((bb.getIdCustomer() == ManagementLibrary.logged.get(0).getId()) && (bb.getId() == id)) {
                                if (LocalDate.now().isAfter(bb.getDateBorrow().plusDays(7))) System.out.println("You have returned book over deadline!");
                                ManagementLibrary.bookBorrow.remove(bb);
                                break;
                            }
                        }

                        for (Book b : ManagementLibrary.book) {
                            if (b.getId() == id) {
                                b.setNumber(b.getNumber() + 1);
                            }
                        }
                        System.out.println("Return successfully");
                    }
                }

            }
            System.out.println("Do you want to continue(y/n)");
            String yn = sc.next().toLowerCase().trim();
            if (!(yn.equals("y"))) {
                break;
            }
        }
    }
     public static void listLendingBook() {
        String ms = "List lending books";
        int count = 0;
        System.out.println("------" + ms + "------");
        for (BookBorrow bb : ManagementLibrary.bookBorrow) {
            if (bb.getIdCustomer() == ManagementLibrary.logged.get(0).getId()) {
                System.out.println(bb.toString());
                count++;
            }
        }
        System.out.println("----------------------");
        System.out.println("Total : " + count + " Books");
        //
    }
    //
}
