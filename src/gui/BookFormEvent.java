package gui;

import java.util.EventObject;

public class BookFormEvent extends EventObject {
    private String isnb;
    private String author;
    private String publisher;
    private String title;
    private String genre;

    public BookFormEvent(Object source) {
        super(source);
    }

    public BookFormEvent(Object source, String isnb, String author, String publisher, String title, String genre) {
        super(source);
        this.isnb = isnb;
        this.author = author;
        this.publisher = publisher;
        this.title = title;
        this.genre = genre;
    }

    public String getIsnb() {
        return isnb;
    }

    public void setIsnb(String isnb) {
        this.isnb = isnb;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    //public abstract void formEventOccured(BookFormEvent event);
}
