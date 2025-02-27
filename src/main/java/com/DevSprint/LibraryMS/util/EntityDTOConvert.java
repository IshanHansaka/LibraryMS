package com.DevSprint.LibraryMS.util;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import com.DevSprint.LibraryMS.dto.BookDTO;
import com.DevSprint.LibraryMS.dto.MemberDTO;
import com.DevSprint.LibraryMS.entities.BookEntitiy;
import com.DevSprint.LibraryMS.entities.MemberEntity;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor // Constructor injection
public class EntityDTOConvert {

    private final ModelMapper modelMapper;

    // Book
    public BookEntitiy toBookEntity(BookDTO bookDTO) {
        return modelMapper.map(bookDTO, BookEntitiy.class);
    }

    public BookDTO toBookDTO(BookEntitiy bookEntitiy) {
        return modelMapper.map(bookEntitiy, BookDTO.class);
    }

    public List<BookDTO> toBookDTOList(List<BookEntitiy> bookEntitiyList) {
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
}
