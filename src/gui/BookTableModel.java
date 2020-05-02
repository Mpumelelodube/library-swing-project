package gui;

import model.Book;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class BookTableModel extends AbstractTableModel {
    private List<Book> db;
    private String colName[] = {"ISBN #","Author","Publisher","Title","Genre"};

    public BookTableModel(){

    }

    public void setData(List<Book> db){
        this.db = db;
    }

    @Override
    public String getColumnName(int column) {
        return colName[column];
    }

    @Override
    public int getRowCount() {
        return db.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Book book = db.get(row);

        switch (col){
            case 0:
                return book.getIsnb();
            case 1:
                return book.getAuthor();
            case 2:
                return book.getPublisher();
            case 3:
                return book.getTitle();
            case 4:
                return book.getGenre();
        }
        return null;
    }
}
