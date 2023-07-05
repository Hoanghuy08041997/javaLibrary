package Model;

public class Book {
    protected int id;
    protected String name;
    protected String author;
    protected int number;
    protected int price;

    public Book(int id, String name, String author, int number, int price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.number = number;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        String print=String.format("%-7s%-30s%-20s%-10s%-30s","id=" + id , "name=" + name , "authoir=" + author , "number=" + number , "price=" + price);
        return print;
    }

    
    
    public void setNumber(int number) {
        this.number = number;
    }
    
}