package View;

import Controller.Validate;
import java.util.ArrayList;

public abstract class Menu<T> {
    protected String title;
    protected ArrayList<T> mChon;

    public Menu() {
    }
    
    public Menu(String td, String[] mc){
       title = td;
       mChon = new ArrayList<>();
       for (String s:mc) mChon.add((T) s);
    }
    
    public void display(){
        System.out.println(title);
        System.out.println("---------------------------------------");
        for (int i = 0; i <mChon.size(); i++) {
            System.out.println((i+1) + ". " + mChon.get(i));
        }
        System.out.println("----------------------------------------");
    };   
    
    public int getSelected(){
        display();
        System.out.println("Enter your option: ");
        int n = Validate.menuOptionUserInput(mChon.size());
        return n;
    }
    public abstract void execute(int i);
    
    public void run(){
        while (true){
        int k = getSelected();
        execute(k); 
        }
    }
}

