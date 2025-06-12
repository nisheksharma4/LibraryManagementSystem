package model;

import java.time.LocalDateTime;

public class Transaction {
    private User user;
    private Book book;
    private String type; // BORROW or RETURN
    private LocalDateTime timestamp;

    public Transaction(User user, Book book, String type) {
        this.user = user;
        this.book = book;
        this.type = type;
        this.timestamp = LocalDateTime.now(); // Set transaction time to current
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public String getType() {
        return type;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Transaction{" +
               "user=" + user.getName() +
               ", book=" + book.getTitle() +
               ", type='" + type + '\'' +
               ", timestamp=" + timestamp +
               '}';
    }
}
