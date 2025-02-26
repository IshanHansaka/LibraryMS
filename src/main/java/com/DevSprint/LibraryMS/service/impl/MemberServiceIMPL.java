package com.DevSprint.LibraryMS.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.DevSprint.LibraryMS.dto.MemberDTO;
import com.DevSprint.LibraryMS.service.MemberService;

@Service
public class MemberServiceIMPL implements MemberService {
    @Override
    public void addMemeber(MemberDTO memberDTO) {
        System.out.println(memberDTO);
    };

    @Override
    public void deleteMember(String memberId) {
        System.out.println(memberId);
    };

    @Override
    public void updateMember(String memberId, MemberDTO memberDTO) {
        System.out.println(memberId);
        System.out.println(memberDTO);
    };

    @Override
    public MemberDTO getMemberById(String memberId) {
        MemberDTO member = new MemberDTO();
        member.setMemberId("M12345");
        member.setName("John");
        member.setEmail("john.doe@example.com");
        member.setMembershipData("Addison-Wesley");
        return member;
    };

    @Override
    public List <MemberDTO> getAllMembers() {
        List <MemberDTO> memberList = new ArrayList<>();

        MemberDTO member1 = new MemberDTO();
        member1.setMemberId("M12345");
        member1.setName("John");
        member1.setEmail("john.doe@example.com");
        member1.setMembershipData("Addison-Wesley");

        MemberDTO member2 = new MemberDTO();
        member2.setMemberId("M12346");
        member2.setName("Jane");
        member2.setEmail("jane.doe@example.com");
        member2.setMembershipData("O'Reilly");

        MemberDTO member3 = new MemberDTO();
        member3.setMemberId("M12347");
        member3.setName("Alice");
        member3.setEmail("alice.smith@example.com");
        member3.setMembershipData("Penguin");

        memberList.add(member1);
        memberList.add(member2);
        memberList.add(member3);

        return memberList;
    };
}
