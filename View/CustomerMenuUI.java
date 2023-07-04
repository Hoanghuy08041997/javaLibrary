package View;

import Controller.MethodController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public final class CustomerMenuUI extends JFrame {
    private JSplitPane splitPane;
    private JPanel functionPanel;
    private JPanel contentPanel;
    private JButton listBooksButton;
    private JButton searchBookButton;
    private JButton lendBookButton;
    private JButton returnBookButton;
    private JButton listLendingBooksButton;
    private JButton exitButton;

    public CustomerMenuUI() {
        setTitle("Customer Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000, 750));
        run();
    }

    private void initializeUI() {
        
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerSize(5);

        functionPanel = new JPanel();
        functionPanel.setLayout(new GridLayout(8, 1));
        splitPane.setLeftComponent(functionPanel);

        contentPanel = new JPanel(new GridBagLayout());
        
        // List books button
        listBooksButton = new JButton("1. List all books");
        listBooksButton.addActionListener((ActionEvent e) -> {
            System.out.println("Hello1");
        });
        functionPanel.add(listBooksButton);

        // List customers button
        searchBookButton = new JButton("2. Search Book");
        searchBookButton.addActionListener((ActionEvent e) -> {
                contentPanel.removeAll();
                
                contentPanel.revalidate();
                contentPanel.repaint();
        });
        functionPanel.add(searchBookButton);

        lendBookButton = new JButton("3. Lend book");
        lendBookButton.addActionListener((ActionEvent e) -> {

        });
        functionPanel.add(lendBookButton);

        returnBookButton = new JButton("4. Return Book");
        returnBookButton.addActionListener((ActionEvent e) -> {
            System.out.println("Hello4");
        });
        functionPanel.add(returnBookButton);

        listLendingBooksButton = new JButton("5. List Lending Book");
        listLendingBooksButton.addActionListener((ActionEvent e) -> {
            
        });
        functionPanel.add(listLendingBooksButton);

        listLendingBooksButton = new JButton("6. Exit");
        listLendingBooksButton.addActionListener((ActionEvent e) -> {
            MethodController.exit();
        });
        functionPanel.add(listLendingBooksButton);
        
        splitPane.setRightComponent(new JScrollPane(contentPanel)); // Sử dụng JScrollPane để cuộn nếu nội dung quá lớn

        setContentPane(splitPane);
        setResizable(false); // Lock user resizing
    }

    public void run() {
        initializeUI();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
