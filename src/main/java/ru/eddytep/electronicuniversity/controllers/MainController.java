package ru.eddytep.electronicuniversity.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.eddytep.electronicuniversity.domain.User;

import java.util.HashMap;
import java.util.Objects;

@RestController
@RequestMapping("/api")
public class MainController {

    @GetMapping
    public String main(
            @AuthenticationPrincipal User user
    ) throws JsonProcessingException {
        HashMap<Object, Object> data = new HashMap<>();
        if (Objects.nonNull(user)) {
            user.setPassword("");
            data.put("profile", user);
        }
        String json = new ObjectMapper().writeValueAsString(data);
        return json;
    }

    @GetMapping("/second")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String second() {
        return "{\"message\": \"second\"}";
    }
}
