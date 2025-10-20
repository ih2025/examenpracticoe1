package com.ironhack.examenpracticoe1.controller;

import com.ironhack.examenpracticoe1.model.Book;
import com.ironhack.examenpracticoe1.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@Valid @RequestBody Book book) {
        Book created = bookService.createBook(book);
        return ResponseEntity.ok(created);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Book> updateBookPartial(@PathVariable Long id, @RequestBody Book book) {
        Book existing = bookService.getBookById(id);
        if (existing == null) return ResponseEntity.notFound().build();

        if (book.getTitle() != null && !book.getTitle().isBlank()) {
            existing.setTitle(book.getTitle());
        }
        if (book.getPrice() != null) {
            existing.setPrice(book.getPrice());
        }

        Book updated = bookService.createBook(existing); // save the changes
        return ResponseEntity.ok(updated);
    }

}
