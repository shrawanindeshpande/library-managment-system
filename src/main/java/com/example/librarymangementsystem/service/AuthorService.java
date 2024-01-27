package com.example.librarymangementsystem.service;

import com.example.librarymangementsystem.entities.Author;
import com.example.librarymangementsystem.repository.AuthorRepository;
import com.example.librarymangementsystem.requestclasses.AddAuthorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public String addAuthor(AddAuthorRequest addAuthorRequest){
        Author author=new Author(addAuthorRequest.getAuthorName(),addAuthorRequest.getAuthorAge(),addAuthorRequest.getEmailId());
        Author newAuthor=authorRepository.save(author);
        return "Author with author id"+newAuthor.getAuthorId()+" is added to db";
    }
}
