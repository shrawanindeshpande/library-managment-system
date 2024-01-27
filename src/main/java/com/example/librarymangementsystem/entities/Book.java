package com.example.librarymangementsystem.entities;

import com.example.librarymangementsystem.Enum.Genre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table
@Getter
@Setter
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

    public Book(String bookName, Genre genre, int noOfPages, int price, Date publishDate) {
        this.bookName = bookName;
        this.genre = genre;
        this.noOfPages = noOfPages;
        this.price = price;
        this.publishDate = publishDate;
    }
}
