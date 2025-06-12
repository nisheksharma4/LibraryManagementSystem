package service;

import model.Book;
import java.util.*;

public class BookManager {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public Book getBookById(String id) {
        for (Book b : books) {
            if (b.getId().equals(id)) return b;
        }
        return null;
    }

    public void removeBook(String id) {
        books.removeIf(book -> book.getId().equals(id));
    }

    public List<Book> getAllBooks() {
        return books;
    }
}
