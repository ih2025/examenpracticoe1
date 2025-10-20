package com.ironhack.examenpracticoe1.repository;

import com.ironhack.examenpracticoe1.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
