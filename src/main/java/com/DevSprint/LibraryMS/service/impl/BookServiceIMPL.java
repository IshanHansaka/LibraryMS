package com.DevSprint.LibraryMS.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.DevSprint.LibraryMS.dto.BookDTO;
import com.DevSprint.LibraryMS.service.BookService;

@Service
public class BookServiceIMPL implements BookService {

    @Override
    public void addBook(BookDTO bookDTO) {
        System.out.println(bookDTO);
    }

    @Override
    public void deleteBook(String bookId) {
        System.out.println(bookId);
    }

    @Override
    public void updateBook(String bookId, BookDTO bookDTO) {
        System.out.println(bookId);
        System.out.println(bookDTO);
    }

    @Override
    public BookDTO getBookById(String bookId) {
        BookDTO book = new BookDTO();
        book.setBookId("12345");
        book.setBookName("Effective Java");
        book.setAuthor("Joshua Bloch");
        book.setEdition("3rd");
        book.setPublisher("Addison-Wesley");
        book.setIsbn("978-0134685991");
        book.setPrice(45.99);
        book.setTotalQty(100);
        book.setAvailableQty(75);
        book.setLastUpdateDate("2025-02-26");
        book.setLastUpdateTime("14:30:00");
        return book;
    };

    @Override
    public List<BookDTO> getAllBooks() {
        List<BookDTO> bookList = new ArrayList<>();
        
        BookDTO book1 = new BookDTO();
        book1.setBookId("12345");
        book1.setBookName("Effective Java");
        book1.setAuthor("Joshua Bloch");
        book1.setEdition("3rd");
        book1.setPublisher("Addison-Wesley");
        book1.setIsbn("978-0134685991");
        book1.setPrice(45.99);
        book1.setTotalQty(100);
        book1.setAvailableQty(75);
        book1.setLastUpdateDate("2025-02-26");
        book1.setLastUpdateTime("14:30:00");

        BookDTO book2 = new BookDTO();
        book2.setBookId("67890");
        book2.setBookName("Clean Code");
        book2.setAuthor("Robert C. Martin");
        book2.setEdition("1st");
        book2.setPublisher("Prentice Hall");
        book2.setIsbn("978-0132350884");
        book2.setPrice(40.99);
        book2.setTotalQty(80);
        book2.setAvailableQty(60);
        book2.setLastUpdateDate("2025-03-15");
        book2.setLastUpdateTime("10:00:00");

        BookDTO book3 = new BookDTO();
        book3.setBookId("11223");
        book3.setBookName("Design Patterns");
        book3.setAuthor("Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides");
        book3.setEdition("1st");
        book3.setPublisher("Addison-Wesley");
        book3.setIsbn("978-0201633610");
        book3.setPrice(50.99);
        book3.setTotalQty(70);
        book3.setAvailableQty(50);
        book3.setLastUpdateDate("2025-04-10");
        book3.setLastUpdateTime("16:45:00");

        bookList.add(book1);
        bookList.add(book2);
        bookList.add(book3);

        return bookList;
    }
}
