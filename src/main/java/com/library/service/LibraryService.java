package main.java.com.library.service;

import java.util.List;

import main.java.com.library.model.Book;
import main.java.com.library.model.User;

public class LibraryService {
    private BookDatabase bookDatabase;

    public LibraryService(BookDatabase bookDatabase) {
        this.bookDatabase = bookDatabase;
    }

    public boolean checkOutBook(Book book, User user) {
        if (!book.isCheckedOut() && authenticateUser(user)) {
            book.setCheckedOut(true);
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book, User user) {
        if (book.isCheckedOut() && authenticateUser(user)) {
            book.setCheckedOut(false);
            return true;
        }
        return false;
    }

    public List<Book> getAllBooks() {
        return bookDatabase.getAllBooks();
    }

    public List<Book> getCheckedOutBooks() {
        return bookDatabase.getCheckedOutBooks();
    }

    public int getTotalBooksCount() {
        return bookDatabase.getTotalBooksCount();
    }

    public int getAvailableBooksCount() {
        return bookDatabase.getAvailableBooksCount();
    }

    private boolean authenticateUser(User user) {
        // Perform user authentication logic (e.g., check username and password)
        return true; // For simplicity, always return true in this example
    }

    public BookDatabase getBookDatabase() {
        return bookDatabase;
    }
}
