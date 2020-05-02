package gui;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    private JButton login;
    private JButton issues;
    private JButton books;
    private JButton students;

    public Login(){
        super("Log-in");
        BorderFactory.createEmptyBorder(10,10,10,10);
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        login = new JButton("Login");
        issues = new JButton("ISSUES");
        books = new JButton("BOOKS");
        students = new JButton("STUDENTS");
        issues.setPreferredSize(new Dimension(300,30));
        books.setPreferredSize(new Dimension(300,30));
        students.setPreferredSize(new Dimension(300,30));






        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.weighty = 0.05;
        gc.weightx = 1;

        gc.gridy = 0;
        gc.gridx = 0;
        add(issues, gc);

        ////next row////
        gc.gridy++;
        gc.gridx = 0;
        add(books, gc);

        ////next row////
        gc.gridy++;
        gc.gridx = 0;
        add(students, gc);

    }
}
