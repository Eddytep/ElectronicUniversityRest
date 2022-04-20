package ru.eddytep.electronicuniversity.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.eddytep.electronicuniversity.domain.User;
import ru.eddytep.electronicuniversity.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(produces = "application/json")
    public Iterable<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/auth", produces = "application/json")
    public User getAuthorizeUser(
            @AuthenticationPrincipal User user
    ) {
        return user;
    }
}
