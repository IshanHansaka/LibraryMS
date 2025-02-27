package com.DevSprint.LibraryMS.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/health")
public class HealthTest {

    @GetMapping
    public String healthTest() {
        return "LibraryMS is running successfully";
    }
}
