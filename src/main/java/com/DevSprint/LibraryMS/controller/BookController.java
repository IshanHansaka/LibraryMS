package com.DevSprint.LibraryMS.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

@RestController //handle http req & res
@RequestMapping("api/v1/books") //industry best practise
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
}
