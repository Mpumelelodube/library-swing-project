package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IssueForm extends JPanel {
    private JLabel liblarianId;
    private JLabel studentId;
    private JLabel bookId;
    private JLabel issueDate;
    private JLabel returnDate;

    private JTextField liblarianIdField;
    private JTextField studentIdField;
    private JTextField bookIdField;
    private JTextField issueDateField;
    private JTextField returnDateField;

    private JButton okayButton;

    FormListener formListener;

    public IssueForm(){
        Dimension dimension = getPreferredSize();
        dimension.width = 400;
        setPreferredSize(dimension);
        setBackground(Color.LIGHT_GRAY);

        liblarianId = new JLabel("Issuer ID: ");
        studentId = new JLabel("Student ID: ");
        bookId = new JLabel("Book ID(ISBN#): ");
        issueDate = new JLabel("Issue Date: ");
        returnDate = new JLabel("Return Date: ");


        liblarianIdField = new JTextField(20);
        studentIdField = new JTextField(20);
        bookIdField = new JTextField(20);
        issueDateField = new JTextField("DD/MM/YY",20);
        returnDateField = new JTextField("DD/MM/YY",20);

        liblarianIdField.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.cyan));
        studentIdField.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.cyan));
        bookIdField.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.cyan));
        issueDateField.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.cyan));
        returnDateField.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.cyan));

        okayButton = new JButton("OK");
        okayButton.setBackground(Color.cyan);

        okayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String libId = liblarianIdField.getText();
                String studID = studentIdField.getText();
                String bokID = bookIdField.getText();
                String issDate = issueDateField.getText();
                String retDate = returnDateField.getText();

                System.out.println(studID+" "+studID);

                IssueFormEvent event = new IssueFormEvent(this,libId,studID,bokID,issDate,retDate);

                if (event!=null){
                    formListener.formEventOccured(event);
                }

            }
        });







        Border innerBorder = BorderFactory.createTitledBorder("New Issue");
        Border outtaBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outtaBorder,innerBorder));

        layoutComponents();
    }
    public void layoutComponents(){
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.weighty = 0.05;
        gc.weightx = 1;

        gc.gridy = 0;
        gc.gridx = 0;
        add(liblarianId, gc);

        gc.gridx = 1;
        add(liblarianIdField, gc);

        /////next row //////
        gc.weighty = 0.05;

        gc.gridy++;
        gc.gridx = 0;
        //gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(studentId, gc);

        gc.gridx = 1;
        add(studentIdField, gc);

        /////next row //////
        gc.weighty = 0.05;

        gc.gridy++;
        gc.gridx = 0;
        //gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(bookId, gc);

        gc.gridx = 1;
        add(bookIdField, gc);

        /////next row //////
        gc.gridy++;
        gc.gridx = 0;
        //gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(issueDate, gc);

        gc.gridx = 1;
        add(issueDateField, gc);

        /////next row //////
        gc.gridy++;
        gc.gridx = 0;
        //gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(returnDate, gc);

        gc.gridx = 1;
        add(returnDateField, gc);

        /////next row //////
        gc.weighty = 0.5;
        gc.gridy++;

        gc.gridx = 1;
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(okayButton, gc);

    }
    public void setFormListener(FormListener listener){
        this.formListener = listener;

    }
}
