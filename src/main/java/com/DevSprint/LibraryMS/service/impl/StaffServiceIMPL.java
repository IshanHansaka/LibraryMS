package com.DevSprint.LibraryMS.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.DevSprint.LibraryMS.dao.StaffRepository;
import com.DevSprint.LibraryMS.dto.StaffDTO;
import com.DevSprint.LibraryMS.entities.StaffEntity;
import com.DevSprint.LibraryMS.exception.StaffNotFoundException;
import com.DevSprint.LibraryMS.service.StaffService;
import com.DevSprint.LibraryMS.util.EntityDTOConvert;
import com.DevSprint.LibraryMS.util.UtilData;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor // Constructor injection
@Transactional
public class StaffServiceIMPL implements StaffService {

    private final StaffRepository staffRepository;
    private final EntityDTOConvert entityDTOConvert;

    @Override
    public void addStaffMember(StaffDTO staffDTO) {
        staffDTO.setStaffId(UtilData.generateStaffId());
        staffDTO.setLastUpdate(UtilData.generateTodayDate());
        staffRepository.save(entityDTOConvert.toStaffEntity(staffDTO));
    };

    @Override
    public void deleteStaffMember(String staffId) {
        Optional<StaffEntity> foundStaff = staffRepository.findById(staffId);
        if (!foundStaff.isPresent()) {
            throw new StaffNotFoundException("Staff not found");
        }
        staffRepository.deleteById(staffId);
    };

    @Override
    public void updateStaffMember(String staffId, StaffDTO staffDTO) {
        Optional<StaffEntity> foundStaff = staffRepository.findById(staffId);
        if (!foundStaff.isPresent()) {
            throw new StaffNotFoundException("Staff not found");
        }
        foundStaff.get().setFirstName(staffDTO.getFirstName());
        foundStaff.get().setLastName(staffDTO.getLastName());
        foundStaff.get().setEmail(staffDTO.getEmail());
        foundStaff.get().setJoinDate(staffDTO.getJoinDate());
        foundStaff.get().setPhone(staffDTO.getPhone());
        foundStaff.get().setRole(staffDTO.getRole());
    };

    @Override
    public StaffDTO getStaffById(String staffId) {
        Optional<StaffEntity> foundStaff = staffRepository.findById(staffId);
        if (!foundStaff.isPresent()) {
            throw new StaffNotFoundException("Staff not found");
        }
        return entityDTOConvert.toStaffDTO(staffRepository.getReferenceById(staffId));
    };

    @Override
    public List<StaffDTO> getAllStaff() {
        return entityDTOConvert.toStaffDTOList(staffRepository.findAll());
    };
}
