package Model;

import Controller.ManagementLibrary;
import java.time.LocalDate;

public class Customer extends People {

    public Customer(int id, String name, String email, String phone, LocalDate birthday, int levelUser) {
        super(id, name, email, phone, birthday, levelUser);      
    }    
    
    

    @Override
    public String toString() {
        return "Account [" + " || ID=" + id  + " || Username= " + name + " ||  Email=" + email + "  || Phone=" + phone + "  || Birthday=" + birthday + "  || Level=" + levelUser + ']';
    }  
    

}
