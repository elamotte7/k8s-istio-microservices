package com.sedona.test.microservicespring.b.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloWorldController {

    private static final String template = "Hello, %s from Spring service B v2!";

    @GetMapping
    public ResponseEntity<String> greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(String.format(template, name));
    }
}