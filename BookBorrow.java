package Model;

import java.time.LocalDate;

public class BookBorrow extends Book {
    protected int idCustomer;
    protected LocalDate dateBorrow;
    protected LocalDate dateReturn;

    public BookBorrow( int id, String name, String author, int number,int price,int idCustomer, LocalDate dateBorrow, LocalDate dateReturn) {
        super(id, name, author, number, price);
        this.idCustomer = idCustomer;
        this.dateBorrow = dateBorrow;
        this.dateReturn = dateReturn;
    }

   

    public LocalDate getDateBorrow() {
        return dateBorrow;
    }

    public void setDateBorrow(LocalDate dateBorrow) {
        this.dateBorrow = dateBorrow;
    }

    

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Override
    public String toString() {
        String print=String.format("%-7s%-30s%-20s%-30s%-30s%-30s","id=" + id , "name=" + name , "authoir=" + author ,"price=" + price,"dateBorrow"+dateBorrow,"dateReturn"+dateReturn);
        return print;
    }

   
    
}
