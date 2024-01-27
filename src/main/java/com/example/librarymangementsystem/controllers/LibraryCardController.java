package com.example.librarymangementsystem.controllers;

import com.example.librarymangementsystem.entities.LibraryCard;
import com.example.librarymangementsystem.service.LibraryCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/associateCardWithStudent")
    public ResponseEntity associateCardWithStudent(@RequestParam("cardNumber")Integer cardNumber,
                                                   @RequestParam("studentId")Integer studentId){

        try{
            String result=libraryCardService.associateCardWithStudent(cardNumber,studentId);
            return new ResponseEntity(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }
}
