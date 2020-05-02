package gui;

import java.util.EventObject;

public class IssueFormEvent extends EventObject {
    private String issuerId;
    private String studentId;
    private String isbn;
    private String issueDate;
    private String returnDate;

    public IssueFormEvent(Object source) {
        super(source);
    }

    public IssueFormEvent(Object source, String issuerId, String studentId, String isbn, String issueDate, String returnDate) {
        super(source);
        this.issuerId = issuerId;
        this.studentId = studentId;
        this.isbn = isbn;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    public String getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(String issuerId) {
        this.issuerId = issuerId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
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
}
