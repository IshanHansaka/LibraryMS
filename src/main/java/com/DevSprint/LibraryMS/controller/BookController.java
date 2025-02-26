package com.DevSprint.LibraryMS.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //handle http req & res
@RequestMapping("api/v1/books") //industry best practise
public class BookController {

    @GetMapping("/health")
    public String healthCheck() {
        return "Book Controller running";
    }
}
