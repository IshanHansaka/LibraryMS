package com.DevSprint.LibraryMS.service;

import java.util.List;


import com.DevSprint.LibraryMS.dto.MemberDTO;

public interface MemberService {
    void addMemeber(MemberDTO memberDTO);
    void deleteMember(String memberId);
    void updateMember(String memberId, MemberDTO memberDTO);
    MemberDTO getMemberById(String memberId);
    List <MemberDTO> getAllMembers();
}
