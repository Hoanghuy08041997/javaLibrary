package Model;

import java.time.LocalDate;

public class People {
    protected int id;
    protected String name;
    protected String email;
    protected String phone;
    protected LocalDate birthday;
    protected int levelUser;

    public People(int id, String name, String email, String phone, LocalDate birthday, int levelUser) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.levelUser = levelUser;
    }
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public int getLevelUser() {
        return levelUser;
    }

    
    //
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBirthday(LocalDate DateOfBirth) {
        this.birthday = DateOfBirth;
    }

    public void setLevelUser(int levelUser) {
        this.levelUser = levelUser;
    }
       

    @Override
    public String toString() {
        return "People{" + "id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", DateOfBirth=" + birthday + '}';
    }
}
