package com.example.librarymangementsystem.service;

import com.example.librarymangementsystem.Enum.CardStatus;
import com.example.librarymangementsystem.entities.LibraryCard;
import com.example.librarymangementsystem.repository.LibraryCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibraryCardService {
    @Autowired
    private LibraryCardRepository libraryCardRepository;

    public String addFreshCard(){
        LibraryCard newCard=new LibraryCard();
        newCard.setCardStatus(CardStatus.NEW);
        newCard.setNoOfBooksIssued(0);
        LibraryCard card=libraryCardRepository.save(newCard);
        return "new card is generated having card id "+card.getCardNumber();
    }
}
