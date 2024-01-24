package com.example.librarymangementsystem.repository;

import com.example.librarymangementsystem.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
