package gui;

import model.Book;
import model.Issue;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TablePanelBooks extends JPanel {
    private JTable table;
    private BookTableModel bookTableModel;

    public TablePanelBooks(){
        bookTableModel = new BookTableModel();
        table = new JTable(bookTableModel);
        table.setBackground(Color.lightGray);
        table.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.cyan));


        setLayout(new BorderLayout());
        add(table, BorderLayout.CENTER);
    }
    public void setData(List<Book> books){
        bookTableModel.setData(books);
    }

    public void refresh() {
        bookTableModel.fireTableDataChanged();
    }

    public void tableStructure(){
        bookTableModel.fireTableStructureChanged();
    }
}
