package com.example.librarymangementsystem.controllers;

import com.example.librarymangementsystem.requestclasses.AddAuthorRequest;
import com.example.librarymangementsystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("author")
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    @PostMapping("addAuthor")
    public ResponseEntity<String> addAuthor(@RequestBody AddAuthorRequest addAuthorRequest){
        String result= authorService.addAuthor(addAuthorRequest);
        return new ResponseEntity(result, HttpStatus.OK);
    }
    @DeleteMapping("deleteAuthorById/{authorId}")
    public ResponseEntity<String> deleteAuthorById(@PathVariable("authorId") int authorId){
        String result= authorService.deleteAuthor(authorId);
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
