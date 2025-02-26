package com.DevSprint.LibraryMS.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LendingDTO implements Serializable{
    private String lendingId;
    private String book;
    private String member;
    private LocalDate lendingDate;
    private LocalDate returnDate;
    private Boolean isActiveLending;
    private Long overdueDays;
    private Double fineAmount;
}
