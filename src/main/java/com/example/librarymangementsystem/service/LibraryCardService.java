package com.example.librarymangementsystem.service;

import com.example.librarymangementsystem.Enum.CardStatus;
import com.example.librarymangementsystem.entities.LibraryCard;
import com.example.librarymangementsystem.entities.Student;
import com.example.librarymangementsystem.repository.LibraryCardRepository;
import com.example.librarymangementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class LibraryCardService {
    @Autowired
    private LibraryCardRepository libraryCardRepository;
    @Autowired
    private StudentRepository studentRepository;

    public String addFreshCard(){
        LibraryCard newCard=new LibraryCard();
        newCard.setCardStatus(CardStatus.NEW);
        newCard.setNoOfBooksIssued(0);
        LibraryCard card=libraryCardRepository.save(newCard);
        return "new card is generated having card id "+card.getCardNumber();
    }

    public  String associateCardWithStudent(Integer cardNumber,Integer studentId) throws Exception{
        //get library card from give id if not exist throe exception
        Optional<LibraryCard>  optionalLibraryCard=libraryCardRepository.findById(cardNumber);
        if(optionalLibraryCard.isEmpty()){
            throw new Exception("No such card exist with given id");
        }
        LibraryCard libraryCard=optionalLibraryCard.get();
        //get student from give id if not exist throw exception
        Optional<Student> optionalStudent=studentRepository.findById(studentId);
        if(optionalStudent.isEmpty()){
            throw new Exception("No such student exist with given id");
        }
        Student student=optionalStudent.get();

        libraryCard.setCardStatus(CardStatus.ACTIVE);
        libraryCard.setNoOfBooksIssued(0);
        libraryCard.setStudent(student);

        libraryCardRepository.save(libraryCard);

        return "card with card id "+libraryCard.getCardNumber()+" and student with student id "+student.getStudentId()+" are asccociated.";

    }
}
