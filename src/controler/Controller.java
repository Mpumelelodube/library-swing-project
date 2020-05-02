package controler;

import gui.BookFormEvent;
import gui.IssueFormEvent;
import model.Book;
import model.Database;
import model.Issue;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Controller {
    Database database = new Database();

    public List<Issue> getIssues(){
        return database.getIssue();
    }
    public List<Book> getBooks(){
        return database.getBook();
    }

    public void addIssue(IssueFormEvent event){
        String issuerId = event.getIssuerId();
        String studentId = event.getStudentId();
        String isbn = event.getIsbn();
        String issueDate = event.getIssueDate();
        String returnDate = event.getReturnDate();

        Issue issue = new Issue(issuerId, studentId,isbn,issueDate,returnDate);

        database.addIssue(issue);
    }
    public void addBook(BookFormEvent event){
         String isnb = event.getIsnb();
         String author = event.getAuthor();
         String publisher = event.getPublisher();
         String title = event.getTitle();
         String genre = event.getGenre();

         Book book = new Book(isnb,author,publisher,title,genre);

         database.addBook(book);

    }
    public  void saveToFile(File file) throws IOException{
        database.saveToFile(file);
    }
    public void loadFromFile(File file) throws IOException{
        database.loadFromFile(file);
    }
}
