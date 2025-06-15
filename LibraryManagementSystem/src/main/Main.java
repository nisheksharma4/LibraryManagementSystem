package main;

import model.*;
import service.*;
import search.*;
import log.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BookManager bookManager = new BookManager();
        UserManager userManager = new UserManager();
        ILogger logger = new ConsoleLogger();
        TransactionManager transactionManager = new TransactionManager(logger);

        bookManager.addBook(new Book("1", "The Alchemist", "Paulo Coelho"));
        bookManager.addBook(new Book("2", "Atomic Habits", "James Clear"));
        bookManager.addBook(new Book("3", "Harry Potter", "JK Rowling"));

        userManager.addUser(new User("u1", "Alice"));
        userManager.addUser(new User("u2", "Nishek"));

        System.out.println("Welcome to Library System");
        while (true) {
            System.out.println("\n1. View Books\n2. Search by Title\n3. Borrow\n4. Return\n5. View All Users\n6. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    for (Book b : bookManager.getAllBooks()) {
                        System.out.println(b.getId() + " - " + b.getTitle() + " by " + b.getAuthor() + 
                                           (b.isAvailable() ? " [Available]" : " [Borrowed]"));
                    }
                    break;

                case 2:
                    System.out.print("Enter title keyword: ");
                    String keyword = sc.nextLine();
                    SearchStrategy strategy = new TitleSearch(); // or AuthorSearch()
                    List<Book> found = strategy.search(bookManager.getAllBooks(), keyword);
                    for (Book b : found) {
                        System.out.println(b.getId() + " - " + b.getTitle());
                    }
                    break;

                case 3:
                    System.out.print("Enter Book ID to borrow: ");
                    String bid = sc.nextLine();
                    Book book = bookManager.getBookById(bid);
                    User user = userManager.getUserById("u1"); // hardcoded user
                    if (book != null && transactionManager.borrowBook(book, user)) {
                        System.out.println("Book borrowed successfully.");
                    } else {
                        System.out.println("Book not available.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Book ID to return: ");
                    String rbId = sc.nextLine();
                    Book rbook = bookManager.getBookById(rbId);
                    User ruser = userManager.getUserById("u1");
                    if (rbook != null) {
                        transactionManager.returnBook(rbook, ruser);
                        System.out.println("Book returned.");
                    }
                    break;
                case 5:
                	for(User u : userManager.getAllUsers()) {
                		System.out.println(u.getId() + " - "+ u.getName());
                	}
                	
                	break;
                case 6:
                    System.out.println("Exiting...!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
