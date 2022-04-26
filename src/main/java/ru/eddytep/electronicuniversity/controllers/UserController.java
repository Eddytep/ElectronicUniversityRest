package ru.eddytep.electronicuniversity.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.eddytep.electronicuniversity.domain.User;
import ru.eddytep.electronicuniversity.repositories.UserRepository;
import ru.eddytep.electronicuniversity.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(produces = "application/json")
    public User createUser(@RequestBody User user) {
        userService.addUser(user);
        return user;
    }

    @GetMapping(produces = "application/json")
    public Iterable<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable("id") User user) {
        return user;
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public User update(
            @PathVariable("id") User userFromDb,
            @RequestBody User user
    ) {
        return userService.updateUser(user, userFromDb);
    }


    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void delete(@PathVariable("id") User user) {
        userService.delete(user);
    }

    @GetMapping(path = "/auth", produces = "application/json")
    public User getAuthorizeUser(
            @AuthenticationPrincipal User user
    ) {
        return user;
    }
}
