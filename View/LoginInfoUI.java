package View;

import Controller.ManagementLibrary;
import Model.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginInfoUI extends JFrame {
    private final JLabel usernameLabel;

    public LoginInfoUI() {
        setTitle("Login Information");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        usernameLabel = new JLabel("Logged in as: " + ManagementLibrary.logged.get(0).getName());
        infoPanel.add(usernameLabel);

        mainPanel.add(infoPanel, BorderLayout.CENTER);

        add(mainPanel);

        JButton yourAccountButton = new JButton("Your Account");

        JPopupMenu popupMenu = createPopupMenu();

        yourAccountButton.addActionListener((ActionEvent e) -> {
            popupMenu.show(yourAccountButton, 0, yourAccountButton.getHeight());
        });

        infoPanel.add(yourAccountButton);
    }

    private JPopupMenu createPopupMenu() {
        JPopupMenu popupMenu = new JPopupMenu();

        JMenuItem showInfoMenuItem = new JMenuItem("Show Info");
        showInfoMenuItem.addActionListener((ActionEvent e) -> {
            showInfo();
        });

        JMenuItem logoutMenuItem = new JMenuItem("Logout");
        logoutMenuItem.addActionListener((ActionEvent e) -> {
            logout();
        });

        popupMenu.add(showInfoMenuItem);
        popupMenu.add(logoutMenuItem);

        return popupMenu;
    }

    public void showInfo() {
        StringBuilder info = new StringBuilder();
        for (Customer account : ManagementLibrary.logged) {
            info.append("Your id: ").append(account.getId()).append("\n");
            info.append("Username: ").append(account.getName()).append("\n");
            info.append("Email: ").append(account.getEmail()).append("\n");
            info.append("Phone").append(account.getPhone()).append("\n");
            info.append("Birth").append(account.getBirthday()).append("\n");
            info.append("\n");
        }
        JOptionPane.showMessageDialog(this, info.toString(), "Logged Information", JOptionPane.INFORMATION_MESSAGE);
    }

    public void logout() {
        // Đóng tất cả các cửa sổ đằng sau
        Window[] windows = Window.getWindows();
        for (Window window : windows) {
            if (window != null && window != this) {
                window.dispose();
            }
        }

        LoginSwingUI loginSwingUI = new LoginSwingUI();
        loginSwingUI.setVisible(true);
        dispose();
    }
}
