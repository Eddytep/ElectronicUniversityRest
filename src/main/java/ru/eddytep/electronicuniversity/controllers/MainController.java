package ru.eddytep.electronicuniversity.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {

    @GetMapping
    public String main(
    ) {
        return "main";
    }

    @GetMapping("/second")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String second() {
        return "{\"message\": \"second\"}";
    }
}
