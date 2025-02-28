package com.DevSprint.LibraryMS.util;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.DevSprint.LibraryMS.dto.LendingDTO;
import com.DevSprint.LibraryMS.entities.LendingEntity;
import com.DevSprint.LibraryMS.entities.MemberEntity;
import com.DevSprint.LibraryMS.entities.BookEntity;

@Component
public class LendingMapping {
    public static LendingDTO toLendingDTO(LendingEntity lendingEntity) {
        var lendingDTO = new LendingDTO();
        lendingDTO.setLendingId(lendingEntity.getLendingId());
        lendingDTO.setBook(lendingEntity.getBook().getBookId());
        lendingDTO.setMember(lendingEntity.getMember().getMemberId());
        lendingDTO.setLendingDate(lendingEntity.getLendingDate());
        lendingDTO.setReturnDate(lendingEntity.getReturnDate());
        lendingDTO.setIsActiveLending(lendingEntity.getIsActiveLending());
        lendingDTO.setOverdueDays(lendingEntity.getOverdueDays());
        lendingDTO.setFineAmount(lendingEntity.getFineAmount());
        return lendingDTO;
    }

    public static LendingEntity toLendingEntity(LendingDTO lendingDTO, BookEntity bookEntity,
            MemberEntity memberEntity) {
        var lendingEntity = new LendingEntity();
        lendingEntity.setLendingId(lendingDTO.getLendingId());
        lendingEntity.setBook(bookEntity);
        lendingEntity.setMember(memberEntity);
        lendingEntity.setLendingDate(lendingDTO.getLendingDate());
        lendingEntity.setReturnDate(lendingDTO.getReturnDate());
        lendingEntity.setIsActiveLending(lendingDTO.getIsActiveLending());
        lendingEntity.setOverdueDays(lendingDTO.getOverdueDays());
        lendingEntity.setFineAmount(lendingDTO.getFineAmount());
        return lendingEntity;
    }

    public List<LendingDTO> toLendingDTOList(List<LendingEntity> lendingEntityList) {
        return lendingEntityList.stream().map(entity -> {
            LendingDTO lendingDTOData = new LendingDTO();
            lendingDTOData.setLendingId(entity.getLendingId());

            if (entity.getBook() != null) {
                lendingDTOData.setBook(entity.getBook().getBookId());
            }

            if (entity.getMember() != null) {
                lendingDTOData.setMember(entity.getMember().getMemberId());
            }

            lendingDTOData.setLendingDate(entity.getLendingDate());
            lendingDTOData.setReturnDate(entity.getReturnDate());
            lendingDTOData.setIsActiveLending(entity.getIsActiveLending());
            lendingDTOData.setOverdueDays(entity.getOverdueDays());
            lendingDTOData.setFineAmount(entity.getFineAmount());

            return lendingDTOData;
        }).collect(Collectors.toList());
    }
}
