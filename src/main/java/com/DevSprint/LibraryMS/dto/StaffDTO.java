package com.DevSprint.LibraryMS.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StaffDTO implements Serializable{
    private String staffId;
    private String fisrtName;
    private String lastName;
    private String email;
    private String joinDate;
    private LocalDate lastUpdate;
    private String phone;
    private Role role;
}
