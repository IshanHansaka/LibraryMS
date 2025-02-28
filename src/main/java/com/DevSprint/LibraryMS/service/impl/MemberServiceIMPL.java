package com.DevSprint.LibraryMS.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.DevSprint.LibraryMS.dao.MemberRepository;
import com.DevSprint.LibraryMS.dto.MemberDTO;
import com.DevSprint.LibraryMS.entities.MemberEntity;
import com.DevSprint.LibraryMS.exception.MemberNotFoundException;
import com.DevSprint.LibraryMS.service.MemberService;
import com.DevSprint.LibraryMS.util.EntityDTOConvert;
import com.DevSprint.LibraryMS.util.UtilData;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // Constructor injection
@Transactional
public class MemberServiceIMPL implements MemberService {

    private final MemberRepository memberRepository;
    private final EntityDTOConvert entityDTOConvert;

    @Override
    public void addMemeber(MemberDTO memberDTO) {
        memberDTO.setMemberId(UtilData.generateMemberId());
        memberDTO.setMembershipDate(UtilData.generateTodayDate());
        memberRepository.save(entityDTOConvert.toMemberEntity(memberDTO));
    };

    @Override
    public void deleteMember(String memberId) {
        // is member exists
        Optional<MemberEntity> foundMember = memberRepository.findById(memberId);
        if (!foundMember.isPresent()) {
            throw new MemberNotFoundException("Member not found");
        }
        memberRepository.deleteById(memberId);
    };

    @Override
    public void updateMember(String memberId, MemberDTO memberDTO) {
        // is member exists
        Optional<MemberEntity> foundMember = memberRepository.findById(memberId);
        if (!foundMember.isPresent()) {
            throw new MemberNotFoundException("Member not found");
        }
        foundMember.get().setName(memberDTO.getName());
        foundMember.get().setEmail(memberDTO.getEmail());
    };

    @Override
    public MemberDTO getMemberById(String memberId) {
        // is member exists
        Optional<MemberEntity> foundMember = memberRepository.findById(memberId);
        if (!foundMember.isPresent()) {
            throw new MemberNotFoundException("Member not found");
        }
        return entityDTOConvert.toMemberDTO(memberRepository.getReferenceById(memberId));
    };

    @Override
    public List<MemberDTO> getAllMembers() {
        return entityDTOConvert.toMemberDTOList(memberRepository.findAll());
    };
}
