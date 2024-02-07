package com.example.librarymangementsystem.service;

import com.example.librarymangementsystem.Enum.TransactionStatus;
import com.example.librarymangementsystem.Enum.TransactionType;
import com.example.librarymangementsystem.entities.Book;
import com.example.librarymangementsystem.entities.LibraryCard;
import com.example.librarymangementsystem.entities.Transaction;
import com.example.librarymangementsystem.repository.BookRepository;
import com.example.librarymangementsystem.repository.LibraryCardRepository;
import com.example.librarymangementsystem.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private LibraryCardRepository libraryCardRepository;

    public String issueBook(int bookId,int cardId)throws Exception {
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        if (optionalBook.isEmpty()) {
            throw new Exception("Invalid book id");
        }
        Book book = optionalBook.get();

        Optional<LibraryCard> optionalLibraryCard = libraryCardRepository.findById(cardId);
        if (optionalLibraryCard.isEmpty()) {
            throw new Exception("Invalid card id");
        }
        LibraryCard libraryCard = optionalLibraryCard.get();
        Transaction transaction = new Transaction();
        transaction.setTransactionStatus(TransactionStatus.ONGOING);
        //check book availability
        if (!book.isAvailable()) {
            transaction.setTransactionStatus(TransactionStatus.FAILURE);
            transaction = transactionRepository.save(transaction);
            throw new Exception("Book with given book id is not available transaction is failed transaction id:" + transaction.getTransactionId());
        }
        //check if no of books issues are more than books allowed or not
        if (libraryCard.getNoOfBooksIssued() >= LibraryCard.MAX_NO_OF_BOOKS_ALLOWED) {
            transaction.setTransactionStatus(TransactionStatus.FAILURE);
            transaction = transactionRepository.save(transaction);
            throw new Exception("Only " + LibraryCard.MAX_NO_OF_BOOKS_ALLOWED + " Books are allowed transaction is failed transaction id:" + transaction.getTransactionId());
        }

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        transaction.setTransactionType(TransactionType.ISSUE);
        //update in card and book

        book.setAvailable(false);
        libraryCard.setNoOfBooksIssued(libraryCard.getNoOfBooksIssued() + 1);
        transaction.setBook(book);
        transaction.setLibraryCard(libraryCard);

        Transaction transaction1 = transactionRepository.save(transaction);
        return "book is issued successfully with transaction id: " + transaction1.getTransactionId();
    }
}
