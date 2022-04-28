package ru.eddytep.electronicuniversity.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.Map;

@RestController
@RequestMapping("/")
@Slf4j
public class MainController {

    @Value("${project.url.client}")
    private String clientUrl;

    @GetMapping
    public ResponseEntity<Void> main(@RequestParam Map<String,String> input) throws IOException {
        log.debug(String.valueOf(input));
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create(clientUrl))
                .build();
    }

}
