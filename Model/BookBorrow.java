package Model;

public class BookBorrow extends Book {
    protected int idBook;
    protected int idCustomer;
    protected int dateBorrow;
    
    

    public int getIdBook() {
        return idBook;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public int getDateBorrow() {
        return dateBorrow;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public void setDateBorrow(int dateBorrow) {
        this.dateBorrow = dateBorrow;
    }
    
    
    
}
