package Model;

import java.time.LocalDate;

public class Customer extends People {

    public Customer(int id, String name, String email, String phone, String phone1, LocalDate birthday, int levelUser) {
        super(id, name, email, phone, birthday, levelUser);      
    }    
}
