package View;

import Controller.LoginController;
import Controller.MethodController;

public class Run {
    public static void main(String[] args) {
        MethodController.loadData();
        LoginController.LoginVerify();
    }
    
}
