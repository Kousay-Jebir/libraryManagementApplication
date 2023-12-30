package main.java.com.library.ui;

import java.util.List;
import java.util.Scanner;
import main.java.com.library.model.Admin;
import main.java.com.library.model.Book;
import main.java.com.library.model.User;
import main.java.com.library.service.BookDatabase;
import main.java.com.library.service.LibraryService;

public class Menu {
    private Scanner scanner;
    private LibraryService libraryService;
    private User currentUser;

    public Menu(User currentUser) {
        this.scanner = new Scanner(System.in);
        this.libraryService = new LibraryService(new BookDatabase());
        this.currentUser = currentUser;
    }

    public void handleMenu() {
        int choice;
        do {
            displayMenu();
            choice = getUserChoice();
            switch (choice) {
                case 1:
                    handleCheckOut();
                    break;
                case 2:
                    handleReturn();
                    break;
                case 3:
                    handleViewAllBooks();
                    break;
                case 4:
                    handleViewCheckedOutBooks();
                    break;
                case 5:
                    handleViewLibraryStatistics();
                    break;
                // Additional cases for administrators
                case 7:
                    if (currentUser instanceof Admin) {
                        handleAddBookToDatabase();
                    } else {
                        System.out.println("Access denied. Only administrators can perform this action.");
                    }
                    break;
                case 8:
                    if (currentUser instanceof Admin) {
                        handleRemoveBookFromDatabase();
                    } else {
                        System.out.println("Access denied. Only administrators can perform this action.");
                    }
                    break;
            }
        } while (choice != 6);
    }

    private void handleCheckOut() {
        System.out.println("Enter the title of the book you want to check out: ");
        String title = scanner.next();
        Book bookToCheckOut = findBookByTitle(title);
        if (bookToCheckOut != null) {
            if (libraryService.checkOutBook(bookToCheckOut, currentUser)) {
                System.out.println("Book checked out successfully!");
            } else {
                System.out.println("Unable to check out the book. Please check book availability.");
            }
        } else {
            System.out.println("Book not found.");
        }
    }

    private void handleReturn() {
        System.out.println("Enter the title of the book you want to return: ");
        String title = scanner.next();
        Book bookToReturn = findBookByTitle(title);
        if (bookToReturn != null) {
            if (libraryService.returnBook(bookToReturn, currentUser)) {
                System.out.println("Book returned successfully!");
            } else {
                System.out.println("Unable to return the book. Please check your credentials or book status.");
            }
        } else {
            System.out.println("Book not found.");
        }
    }

    private void handleViewAllBooks() {
        List<Book> allBooks = libraryService.getAllBooks();
        displayBooks(allBooks);
    }

    private void handleViewCheckedOutBooks() {
        List<Book> checkedOutBooks = libraryService.getCheckedOutBooks();
        displayBooks(checkedOutBooks);
    }

    private void handleViewLibraryStatistics() {
        System.out.println("Library Statistics:");
        System.out.println("Total Books: " + libraryService.getTotalBooksCount());
        System.out.println("Available Books: " + libraryService.getAvailableBooksCount());
    }

    private void handleAddBookToDatabase() {
        if (currentUser instanceof Admin) {
            System.out.println("Enter the title of the new book: ");
            String title = scanner.next();
            System.out.println("Enter the author of the new book: ");
            String author = scanner.next();
            System.out.println("Enter the ISBN of the new book: ");
            String isbn = scanner.next();

            Book newBook = new Book(title, author, isbn);
            ((Admin) currentUser).addBookToDatabase(newBook, libraryService.getBookDatabase());
            System.out.println("Book added to the database successfully!");
        }
    }

    private void handleRemoveBookFromDatabase() {
        if (currentUser instanceof Admin) {
            System.out.println("Enter the title of the book to remove: ");
            String title = scanner.next();
            Book bookToRemove = findBookByTitle(title);
            if (bookToRemove != null) {
                ((Admin) currentUser).removeBookFromDatabase(bookToRemove, libraryService.getBookDatabase());
                System.out.println("Book removed from the database successfully!");
            } else {
                System.out.println("Book not found.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("1. Check Out a Book");
        System.out.println("2. Return a Book");
        System.out.println("3. View All Books");
        System.out.println("4. View Checked Out Books");
        System.out.println("5. View Library Statistics");
        System.out.println("6. Exit");

        // Additional options for administrators
        if (currentUser instanceof Admin) {
            System.out.println("7. Add Book to Database");
            System.out.println("8. Remove Book from Database");
        }
    }

    private void displayBooks(List<Book> books) {
        System.out.println("Books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    private int getUserChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    private Book findBookByTitle(String title) {
        List<Book> allBooks = libraryService.getAllBooks();
        for (Book book : allBooks) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}
