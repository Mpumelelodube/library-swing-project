package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Database {
    private ArrayList<Issue> issues;
    private ArrayList<Book> books;

    public Database() {
        issues = new ArrayList<Issue>();
        books = new ArrayList<Book>();
    }

    public void addIssue(Issue issue){
        issues.add(issue);
    }

    public List<Issue> getIssue() {
        return issues;
    }
    public void addBook(Book book){
        books.add(book);
    }
    public List<Book> getBook(){
        return books;
    }
    public void saveToFile(File file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        Issue[] issueSave = issues.toArray(new Issue[issues.size()]);

        oos.writeObject(issueSave);

        fos.close();
    }
    public void loadFromFile(File file) throws IOException{
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);

        try {
            Issue[] issueLoad = (Issue[]) ois.readObject();

            issues.clear();

            issues.addAll(Arrays.asList(issueLoad));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        fis.close();
    }
}
