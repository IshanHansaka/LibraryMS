package com.DevSprint.LibraryMS.service;

import java.util.List;

import com.DevSprint.LibraryMS.dto.BookDTO;

public interface BookService {
    void addBook(BookDTO bookDTO);
    void deleteBook(String bookId);
    void updateBook(String bookId, BookDTO bookDTO);
    void getBookById(String bookId);
    List<BookDTO> getAllBooks(BookDTO bookDTO);
}