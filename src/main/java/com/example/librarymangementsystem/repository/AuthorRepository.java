package com.example.librarymangementsystem.repository;

import com.example.librarymangementsystem.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
