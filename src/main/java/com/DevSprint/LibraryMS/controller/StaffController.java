package com.DevSprint.LibraryMS.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DevSprint.LibraryMS.dto.Role;
import com.DevSprint.LibraryMS.dto.StaffDTO;

@RestController
@RequestMapping("api/v1/staff")
public class StaffController {

    @GetMapping("/health")
    public String healthCheck() {
        return "Staff Controller running";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addStaffMember(@RequestBody StaffDTO staffDTO) {
        System.out.println(staffDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteStaffMember(@RequestParam("staffId") String staffId) {
        System.out.println(staffId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{staffId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateStaffMember(@PathVariable String staffId, @RequestBody StaffDTO staffDTO) {
        System.out.println(staffId);
        System.out.println(staffDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{staffId}")
    public ResponseEntity<StaffDTO> getStaffById(@PathVariable String staffId) {
        System.out.println("Get staff by id for " + staffId);
        return ResponseEntity.ok(new StaffDTO(
            "S12345",
            "John",
            "Doe",
            "john.doe@example.com",
            "2025-02-26",
            "+1234567890",
            Role.ADMIN));
    }
}
