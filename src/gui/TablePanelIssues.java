package gui;

import model.Issue;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TablePanelIssues extends JPanel {

    private JTable table;
    private IssueTableModel issueTableModel;
    public TablePanelIssues(){
        issueTableModel = new IssueTableModel();
        table = new JTable(issueTableModel);
        table.setBackground(Color.lightGray);
        table.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.cyan));


        setLayout(new BorderLayout());

        add(table, BorderLayout.CENTER);
    }
    public void setData(List<Issue> issues){
        issueTableModel.setData(issues);
    }

    public void refresh() {
        issueTableModel.fireTableDataChanged();
    }

    public void tablestructure(){
        issueTableModel.fireTableStructureChanged();
    }
}
