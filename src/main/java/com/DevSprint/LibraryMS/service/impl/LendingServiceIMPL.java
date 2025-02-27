package com.DevSprint.LibraryMS.service.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.DevSprint.LibraryMS.dto.LendingDTO;
import com.DevSprint.LibraryMS.service.LendingService;
import com.DevSprint.LibraryMS.util.UtilData;

@Service
public class LendingServiceIMPL implements LendingService {

    @Value("${perDayFine}") // Value injection
    private Double fineAmount;

    @Override
    public void addLending(LendingDTO lendingDTO) {
        lendingDTO.setLendingId(UtilData.generateLendingId());
        lendingDTO.setLendingDate(UtilData.generateTodayDate());
        lendingDTO.setReturnDate(UtilData.generateReturnDate());
        lendingDTO.setIsActiveLending(true);
        lendingDTO.setOverdueDays(0L);
        lendingDTO.setFineAmount(0.00);
        System.out.println(lendingDTO);
    };

    @Override
    public void deleteLending(String lendingId) {
        System.out.println(lendingId);
    };

    @Override
    public void updateLending(String lendingId) {
        // Todo
    };

    @Override
    public LendingDTO getLendingById(String lendingId) {
        LendingDTO lending = new LendingDTO();
        lending.setLendingId("L12345");
        lending.setBook("Effective Java");
        lending.setMember("M12345");
        lending.setIsActiveLending(true);
        lending.setOverdueDays(1L);
        lending.setFineAmount(10.00);
        return lending;
    };

    @Override
    public List<LendingDTO> getAllLending() {
        List<LendingDTO> lendingList = new ArrayList<>();

        LendingDTO lending1 = new LendingDTO();
        lending1.setLendingId("L12345");
        lending1.setBook("Effective Java");
        lending1.setMember("M12345");
        lending1.setIsActiveLending(true);
        lending1.setOverdueDays(1L);
        lending1.setFineAmount(10.00);

        LendingDTO lending2 = new LendingDTO();
        lending2.setLendingId("L12345");
        lending2.setBook("Effective Java");
        lending2.setMember("M12345");
        lending2.setIsActiveLending(true);
        lending2.setOverdueDays(1L);
        lending2.setFineAmount(10.00);

        LendingDTO lending3 = new LendingDTO();
        lending3.setLendingId("L12345");
        lending3.setBook("Effective Java");
        lending3.setMember("M12345");
        lending3.setIsActiveLending(true);
        lending3.setOverdueDays(1L);
        lending3.setFineAmount(10.00);

        lendingList.add(lending1);
        lendingList.add(lending2);
        lendingList.add(lending3);

        return lendingList;
    };

    private Long calcOverDue() {
        // Today
        LocalDate today = UtilData.generateTodayDate();
        LocalDate returDate = UtilData.generateReturnDateCalc();

        if (returDate.isBefore(today)) {
            return ChronoUnit.DAYS.between(today, returDate);
        }
        return 0L;
    }

    private Double calcOverDue(Long datCount) {
        return datCount * fineAmount;
    }
}
