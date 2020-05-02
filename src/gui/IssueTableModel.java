package gui;

import model.Issue;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class IssueTableModel extends AbstractTableModel {

    private List<Issue> db;
    //private String[] columnName = {"Issue Id","Issuer ID","Student ID","ISBN number","Issue Date","Return Date"};

    public IssueTableModel(){

    }

    @Override
    public void fireTableStructureChanged() {
        super.fireTableStructureChanged();
    }




    public void setData(List<Issue> db){
        this.db = db;
    }

    @Override
    public int getRowCount() {
        return db.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public Object getValueAt(int row, int col) {
        Issue issue = db.get(row);

        switch (col){
            case 0:
                return issue.getIssueId();
            case 1:
                return issue.getLiblarianId();
            case 2:
                return issue.getStudentId();
            case 3:
                return issue.getBookId();
            case 4:
                return issue.getIssueDate();
            case 5:
                return issue.getReturnDate();
            case 6:
                return new JCheckBox();
            case 7:
                return issue.getPenaltyID();
        }

        return null;
    }
}
