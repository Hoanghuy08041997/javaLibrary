package Controller;

import static Controller.ManagementLibrary.account;
import static Controller.ManagementLibrary.customer;
import static Controller.ManagementLibrary.book;
import static Controller.ManagementLibrary.bookBorrow;
import Model.Book;
import Model.BookBorrow;
import Model.Customer;
import View.Menu;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MethodController {

    //Method Backup Data
    public static void loadData() {
        account.addAll(IOReader.readFileAccount("./src/ListAccounts.txt"));
        customer.addAll(IOReader.readFileCustomer("./src/ListCustomer.txt"));
        book.addAll(IOReader.readFileBook("./src/ListBook.txt"));

    }
    
     public static void saveData(){
        IOReader.saveFileAccount(ManagementLibrary.account, "./src/ListAccounts.txt");
        IOReader.saveFileCustomer(ManagementLibrary.customer, "./src/ListCustomer.txt");  
    }
    
    public static void exit() {
        IOReader.saveFileAccount(ManagementLibrary.account, "./src/ListAccounts.txt");
        IOReader.saveFileCustomer(ManagementLibrary.customer, "./src/ListCustomer.txt");
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

    public static void searchBooks() {
        String tt = "Search Book";
        String[] ms = {"Search by Id",
            "Search by Name",
            "Search by Author",
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
                }
            }
        };
        m.run();
    }

    public static void lendBooks() {
        Scanner sc = new Scanner(System.in);
        List<Book> bl = new ArrayList<Book>();
        int id;
        while (true) {
            id = Validate.intUserInput("Enter ID:");
            bl = searchForBook("Id", id);
            if (bl.get(0).getNumber() == 0) {
                System.out.println("Number of book is Zero");
            } else {
                listAllBooks("List Searched Book", bl);

                if (!bl.isEmpty()) {

                    System.out.println("Do you want to borrow?(y/n)");
                    String yn = sc.next().toLowerCase().trim();
                    if (yn.equals("y")) {
                        for (Book b : ManagementLibrary.book) {
                            if (b.getId() == id) {
                                b.setNumber(b.getNumber() - 1);
                                BookBorrow bb = new BookBorrow(b.getId(), b.getName(), b.getAuthor(), b.getNumber(),b.getPrice(), LoginController.Acc.getId(), LocalDate.now(),LocalDate.now().plusDays(7));
                                ManagementLibrary.bookBorrow.add(bb);
                            }
                        }
                        System.out.println("Borrow successfully");
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
                    if ((bb.getIdCustomer() == LoginController.Acc.getId()) && (bb.getId() == id)) {
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
                            if ((bb.getIdCustomer() == LoginController.Acc.getId()) && (bb.getId() == id)) {
                                if(LocalDate.now().isAfter(bb.getDateBorrow())) System.out.println("You have returned book over deadline!");
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
    //
}
