package com.diparth.springbootapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class QueryController {
    
    @RequestMapping("/")
    public String index() {
        return "Hello, World!";
    }

    @GetMapping("/query")
    public String getQuery() {
        return "GET /query";
    }

    @PostMapping("/query")
    public String postQuery() {
        return "POST /query";
    }
    
    @GetMapping("/queries")
    public String getAllQueries() {
        return "GET /queries";
    }
}
