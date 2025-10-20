package com.ironhack.examenpracticoe1.service;

import com.ironhack.examenpracticoe1.model.Book;
import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(Long id);
    Book createBook(Book book);
    void deleteBook(Long id);
}
