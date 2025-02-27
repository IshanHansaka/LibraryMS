package com.DevSprint.LibraryMS.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.DevSprint.LibraryMS.dao.BookRepository;
import com.DevSprint.LibraryMS.dto.BookDTO;
import com.DevSprint.LibraryMS.entities.BookEntitiy;
import com.DevSprint.LibraryMS.exception.BookNotFoundException;
import com.DevSprint.LibraryMS.service.BookService;
import com.DevSprint.LibraryMS.util.EntityDTOConvert;
import com.DevSprint.LibraryMS.util.UtilData;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // Constructor injection
@Transactional
public class BookServiceIMPL implements BookService {

    private final BookRepository bookRepository;
    private final EntityDTOConvert entityDTOConvert;

    @Override
    public void addBook(BookDTO bookDTO) {

        // Business Process
        bookDTO.setBookId(UtilData.generateBookId());
        bookDTO.setLastUpdateDate(UtilData.generateTodayDate());
        bookDTO.setLastUpdateTime(UtilData.generateCurrentTime());

        // pass to dao
        var bookEntity = entityDTOConvert.toBookEntity(bookDTO);
        bookRepository.save(bookEntity);
    }

    @Override
    public void deleteBook(String bookId) {
        // is bookId exist
        Optional<BookEntitiy> foundBook = bookRepository.findById(bookId);
        if (!foundBook.isPresent()) {
            throw new BookNotFoundException("Book not found");
        }
        bookRepository.deleteById(bookId);
    }

    @Override
    public void updateBook(String bookId, BookDTO bookDTO) {
        // is bookId is exist
        Optional<BookEntitiy> foundBook = bookRepository.findById(bookId);
        if (!foundBook.isPresent()) {
            throw new BookNotFoundException("Book not found");
        }
        foundBook.get().setBookName(bookDTO.getBookName());
        foundBook.get().setAuthor(bookDTO.getAuthor());
        foundBook.get().setEdition(bookDTO.getEdition());
        foundBook.get().setPublisher(bookDTO.getAuthor());
        foundBook.get().setPrice(bookDTO.getPrice());
        foundBook.get().setTotalQty(bookDTO.getTotalQty());
        foundBook.get().setAvailableQty(bookDTO.getAvailableQty());
        foundBook.get().setLastUpdateDate(UtilData.generateTodayDate());
        foundBook.get().setLastUpdateTime(UtilData.generateCurrentTime());
    }

    @Override
    public BookDTO getBookById(String bookId) {
        Optional<BookEntitiy> foundBook = bookRepository.findById(bookId);
        if (!foundBook.isPresent()) {
            throw new BookNotFoundException("Selected book not found");
        }

        /*
        BookEntitiy selectedBookEntitiy = bookRepository.getReferenceById(bookId);
        BookDTO selectBookDTO = entityDTOConvert.ToBookDTO(selectedBookEntitiy);
        return selectBookDTO;
        */

        return entityDTOConvert.toBookDTO(bookRepository.getReferenceById(bookId));
    };

    @Override
    public List<BookDTO> getAllBooks() {
        return entityDTOConvert.toBookDTOList(bookRepository.findAll());
    }
}
