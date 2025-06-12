package service;

import model.*;
import log.ILogger;
import java.util.*;

public class TransactionManager {
    private List<Transaction> transactions = new ArrayList<>();
    
    private ILogger logger;
    
    public TransactionManager(ILogger logger) {
    	this.logger = logger;
    }

    public boolean borrowBook(Book book, User user) {
        if (!book.isAvailable()) {
        	logger.log("Attempted to borrow unavailable book: " + book.getTitle());
        	return false;
        }

        book.setAvailable(false);
        transactions.add(new Transaction(user, book, "BORROW"));
        logger.log("Book borrowed: " + book.getTitle() + " by " + user.getName());
        return true;
    }

    public void returnBook(Book book, User user) {
        book.setAvailable(true);
        transactions.add(new Transaction(user, book, "RETURN"));
        logger.log("Book returned: " + book.getTitle() + " by " + user.getName());
    
    }

    public List<Transaction> getAllTransactions() {
        return transactions;
    }
}
