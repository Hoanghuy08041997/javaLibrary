package View;

import Controller.ManagementLibrary;
import Controller.MethodController;
import Model.Book;
import Model.BookBorrow;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class SearchBookUI extends JPanel {
    private final JTextField searchField;
    private final JComboBox<String> searchProperties;
    private final JTable bookTable;

    public SearchBookUI(int IdCustomer) {
        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        // Search properties
        String[] options = { "name", "author", "id" };

        searchProperties = new JComboBox<>(options);
        searchProperties.setPreferredSize(new Dimension(100, 25));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.insets = new Insets(5, 5, 5, 5);
        add(searchProperties, constraints);

        // Search field
        searchField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.weightx = 1.1;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.fill = GridBagConstraints.HORIZONTAL;
        add(searchField, constraints);

        // Search button
        JButton searchButton = new JButton("Search");
        searchButton.addActionListener((ActionEvent e) -> {
            String searchCriteria = searchField.getText();
            String selectedProperty = (String) searchProperties.getSelectedItem();
            List<Integer> searchResults = performSearch(selectedProperty, searchCriteria);
            updateBookList(searchResults);
        });
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.weightx = 0.0;
        constraints.insets = new Insets(5, 5, 5, 5);
        add(searchButton, constraints);

        // Book table
        bookTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(bookTable);
        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 3;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(5, 5, 5, 5);
        add(scrollPane, constraints);

        // Select button
        JButton selectButton = new JButton("Select");
        selectButton.addActionListener((ActionEvent e) -> {
            int selectedRow = bookTable.getSelectedRow();
            if (selectedRow != -1) {
                int bookId = (int) bookTable.getValueAt(selectedRow, 0);
                returnSelectedBookId(bookId,IdCustomer);
            }
        });
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.weightx = 1.0;
        constraints.weighty = 0.1;
        constraints.gridwidth = 3;
        constraints.insets = new Insets(5, 5, 5, 5);
        add(selectButton, constraints);
    }

    // Method to perform search based on given criteria
    private List<Integer> performSearch(String searchCriteria, String searchProperty) {
        List<Integer> matchingBooks = MethodController.searchBook(searchCriteria, searchProperty);
        return matchingBooks;
    }

    // Method to update the book list with search results as a table
    private void updateBookList(List<Integer> searchResults) {
        String[] columnNames = {"ID", "Name", "Author", "Total Book", "Price"};
        Object[][] data = new Object[searchResults.size()][5];
        
        for (int i = 0; i < searchResults.size(); i++) {
            for (Book book : ManagementLibrary.book)
                if (book.getId() == i){            
                    data[i][0] = book.getId(); // ID
                    data[i][1] = book.getName(); // Name
                    data[i][2] = book.getAuthor(); // Author
                    data[i][3] = book.getNumber(); // Total
                    data[i][4] = book.getPrice(); //Price
                }
        }

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
        bookTable.setModel(tableModel);
    }

    public static JPanel createPanel(int idCustomer) {
        return new SearchBookUI(idCustomer);
    }
    // Method to return the selected book ID
    public void returnSelectedBookId(int bookId, int idCustomer) {
        int confirmed = JOptionPane.showConfirmDialog(
            this,
            "Are you want to lend this book?",
            "Are you confirm?",
            JOptionPane.YES_NO_OPTION
        );

        if (confirmed == JOptionPane.YES_OPTION) {
            Book b1 = null;

            for (Book b : ManagementLibrary.book){
                if (b.getId() == bookId) {
                    b1 = b;
                    break;
                }
            }

            if (b1 != null) { // Kiểm tra xem b1 có khác null hay không
                ManagementLibrary.bookBorrow.add(new BookBorrow(bookId, b1.getName(), b1.getAuthor(), b1.getNumber(), b1.getPrice(), idCustomer, LocalDate.now(),false));
                JOptionPane.showMessageDialog(this, "Lending successful."); // Hiển thị thông báo mượn thành công
                ((Window) SwingUtilities.getRoot(this)).dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to lend this book.");
            }
        }
    }  
}
