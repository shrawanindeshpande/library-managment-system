package com.example.librarymangementsystem.entities;

import com.example.librarymangementsystem.Enum.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    @Column(unique = true)
    private String bookName;
    @Enumerated(value=EnumType.STRING)
    private Genre genre;
    private int noOfPages;
    private int price;
    private Date publishDate;

    @JoinColumn
    @ManyToOne
    private Author author;

}
