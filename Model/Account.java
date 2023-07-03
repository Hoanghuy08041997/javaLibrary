package Model;

import Controller.IOReader;
import Controller.ManagementLibrary;
import java.util.ArrayList;

public class Account {
    private String username;
    private String password;
    private int level;
    private int id;
    
    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account(String username, String password, int level, int id) {
        this.username = username;
        this.password = password;
        this.level = level;
        this.id = id;
    }
    
    

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getLevel() {
        return level;
    }

    public int getId() {
        return id;
    }

    protected void setUsername(String username) {
        this.username = username;
    }

    protected void setPassword(String password) {
        this.password = password;
    }

    protected void setLevel(int level) {
        this.level = level;
    }

    protected void setId(int id) {
        this.id = id;
    }
    
    public static int checkAccount(Account s) {

        for (Account c : ManagementLibrary.account) {
            if (c.getUsername().equals(s.getUsername()) && c.getPassword().equals(s.getPassword())) {
                return c.getLevel();
            }
        }
        return 0;
    }   
    
    
}   

