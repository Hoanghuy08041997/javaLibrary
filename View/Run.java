package View;

import Controller.LoginController;
import Controller.ManagementLibrary;

public class Run {
    public static void main(String[] args) {
        ManagementLibrary.loadData();
        LoginController.LoginVerify();
    }
    
}
