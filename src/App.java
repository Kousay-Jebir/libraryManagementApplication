import java.util.Scanner;

import main.java.com.library.model.Admin;
import main.java.com.library.model.Book;
import main.java.com.library.model.User;
import main.java.com.library.ui.Menu;

public class App {

    public static void main(String[] args) {
        // Instantiate books
        Book book1 = new Book("The Catcher in the Rye", "J.D. Salinger", "978-0-316-76948-0");
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "978-0-06-112008-4");

        // Instantiate users
        User regularUser = new User("user123", "password123");
        Admin adminUser = new Admin("admin123", "adminPassword");

        // Simulate authentication
        User authenticatedUser = authenticateUser();

        if (authenticatedUser != null) {
            // Instantiate the menu and start the application
            Menu menu = new Menu(authenticatedUser);
            menu.handleMenu();
        } else {
            System.out.println("Authentication failed. Exiting the application.");
        }
    }

    private static User authenticateUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        String username = scanner.next();
        System.out.print("Enter your password: ");
        String password = scanner.next();

        // Simulate user authentication
        if (username.equals("admin123") && password.equals("adminPassword")) {
            return new Admin(username, password);
        } else if (username.equals("user123") && password.equals("password123")) {
            return new User(username, password);
        }

        return null; // Authentication failed
    }
}