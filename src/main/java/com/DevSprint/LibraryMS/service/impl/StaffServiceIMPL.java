package com.DevSprint.LibraryMS.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.DevSprint.LibraryMS.dto.Role;
import com.DevSprint.LibraryMS.dto.StaffDTO;
import com.DevSprint.LibraryMS.service.StaffService;
import com.DevSprint.LibraryMS.util.UtilData;

@Service
public class StaffServiceIMPL implements StaffService {

    @Override
    public void addStaffMember(StaffDTO staffDTO) {
        staffDTO.setStaffId(UtilData.generateStaffId());
        staffDTO.setLastUpdate(UtilData.generateTodayDate());
        System.out.println(staffDTO);
    };

    @Override
    public void deleteStaffMember(String staffId) {
        System.out.println(staffId);
    };

    @Override
    public void updateStaffMember(String staffId, StaffDTO staffDTO) {
        System.out.println(staffId);
        System.out.println(staffDTO);
    };

    @Override
    public StaffDTO getStaffById(String staffId) {
        StaffDTO staff = new StaffDTO();
        staff.setStaffId("S12345");
        staff.setFirstName("John");
        staff.setLastName("Doe");
        staff.setEmail("john.doe@example.com");
        staff.setJoinDate("2025-02-26");
        staff.setPhone("+1234567890");
        staff.setRole(Role.ADMIN);
        return staff;
    };

    @Override
    public List<StaffDTO> getAllStaff() {
        List<StaffDTO> staffList = new ArrayList<>();

        StaffDTO staff1 = new StaffDTO();
        staff1.setStaffId("S12345");
        staff1.setFirstName("John");
        staff1.setLastName("Doe");
        staff1.setEmail("john.doe@example.com");
        staff1.setJoinDate("2025-02-26");
        staff1.setPhone("+1234567890");
        staff1.setRole(Role.ADMIN);

        StaffDTO staff2 = new StaffDTO();
        staff2.setStaffId("S12345");
        staff2.setFirstName("John");
        staff2.setLastName("Doe");
        staff2.setEmail("john.doe@example.com");
        staff2.setJoinDate("2025-02-26");
        staff2.setPhone("+1234567890");
        staff2.setRole(Role.ADMIN);

        StaffDTO staff3 = new StaffDTO();
        staff3.setStaffId("S12345");
        staff3.setFirstName("John");
        staff3.setLastName("Doe");
        staff3.setEmail("john.doe@example.com");
        staff3.setJoinDate("2025-02-26");
        staff3.setPhone("+1234567890");
        staff3.setRole(Role.ADMIN);

        staffList.add(staff1);
        staffList.add(staff2);
        staffList.add(staff3);

        return staffList;
    };
}
