package com.DevSprint.LibraryMS.util;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Component;

import com.DevSprint.LibraryMS.dto.BookDTO;
import com.DevSprint.LibraryMS.entities.BookEntitiy;

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
}
