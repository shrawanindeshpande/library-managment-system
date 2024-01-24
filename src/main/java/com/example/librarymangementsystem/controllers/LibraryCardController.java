package com.example.librarymangementsystem.controllers;

import com.example.librarymangementsystem.service.LibraryCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class LibraryCardController {
    @Autowired
    private LibraryCardService libraryCardService;

    @PostMapping("/addCard")
    public String addCard(){
        String result=libraryCardService.addFreshCard();
        return result;
    }
}
