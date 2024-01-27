package com.example.librarymangementsystem.service;

import com.example.librarymangementsystem.entities.Author;
import com.example.librarymangementsystem.entities.Book;
import com.example.librarymangementsystem.repository.AuthorRepository;
import com.example.librarymangementsystem.repository.BookRepository;
import com.example.librarymangementsystem.requestclasses.AddBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public String addBook(AddBookRequest addBookRequest) throws Exception{
        //get author
        Optional<Author> optionalAuthor= authorRepository.findById(addBookRequest.getAuthorId());
        if(optionalAuthor.isEmpty()){
            throw  new Exception("Invalid author id.");
        }
        Author author=optionalAuthor.get();


        //get book entity
        Book newBook=new Book(addBookRequest.getBookName(),addBookRequest.getGenre(),addBookRequest.getNoOfPages(),addBookRequest.getPrice(),addBookRequest.getPublishDate());
        author.setNoOfBooksWritten(author.getNoOfBooksWritten()+1);
        newBook.setAuthor(author);
        author.getBookList().add(newBook);
        authorRepository.save(author);
        return "Book with id"+newBook.getBookId()+" is added";
    }
}
