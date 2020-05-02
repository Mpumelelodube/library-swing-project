package gui;

import controler.Controller;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import static java.awt.event.KeyEvent.VK_I;
import static java.awt.event.KeyEvent.getExtendedKeyCodeForChar;

public class MainFrame extends JFrame {
    private ToolBar toolBar;
    private IssueForm issueForm;
    private BooksForm booksForm;
    private Controller controller;
    private TablePanelIssues tablePanelIssues;
    private TablePanelBooks tablePanelBooks;
    private JFileChooser fileChooser;
    private JTabbedPane tabbedPane;

    public MainFrame(){
        super("LIBRARY");

        setSize(1366,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getBaselineResizeBehavior();

        setLayout(new BorderLayout());
        setJMenuBar(createMenu());

        toolBar = new ToolBar();
        issueForm = new IssueForm();
        booksForm = new BooksForm();
        controller = new Controller();
        tablePanelIssues = new TablePanelIssues();
        tablePanelBooks = new TablePanelBooks();

        fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new FileFilter());

        tabbedPane = new JTabbedPane();

        tablePanelIssues.setData(controller.getIssues());
        tablePanelBooks.setData(controller.getBooks());

        //issueForm.setVisible(false);
        //booksForm.setVisible(false);


        //toolBar.buttonGroup.getSelection();
        /*toolBar.issues.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {



                if (toolBar.issues.isSelected()){
                    remove(booksForm);
                    remove(tablePanelBooks);
                    add(issueForm, BorderLayout.WEST);
                    add(new JScrollPane(tablePanelIssues), BorderLayout.CENTER);
                    tablePanelIssues.refresh();
                    booksForm.setVisible(false);

                    issueForm.setVisible(true);

                    System.out.println("issues selected");
                }
            }
        });

        toolBar.books.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (toolBar.books.isSelected()){
                    remove(issueForm);
                    remove(tablePanelIssues);
                    add(booksForm, BorderLayout.WEST);
                    add(new JScrollPane(tablePanelBooks), BorderLayout.CENTER);
                    issueForm.setVisible(false);

                    booksForm.setVisible(true);

                    System.out.println("books selected");

                }
            }
        });*/

        issueForm.setFormListener(new FormListener() {
            @Override
            public void formEventOccured(IssueFormEvent event) {
                controller.addIssue(event);
                tablePanelIssues.refresh();
                System.out.println("issssss");
            }
        });

        booksForm.setFormListener(new FormListenerBook() {
            @Override
            public void formEventOccured(BookFormEvent event) {
                controller.addBook(event);
                tablePanelBooks.refresh();
                System.out.println("booool");
            }
        });

        //add(toolBar, BorderLayout.NORTH);
        tabbedPane.setBackground(Color.CYAN);



        tabbedPane.addTab("issues",issueForm);
        tabbedPane.addTab("Books", booksForm);
        tabbedPane.addTab("Students", new JLabel("students"));
        add(tabbedPane, BorderLayout.WEST);
        add(new JScrollPane(tablePanelIssues),BorderLayout.CENTER);


        //tabbedPane.setSelectedComponent(issueForm);
        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                if (tabbedPane.getSelectedComponent().equals(issueForm)){
                    remove(tablePanelBooks);
                    System.out.println("issue");
                    add(new JScrollPane(tablePanelIssues),BorderLayout.CENTER);
                    tablePanelIssues.refresh();
                }
                if (tabbedPane.getSelectedComponent().equals(booksForm)){
                    remove(tablePanelIssues);
                    System.out.println("book");
                    add(new JScrollPane(tablePanelBooks),BorderLayout.CENTER);
                    tablePanelBooks.refresh();
                }
            }
        });





    }
    private JMenuBar createMenu(){
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu =new  JMenu("File");

        JMenuItem importData = new JMenuItem("Import Data...");
        JMenuItem exportData = new JMenuItem("Export Data...");
        JMenuItem exit = new JMenuItem("Exit");

        fileMenu.add(importData);
        fileMenu.add(exportData);
        fileMenu.add(exit);

        JMenu help = new JMenu("Help");

        JMenuItem getHelp = new JMenuItem("Get Help");
        help.add(getHelp);

        importData.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK));
        exportData.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_DOWN_MASK));

        importData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (fileChooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){
                    try {
                        controller.loadFromFile(fileChooser.getSelectedFile());
                        tablePanelIssues.refresh();
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(MainFrame.this,"could not load from file","Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        exportData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (fileChooser.showSaveDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){
                    try {
                        controller.saveToFile(fileChooser.getSelectedFile());
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(MainFrame.this,"could not save to file","Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int selection =  JOptionPane.showConfirmDialog(MainFrame.this,"are you sure you want to exit");
                if (selection == JOptionPane.OK_OPTION){
                    System.exit(0);
                }
            }
        });

        JMenu show = new JMenu("View");
        JMenuItem showtab = new JMenuItem("Show Tab");

        JCheckBox checkBox = new JCheckBox("Show Tab");

        showtab.add(checkBox);

        show.add(showtab);
        checkBox.setSelected(true);
        /*checkBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!checkBox.isSelected()){
                    tabbedPane.setVisible(false);

                    if (tabbedPane.getSelectedComponent().equals(issueForm)){
                        tablePanelIssues.tablestructure();
                    }
                    //tablePanelBooks.tableStructure();

                }
                if (checkBox.isSelected()){
                    tabbedPane.setVisible(true);
                    //tablePanelBooks.tableStructure();
                    //tablePanelIssues.tablestructure();
                }
            }
        });*/

        menuBar.add(fileMenu);
        menuBar.add(help);
        menuBar.add(show);


        return menuBar;
    }
}
