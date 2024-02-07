package com.example.librarymangementsystem.repository;

import com.example.librarymangementsystem.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
}
