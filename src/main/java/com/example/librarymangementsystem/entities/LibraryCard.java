package com.example.librarymangementsystem.entities;

import com.example.librarymangementsystem.CardStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "library_card")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LibraryCard {
    @Id
    private int cardNumber;
    private int noOfBooksIssued;
    @Enumerated(value=EnumType.STRING)
    private CardStatus cardStatus;
}
