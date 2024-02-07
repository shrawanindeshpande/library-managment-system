package com.example.librarymangementsystem.service;

import com.example.librarymangementsystem.entities.Author;
import com.example.librarymangementsystem.repository.AuthorRepository;
import com.example.librarymangementsystem.repository.BookRepository;
import com.example.librarymangementsystem.requestclasses.AddAuthorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private JavaMailSender mailSender;

    public String addAuthor(AddAuthorRequest addAuthorRequest){
        Author author=new Author(addAuthorRequest.getAuthorName(),addAuthorRequest.getAuthorAge(),addAuthorRequest.getEmailId());
        Author newAuthor=authorRepository.save(author);
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom("backenddevloper76@gmail.com");
        simpleMailMessage.setTo(author.getEmailId());
        simpleMailMessage.setSubject("hi "+author.getAuthorName());
        simpleMailMessage.setText("Thank you for registering to our portal"+
                "Looking forward for adding more books.");
        mailSender.send(simpleMailMessage);
        return "Author with author id"+newAuthor.getAuthorId()+" is added to db";
    }
    public String deleteAuthor(int authorId){
        Author author=authorRepository.findById(authorId).get();
        authorRepository.delete(author);
        bookRepository.deleteAll(author.getBookList());
        SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
        simpleMailMessage.setFrom("backenddevloper76@gmail.com");
        simpleMailMessage.setTo(author.getEmailId());
        simpleMailMessage.setSubject("Author profile deletion");
        simpleMailMessage.setText("Hello,"+author.getAuthorName()+" your author profile is being deleted. book associated with your profile will also be deleted" +
                "Thank you !");
        mailSender.send(simpleMailMessage);
        return "Author with author id"+author.getAuthorId()+" is deleted from db";
    }
}
