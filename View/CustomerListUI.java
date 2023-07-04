package View;

import Model.Customer;
import java.util.ArrayList;
import javax.swing.*;

public class CustomerListUI extends JPanel {
    public CustomerListUI(ArrayList<Customer> customers) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        for (Customer customer : customers) {
            JLabel label = new JLabel(String.valueOf(customer));
            add(label);
        }
    }
}
