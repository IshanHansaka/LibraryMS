package com.DevSprint.LibraryMS.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.DevSprint.LibraryMS.dto.LendingDTO;
import com.DevSprint.LibraryMS.service.LendingService;

@Service
public class LendingServiceIMPL implements LendingService{
    @Override
    public void addLending(LendingDTO lendingDTO) {
        System.out.println(lendingDTO);
    };

    @Override
    public void deleteLending(String lendingId) {
        System.out.println(lendingId);
    };

    @Override
    public void updateLending(String lendingId, LendingDTO lendingDTO) {
        System.out.println(lendingId);
        System.out.println(lendingDTO);
    };

    @Override
    public LendingDTO getLendingById(String lendingId) {
        LendingDTO lending = new LendingDTO();
        lending.setLendingId("L12345");
        lending.setBook("Effective Java");
        lending.setMember("M12345");
        lending.setLendingDate("2025-02-01");
        lending.setReturnDate("2025-02-15");
        lending.setIsActiveLending(true);
        lending.setOverdueDays(1);
        lending.setFineAmount(10.00);
        return lending;
    };

    @Override
    public List <LendingDTO> getAllLending() {
        List <LendingDTO> lendingList = new ArrayList<>();

        LendingDTO lending1 = new LendingDTO();
        lending1.setLendingId("L12345");
        lending1.setBook("Effective Java");
        lending1.setMember("M12345");
        lending1.setLendingDate("2025-02-01");
        lending1.setReturnDate("2025-02-15");
        lending1.setIsActiveLending(true);
        lending1.setOverdueDays(1);
        lending1.setFineAmount(10.00);

        LendingDTO lending2 = new LendingDTO();
        lending2.setLendingId("L12345");
        lending2.setBook("Effective Java");
        lending2.setMember("M12345");
        lending2.setLendingDate("2025-02-01");
        lending2.setReturnDate("2025-02-15");
        lending2.setIsActiveLending(true);
        lending2.setOverdueDays(1);
        lending2.setFineAmount(10.00);

        LendingDTO lending3 = new LendingDTO();
        lending3.setLendingId("L12345");
        lending3.setBook("Effective Java");
        lending3.setMember("M12345");
        lending3.setLendingDate("2025-02-01");
        lending3.setReturnDate("2025-02-15");
        lending3.setIsActiveLending(true);
        lending3.setOverdueDays(1);
        lending3.setFineAmount(10.00);

        lendingList.add(lending1);
        lendingList.add(lending2);
        lendingList.add(lending3);

        return lendingList;
    };
}
