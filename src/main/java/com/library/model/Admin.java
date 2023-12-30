package main.java.com.library.model;

import main.java.com.library.service.BookDatabase;

public class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }

    public void addBookToDatabase(Book book, BookDatabase bookDatabase) {
        bookDatabase.addBook(book);
    }

    public void removeBookFromDatabase(Book book, BookDatabase bookDatabase) {
        bookDatabase.removeBook(book);
    }
}
