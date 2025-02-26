package com.DevSprint.LibraryMS.service;

import java.util.List;

import com.DevSprint.LibraryMS.dto.StaffDTO;

public interface StaffService {
    void addStaffMember(StaffDTO staffDTO);
    void deleteStaffMember(String staffId);
    void updateStaffMember(String staffId, StaffDTO staffDTO);
    StaffDTO getStaffById(String staffId);
    List <StaffDTO> getAllStaff();
}
