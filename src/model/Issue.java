package model;


import java.io.Serializable;

public class Issue implements Serializable {
    public  int issueId;
    private String liblarianId;
    private String studentId;
    private String bookId;
    private String issueDate;
    private String returnDate;
    private static int count = 0;
    private String penalty;
    private String penaltyID;

    public Issue(String liblarianId, String studentId, String bookId, String issueDate, String returnDate) {
        this.liblarianId = liblarianId;
        this.studentId = studentId;
        this.bookId = bookId;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        issueId = count;
        count++;

        penalty = "lost";
        penaltyID = "p-0001";
    }

    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    public String getLiblarianId() {
        return liblarianId;
    }

    public void setLiblarianId(String liblarianId) {
        this.liblarianId = liblarianId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getPenalty() {
        return penalty;
    }

    public String getPenaltyID() {
        return penaltyID;
    }
}
