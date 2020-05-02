package gui;

import javax.swing.*;
import java.awt.*;

public class FormPluspanel_Isuues extends  JPanel{
    private TablePanelIssues tablePanelIssues;

    public FormPluspanel_Isuues(){

        tablePanelIssues = new TablePanelIssues();
        setBackground(Color.lightGray);
        setLayout(new BorderLayout());

        setBorder(BorderFactory.createMatteBorder(5,5,5,5,Color.cyan));



        add(new BooksForm(),BorderLayout.WEST );
        add(new JScrollPane(tablePanelIssues),BorderLayout.CENTER);
    }
}
