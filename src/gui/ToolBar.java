package gui;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBar extends JPanel {
    private JToolBar toolBar;
    public JRadioButton issues;
    public JRadioButton books;
    public JRadioButton addStudent;
    public  ButtonGroup buttonGroup;

    private IssueForm issueForm;

    public ToolBar(){
        toolBar = new JToolBar();
        books = new JRadioButton("Books");
        issues = new JRadioButton("Issues");
        addStudent = new JRadioButton("Students");
        buttonGroup = new ButtonGroup();
        issueForm = new IssueForm();

        setBorder(new EtchedBorder());

        setLayout(new FlowLayout(FlowLayout.LEFT));

        buttonGroup.add(books);
        buttonGroup.add(issues);
        buttonGroup.add(addStudent);

        add(issues);
        add(books);
        add(addStudent);
        issues.setSelected(true);

        addStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (addStudent.isSelected()){
                    issueForm.setVisible(true);

                }else {
                    issueForm.setVisible(false);
                }
            }
        });

        issues.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (issues.isSelected()){
                    issueForm.setVisible(true);
                }else {
                    issueForm.setVisible(false);
                }
            }
        });
    }
}
