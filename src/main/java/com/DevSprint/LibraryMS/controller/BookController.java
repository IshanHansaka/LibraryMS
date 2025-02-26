package com.DevSprint.LibraryMS.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DevSprint.LibraryMS.dto.BookDTO;

@RestController // handle http req & res
@RequestMapping("api/v1/books") // industry best practise
public class BookController {

    @GetMapping("/health")
    public String healthCheck() {
        return "Book Controller running";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addBook(@RequestBody BookDTO bookDTO) {
        System.out.println(bookDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteBook(@RequestParam("bookId") String bookId) {
        System.out.println(bookId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{bookId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateBook(@PathVariable String bookId, @RequestBody BookDTO bookDTO) {
        System.out.println(bookId);
        System.out.println(bookDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable String bookId) {
        System.out.println("Get book by id for " + bookId);
        return ResponseEntity.ok(new BookDTO(
                "12345",
                "Effective Java",
                "Joshua Bloch",
                "3rd",
                "Addison-Wesley",
                "978-0134685991",
                45.99,
                100,
                75,
                "2025-02-26",
                "14:30:00"));
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<BookDTO> bookList = new ArrayList<>();
        bookList.add(new BookDTO(
                "00123",
                "Clean Code",
                "Robert C. Martin",
                "1st",
                "Prentice Hall",
                "978-0132350884",
                40.00,
                200,
                150,
                "2025-03-01",
                "10:00:00"));

        bookList.add(new BookDTO(
                "00456",
                "Java: The Complete Reference",
                "Herbert Schildt",
                "10th",
                "McGraw-Hill",
                "978-1260440232",
                60.99,
                150,
                130,
                "2025-03-02",
                "11:30:00"));

        bookList.add(new BookDTO(
                "00789",
                "Design Patterns: Elements of Reusable Object-Oriented Software",
                "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides",
                "1st",
                "Addison-Wesley",
                "978-0201633610",
                55.50,
                80,
                60,
                "2025-03-03",
                "12:45:00"));
        
        return ResponseEntity.ok(bookList);
    }
}
