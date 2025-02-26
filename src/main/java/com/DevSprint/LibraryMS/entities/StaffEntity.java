package com.DevSprint.LibraryMS.entities;

import java.time.LocalDate;

import com.DevSprint.LibraryMS.dto.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "staff")
public class StaffEntity {
    @Id
    private String staffId;
    private String firstName;
    private String lastName;
    private String email;
    private String joinDate;
    private LocalDate lastUpdate;
    private String phone;
    private Role role;
}
