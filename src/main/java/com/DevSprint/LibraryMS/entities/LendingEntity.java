package com.DevSprint.LibraryMS.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "lending")
public class LendingEntity {
    @Id
    private String lendingId;

    @ManyToOne
    @JoinColumn(name = "bookId",nullable = false)
    private BookEntitiy book;

    @ManyToOne
    @JoinColumn(name = "memberId",nullable = false)
    private MemberEntity member;
    
    private LocalDate lendingDate;
    private LocalDate returnDate;
    private Boolean isActiveLending;
    private Long overdueDays;
    private Double fineAmount;
}
