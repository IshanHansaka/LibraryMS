package com.DevSprint.LibraryMS.service.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.DevSprint.LibraryMS.dao.BookRepository;
import com.DevSprint.LibraryMS.dao.LendingRepository;
import com.DevSprint.LibraryMS.dao.MemberRepository;
import com.DevSprint.LibraryMS.dto.LendingDTO;
import com.DevSprint.LibraryMS.entities.BookEntity;
import com.DevSprint.LibraryMS.entities.LendingEntity;
import com.DevSprint.LibraryMS.entities.MemberEntity;
import com.DevSprint.LibraryMS.exception.BookNotFoundException;
import com.DevSprint.LibraryMS.exception.DataPersistException;
import com.DevSprint.LibraryMS.exception.EnoughBooksNotFoundException;
import com.DevSprint.LibraryMS.exception.LendingDataNotFoundException;
import com.DevSprint.LibraryMS.exception.MemberNotFoundException;
import com.DevSprint.LibraryMS.service.LendingService;
import com.DevSprint.LibraryMS.util.LendingMapping;
import com.DevSprint.LibraryMS.util.UtilData;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class LendingServiceIMPL implements LendingService {

    private final LendingMapping lendingMapping;
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;
    private final LendingRepository lendingRepository;

    @Value("${perDayFine}")
    private Double fineAmount;

    @Override
    public void addLending(LendingDTO lendingDTO) {

        // Get relevant book and member
        var bookId = lendingDTO.getBook();
        var memberId = lendingDTO.getMember();

        // Check book & member existence
        BookEntity bookEntity = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("Book not found"));
        MemberEntity memberEntity = memberRepository.findById(memberId)
                .orElseThrow(() -> new MemberNotFoundException("Member not found"));

        // Check if there are sufficient copies of the book
        if (bookRepository.availableQty(bookId) > 0) {
            if (bookRepository.deductBasedOnLending(bookId) > 0) {
                lendingDTO.setLendingId(UtilData.generateLendingId());
                lendingDTO.setLendingDate(UtilData.generateTodayDate());
                lendingDTO.setReturnDate(UtilData.generateReturnDate());
                lendingDTO.setIsActiveLending(true);
                lendingDTO.setOverdueDays(0L);
                lendingDTO.setFineAmount(0.00);
                lendingRepository.save(lendingMapping.toLendingEntity(lendingDTO, bookEntity, memberEntity));
            } else {
                throw new DataPersistException("Can't update book data with 0 available quantity");
            }
        } else {
            throw new EnoughBooksNotFoundException("Not enough books to proceed");
        }
    }

    @Override
    public void deleteLending(String lendingId) {
        var foundLending = lendingRepository.findById(lendingId).orElseThrow(() -> new LendingDataNotFoundException("Lending data not found"));
        lendingRepository.deleteById(lendingId);
        
        // Add the book when delete the lending record
        if (foundLending.getIsActiveLending() == true) {
            bookRepository.addBookBasedOnLending(foundLending.getBook().getBookId());
        }
    }

    @Override
    public void updateLending(String lendingId) {

        // Check lendign is exist
        LendingEntity foundLending = lendingRepository.findById(lendingId)
                .orElseThrow(() -> new LendingDataNotFoundException("Lending data not found"));

        // check overdue and fine
        var returnDate = foundLending.getReturnDate();
        var overDue = calcOverDue(returnDate); // calculate overdue date count
        var fineAmount = calcFine(overDue); // calculate fine against overdue

        foundLending.setOverdueDays(overDue);
        foundLending.setFineAmount(fineAmount);
        foundLending.setIsActiveLending(false);

        // Update book quantity against book id
        bookRepository.addBookBasedOnLending(foundLending.getBook().getBookId());
    }

    @Override
    public LendingDTO getLendingById(String lendingId) {
        var foundLending = lendingRepository.findById(lendingId).orElseThrow(() -> new LendingDataNotFoundException("Lending data not found"));
        return lendingMapping.toLendingDTO(foundLending);
    }

    @Override
    public List<LendingDTO> getAllLending() {
        return lendingMapping.toLendingDTOList(lendingRepository.findAll());
    }

    private Long calcOverDue(LocalDate returnDate) {
        LocalDate today = UtilData.generateTodayDate();
        if (returnDate.isBefore(today)) {
            return ChronoUnit.DAYS.between(returnDate, today);
        }
        return 0L;
    }

    private Double calcFine(Long daysCount) {
        return daysCount * fineAmount;
    }
}
