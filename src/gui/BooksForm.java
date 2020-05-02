package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BooksForm extends JPanel {
    FormListenerBook formListener;

    private JLabel addBook;
    private JLabel isbn;
    private  JLabel title;
    private  JLabel author;
    private JLabel publisher;
    private JLabel genre;

    private JTextField isbnField;
    private JTextField titleField;
    private JTextField authorField;
    private  JTextField publisherField;
    private JTextField genreField;

    private  JButton okayButton;

    public BooksForm(){
        Dimension dimension = getPreferredSize();
        dimension.width = 400;
        setPreferredSize(dimension);
        setBackground(Color.lightGray);

        addBook = new JLabel("------Add Book------");
        isbn = new JLabel("ISBN Number; ");
        title = new JLabel("Title");
        author = new JLabel("Author");
        publisher = new JLabel("Publisher");
        genre = new JLabel("Genre ID");


        isbnField = new JTextField(20);
        titleField = new JTextField(20);
        authorField = new JTextField(20);
        publisherField = new JTextField(20);
        genreField = new JTextField(20);

        isbnField.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.cyan));
        titleField.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.cyan));
        authorField.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.cyan));
        publisherField.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.cyan));
        genreField.setBorder(BorderFactory.createMatteBorder(2,2,2,2,Color.cyan));

        okayButton = new JButton("OK");
        okayButton.setBackground(Color.cyan);

        okayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String isbn = isbnField.getText();
                String title = titleField.getText();
                String author = authorField.getText();
                String publisher = publisherField.getText();
                String genre = genreField.getText();

                BookFormEvent event = new BookFormEvent(this,isbn,author,publisher,title,genre);
                if (event!=null){
                    formListener.formEventOccured(event);
                }
            }
        });

        Border innerBorder = BorderFactory.createTitledBorder("Books");
        Border outtaBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outtaBorder,innerBorder));

        layoutComponents();
    }

    private void layoutComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints gC = new GridBagConstraints();

        gC.weighty = 0.05;
        gC.weightx = 1;

        gC.gridy = 0;
        gC.gridx = 0;
        add(addBook, gC);

        /////next row ///////

        gC.gridy++;
        gC.gridx = 0;
        add(isbn, gC);

        gC.gridx = 1;
        add(isbnField, gC);

        //////next row ////
        gC.gridy++;
        gC.gridx = 0;
        add(title, gC);

        gC.gridx = 1;
        add(titleField, gC);

        //////next row ////
        gC.gridy++;
        gC.gridx = 0;
        add(author, gC);

        gC.gridx = 1;
        add(authorField, gC);

        //////next row ////
        gC.gridy++;
        gC.gridx = 0;
        add(publisher, gC);

        gC.gridx = 1;
        add(publisherField, gC);

        //////next row ////
        gC.gridy++;
        gC.gridx = 0;
        add(genre, gC);

        gC.gridx = 1;
        add(genreField, gC);

        //////next row ////
        gC.weighty = 1;

        gC.gridy++;


        gC.gridx = 1;
        gC.anchor = GridBagConstraints.FIRST_LINE_START;
        add(okayButton, gC);

    }

    public void setFormListener(FormListenerBook listener) {
        this.formListener = listener;
    }
}
