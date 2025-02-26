package com.DevSprint.LibraryMS.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MemberDTO implements Serializable{
    private String memberId;
    private String name;
    private String email;
    private String membershipData;
}
