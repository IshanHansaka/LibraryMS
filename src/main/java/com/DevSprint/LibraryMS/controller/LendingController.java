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

import com.DevSprint.LibraryMS.dto.LendingDTO;

@RestController
@RequestMapping("api/v1/lendings")
public class LendingController {

    @GetMapping("/health")
    public String healthCheck() {
        return "Lending Controller running";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addLending(@RequestBody LendingDTO lendingDTO) {
        System.out.println(lendingDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteLending(@RequestParam("lendingId") String lendingId) {
        System.out.println(lendingId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{lendingId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateLending(@PathVariable String lendingId, @RequestBody LendingDTO lendingDTO) {
        System.out.println(lendingId);
        System.out.println(lendingDTO);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{lendingId}")
    public ResponseEntity<LendingDTO> getLendingById(@PathVariable String lendingId) {
        System.out.println("Get lending by id for " + lendingId);
        return ResponseEntity.ok(new LendingDTO(
            "L12345",
            "Effective Java",
            "M12345",
            "2025-02-01",
            "2025-02-15",
            true,
            1,
            10.00));
    }
}
