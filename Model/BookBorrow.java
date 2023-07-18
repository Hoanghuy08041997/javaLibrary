package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BookBorrow extends Book {
    protected int idCustomer;
    protected LocalDate dateBorrow;
    protected boolean status;

    public BookBorrow( int id, String name, String author,String type, int number,int price,int idCustomer, LocalDate dateBorrow, boolean status) {
        super(id, name, author,type, number, price);
        this.idCustomer = idCustomer;
        this.dateBorrow = dateBorrow;
        this.status = status;
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean dateReturn) {
        this.status= dateReturn;
    }

    
    
    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }
    

    @Override
    public String toString() {
        String print=String.format("%-7s%-30s%-20s%-30s%-30s%-30s","id=" + id , "name=" + name , "authoir=" + author ,"price=" + price,"dateBorrow="+dateBorrow.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),"Status="+status);
        return print;
    }

   
    
}