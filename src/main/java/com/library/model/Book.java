package main.java.com.library.model;

import java.util.UUID;

public class Book {
    private UUID id;
    private String title;
    private String author;
    private String ISBN;
    private boolean checkedOut;

    public Book(String title, String author, String ISBN) {
        this.id = UUID.randomUUID();
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.checkedOut = false;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ISBN='" + ISBN + '\'' +
                ", checkedOut=" + checkedOut +
                '}';
    }
}
