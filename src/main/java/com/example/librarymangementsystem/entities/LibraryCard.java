package com.example.librarymangementsystem.entities;

import com.example.librarymangementsystem.Enum.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "library_card")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LibraryCard {
    public static final Integer MAX_NO_OF_BOOKS_ALLOWED=3;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardNumber;
    private int noOfBooksIssued;
    @Enumerated(value=EnumType.STRING)
    private CardStatus cardStatus;
    @JoinColumn
    @OneToOne
    private Student student;

    @OneToMany(mappedBy = "libraryCard",cascade = CascadeType.ALL)
    public List<Transaction> transactionList=new ArrayList<>();

}
