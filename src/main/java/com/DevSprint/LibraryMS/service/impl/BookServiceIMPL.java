package com.DevSprint.LibraryMS.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.DevSprint.LibraryMS.dto.BookDTO;
import com.DevSprint.LibraryMS.service.BookService;

@Service
public class BookServiceIMPL implements BookService{
    
        @Override
        public void addBook(BookDTO bookDTO) {
            System.out.println(bookDTO);
        }
    
        @Override
        public void deleteBook(String bookId) {
            // TODO Auto-generated method stub
        }
    
        @Override
        public void updateBook(String bookId, BookDTO bookDTO) {
            // TODO Auto-generated method stub
        }
    
        @Override
        public void getBookById(String bookId) {
            // TODO Auto-generated method stub
        }
    
        @Override
        public List<BookDTO> getAllBooks(BookDTO bookDTO) {
            // TODO Auto-generated method stub
            return null;
        }
}
