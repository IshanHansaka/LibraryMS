package com.DevSprint.LibraryMS.service;

import java.util.List;

import com.DevSprint.LibraryMS.dto.LendingDTO;

public interface LendingService {
    void addLending(LendingDTO lendingDTO);

    void deleteLending(String lendingId);

    void updateLending(String lendingId);

    LendingDTO getLendingById(String lendingId);

    List<LendingDTO> getAllLending();
}
