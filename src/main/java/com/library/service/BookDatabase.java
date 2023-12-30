package main.java.com.library.service;

import java.util.ArrayList;
import java.util.List;

import main.java.com.library.model.Book;

public class BookDatabase {
    private List<Book> books;

    public BookDatabase() {
        this.books = new ArrayList<>();
        // For the sake of example, add some initial books
        books.add(new Book("The Catcher in the Rye", "J.D. Salinger", "978-0-316-76948-0"));
        books.add(new Book("To Kill a Mockingbird", "Harper Lee", "978-0-06-112008-4"));
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    // Additional methods for querying books
    public List<Book> getCheckedOutBooks() {
        List<Book> checkedOutBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isCheckedOut()) {
                checkedOutBooks.add(book);
            }
        }
        return checkedOutBooks;
    }

    // Additional methods for database statistics
    public int getTotalBooksCount() {
        return books.size();
    }

    public int getAvailableBooksCount() {
        int availableBooks = 0;
        for (Book book : books) {
            if (!book.isCheckedOut()) {
                availableBooks++;
            }
        }
        return availableBooks;
    }
}
