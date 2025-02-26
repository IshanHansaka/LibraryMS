package com.DevSprint.LibraryMS.controller;

import java.util.List;

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
import com.DevSprint.LibraryMS.service.LendingService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/v1/lendings")
@RequiredArgsConstructor // constructor injection
public class LendingController {

    public final LendingService lendingService;

    @GetMapping("/health")
    public String healthCheck() {
        return "Lending Controller running";
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addLending(@RequestBody LendingDTO lendingDTO) {
        lendingService.addLending(lendingDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteLending(@RequestParam("lendingId") String lendingId) {
        lendingService.deleteLending(lendingId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/{lendingId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateLending(@PathVariable String lendingId, @RequestBody LendingDTO lendingDTO) {
        lendingService.updateLending(lendingId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{lendingId}")
    public ResponseEntity<LendingDTO> getLendingById(@PathVariable String lendingId) {
        return ResponseEntity.ok(lendingService.getLendingById(lendingId));
    }

    @GetMapping
    public ResponseEntity<List<LendingDTO>> getAllLending() {
        return ResponseEntity.ok(lendingService.getAllLending());
    }
}
