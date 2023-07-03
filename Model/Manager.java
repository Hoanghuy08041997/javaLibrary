package Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Manager extends People {
    
    protected ArrayList<Book> listBookManage;
    
    public Manager(int id, String name, String email, String phone, LocalDate birthday, int levelUser) {
        super(id, name, email, phone, birthday, levelUser);
    }
    
    
}
