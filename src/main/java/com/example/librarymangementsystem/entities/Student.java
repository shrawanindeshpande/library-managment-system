package com.example.librarymangementsystem.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;
    private String name;
    private String branch;
    private float cgpa;
    private String phoneNo;

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    private LibraryCard libraryCard;
}
