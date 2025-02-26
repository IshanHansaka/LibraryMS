package com.DevSprint.LibraryMS.dto;

import java.io.Serializable;

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
    private String lendingDate;
    private String returnDate;
    private Boolean isActiveLending;
    private Integer overdueDays;
    private Double fineAmount;
}
