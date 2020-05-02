package model;

public class Book {
    private String isnb;
    private String author;
    private String publisher;
    private String title;
    private String genre;

    public Book(String isnb, String author, String publisher, String title, String genre) {
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
}
