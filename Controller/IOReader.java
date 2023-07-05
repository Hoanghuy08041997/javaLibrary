package Controller;

import Model.Account;
import Model.Book;
import Model.BookBorrow;
import Model.Customer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class IOReader {

    //IO Account
    public static boolean saveFileAccount(ArrayList<Account> stdList, String path) {
        try {
            try (FileOutputStream fos = new FileOutputStream(path); OutputStreamWriter osw = new OutputStreamWriter(fos); BufferedWriter bw = new BufferedWriter(osw)) {
                for (Account t : stdList) {
                    String line = t.getUsername() + "," + t.getPassword() + "," + t.getLevel() + "," + t.getId();
                    bw.write(line);
                    bw.newLine();
                }
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
    public static ArrayList<Account> readFileAccount(String path) {
        ArrayList<Account> stdList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(path); InputStreamReader isr = new InputStreamReader(fis); BufferedReader br = new BufferedReader(isr)) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");

                if (fields.length == 4) { // Kiểm tra số lượng trường thông tin  
                    boolean hasNull = false;
                    for (String field : fields) {
                        if (field.trim().isEmpty()) {
                            hasNull = true;
                            break;
                        }
                    }

                    if (!hasNull) {
                        String us = fields[0].trim();
                        String pd = fields[1].trim();
                        int id = Integer.parseInt(fields[2].trim());
                        int level = Integer.parseInt(fields[3].trim());
                        Account account = new Account(us, pd, id, level);
                        stdList.add(account);
                    }
                } else {
                    System.out.println("Invalid number of fields: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return stdList;
    }

    //IO Customer
    public static boolean saveFileCustomer(ArrayList<Customer> stdList, String path) {
        try {
            try (FileOutputStream fos = new FileOutputStream(path); OutputStreamWriter osw = new OutputStreamWriter(fos); BufferedWriter bw = new BufferedWriter(osw)) {
                for (Customer t : stdList) {
                    String line = t.getId() + "," + t.getName() + "," + t.getEmail() + "," + t.getPhone() + "," + t.getBirthday() + "," + t.getLevelUser();
                    bw.write(line);
                    bw.newLine();
                }
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
    public static ArrayList<Customer> readFileCustomer(String path) {
        ArrayList<Customer> customerList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(path); InputStreamReader isr = new InputStreamReader(fis); BufferedReader br = new BufferedReader(isr)) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");

                if (fields.length == 6) { // Check the number of fields
                    boolean hasNull = false;
                    for (String field : fields) {
                        if (field.trim().isEmpty()) {
                            hasNull = true;
                            break;
                        }
                    }

                    if (!hasNull) {
                        int id = Integer.parseInt(fields[0].trim());
                        String name = fields[1].trim();
                        String email = fields[2].trim();
                        String phone = fields[3].trim();
                        LocalDate date = Validate.parseDate(fields[4].trim());
                        int level = Integer.parseInt(fields[5].trim());
                        customerList.add(new Customer(id, name, email, phone, date, level));
                    }
                } else {
                    System.out.println("Invalid number of fields: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return customerList;
    }

    //IO Book
    public static ArrayList<Book> readFileBook(String path) {
        ArrayList<Book> bookList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(path); InputStreamReader isr = new InputStreamReader(fis); BufferedReader br = new BufferedReader(isr)) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");

                if (fields.length == 5) { // Check the number of fields
                    boolean hasNull = false;
                    for (String field : fields) {
                        if (field.trim().isEmpty()) {
                            hasNull = true;
                            break;
                        }
                    }

                    if (!hasNull) {
                        int id = Integer.parseInt(fields[0].trim());
                        String name = fields[1].trim();
                        String author = fields[2].trim();
                        int number = Integer.parseInt(fields[3].trim());
                        int price = Integer.parseInt(fields[4].trim());
                        bookList.add(new Book(id, name, author, number, price));
                    } else {
                        System.out.println("Invalid number of fields: " + line);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return bookList;
    }
    public static boolean saveFileBook(ArrayList<Book> stdList, String path) {
        try {
            try (FileOutputStream fos = new FileOutputStream(path); OutputStreamWriter osw = new OutputStreamWriter(fos); BufferedWriter bw = new BufferedWriter(osw)) {
                for (Book t : stdList) {
                    String line = t.getId() + "," + t.getName() + "," + t.getAuthor() + "," + t.getType() + "," + t.getNumber() + "," + t.getPrice();
                    bw.write(line);
                    bw.newLine();
                }
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
    //IO BorrowBook
    public static boolean saveFileBookBorrow(ArrayList<BookBorrow> stdList, String path) {
        try {
            try (FileOutputStream fos = new FileOutputStream(path); OutputStreamWriter osw = new OutputStreamWriter(fos); BufferedWriter bw = new BufferedWriter(osw)) {
                for (BookBorrow t : stdList) {
                    String line = t.getId() + "," + t.getName() + "," + t.getAuthor() + "," + t.getNumber() + "," + t.getPrice() + "," + t.getIdCustomer() + "," + t.getDateBorrow() + "," + t.getStatus();
                    bw.write(line);
                    bw.newLine();
                }
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return false;
    }
    public static ArrayList<BookBorrow> readFileBookBorrow(String path) {
        ArrayList<BookBorrow> bb = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(path);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");

                if (fields.length == 8) { // Check the number of fields
                    try {
                        int id = Integer.parseInt(fields[0].trim());
                        String name = fields[1].trim();
                        String author = fields[2].trim();
                        int number = Integer.parseInt(fields[3].trim());
                        int price = Integer.parseInt(fields[4].trim());
                        int idc = Integer.parseInt(fields[5].trim());
                        LocalDate date = Validate.parseDate(fields[6].trim());
                        boolean status = Boolean.parseBoolean(fields[7].trim()); // Use Boolean.parseBoolean to parse boolean value directly
                        bb.add(new BookBorrow(id, name, author, number, price, idc, date, status));
                    } catch (NumberFormatException e) {
                        System.out.println("Error parsing numeric values: " + line);
                    } catch (DateTimeParseException e) {
                        System.out.println("Error parsing date: " + line);
                    }
                } else {
                    System.out.println("Invalid number of fields: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return bb;
    }
}
