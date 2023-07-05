package View;

import Controller.ManagementLibrary;
import Model.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginInfoUI extends JFrame {
    private final JLabel usernameLabel;
    private final JButton showInfo;
    private final JButton logoutButton;

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

        showInfo = new JButton("Show Info");
        infoPanel.add(showInfo);

        logoutButton = new JButton("Logout");
        infoPanel.add(logoutButton);

        mainPanel.add(infoPanel, BorderLayout.CENTER);

        add(mainPanel);

        showInfo.addActionListener((ActionEvent e) -> {
            StringBuilder info = new StringBuilder();
            for (Customer account : ManagementLibrary.logged) {
                info.append("Your id: ").append(account.getId()).append("\n");
                info.append("Username: ").append(account.getName()).append("\n");
                info.append("Email: ").append(account.getEmail()).append("\n");
                info.append("Phone: ").append(account.getPhone()).append("\n");
                info.append("Birth: ").append(account.getBirthday()).append("\n");
                info.append("\n");
            }
            JTextArea textArea = new JTextArea(info.toString());
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(300, 200));

            JButton closeButton = new JButton("Close");
            closeButton.addActionListener((ActionEvent event) -> {
                Window window = SwingUtilities.getWindowAncestor(closeButton);
                if (window != null) {
                    window.dispose();
                }
            });

            JPanel panel = new JPanel(new BorderLayout());
            panel.add(scrollPane, BorderLayout.CENTER);
            panel.add(closeButton, BorderLayout.SOUTH);

            JDialog dialog = new JDialog(LoginInfoUI.this, "Logged Information", true);
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            dialog.getContentPane().add(panel);
            dialog.pack();
            dialog.setLocationRelativeTo(LoginInfoUI.this);
            dialog.setVisible(true);
        });


        logoutButton.addActionListener((ActionEvent e) -> {
            // Đóng tất cả các cửa sổ đằng sau
            Window[] windows = Window.getWindows();
            for (Window window : windows) {
                if (window != null && window != LoginInfoUI.this) {
                    window.dispose();
                }
            }

            LoginSwingUI loginSwingUI = new LoginSwingUI();
            loginSwingUI.setVisible(true);
            dispose();
        });
    }
}
