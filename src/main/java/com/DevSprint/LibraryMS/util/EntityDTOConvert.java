package com.DevSprint.LibraryMS.util;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import com.DevSprint.LibraryMS.dto.BookDTO;
import com.DevSprint.LibraryMS.dto.MemberDTO;
import com.DevSprint.LibraryMS.dto.StaffDTO;
import com.DevSprint.LibraryMS.entities.BookEntity;
import com.DevSprint.LibraryMS.entities.MemberEntity;
import com.DevSprint.LibraryMS.entities.StaffEntity;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor // Constructor injection
public class EntityDTOConvert {

    private final ModelMapper modelMapper;

    // Book
    public BookEntity toBookEntity(BookDTO bookDTO) {
        return modelMapper.map(bookDTO, BookEntity.class);
    }

    public BookDTO toBookDTO(BookEntity bookEntitiy) {
        return modelMapper.map(bookEntitiy, BookDTO.class);
    }

    public List<BookDTO> toBookDTOList(List<BookEntity> bookEntitiyList) {
        return modelMapper.map(bookEntitiyList, new TypeToken<List<BookDTO>>() {
        }.getType());
    }

    // Member
    public MemberDTO toMemberDTO(MemberEntity memberEntity) {
        return modelMapper.map(memberEntity, MemberDTO.class);
    }

    public MemberEntity toMemberEntity(MemberDTO memberDTO) {
        return modelMapper.map(memberDTO, MemberEntity.class);
    }

    public List<MemberDTO> toMemberDTOList(List<MemberEntity> memberEntityList) {
        return modelMapper.map(memberEntityList, new TypeToken<List<MemberDTO>>() {
        }.getType());
    }

    // Staff
    public StaffDTO toStaffDTO(StaffEntity staffEntity) {
        return modelMapper.map(staffEntity, StaffDTO.class);
    }

    public StaffEntity toStaffEntity(StaffDTO staffDTO) {
        return modelMapper.map(staffDTO, StaffEntity.class);
    }

    public List<StaffDTO> toStaffDTOList(List<StaffEntity> staffEntityList) {
        return modelMapper.map(staffEntityList, new TypeToken<List<StaffDTO>>() {
        }.getType());
    }
}
