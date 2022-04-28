package ru.eddytep.electronicuniversity.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.eddytep.electronicuniversity.domain.User;
import ru.eddytep.electronicuniversity.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @PostMapping(produces = "application/json")
//    public User createUser(@RequestBody User user) {
//        userService.addUser(user, false);
//        return user;
//    }

    @GetMapping(produces = "application/json")
    public Iterable<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("{id}")
    public User getUserById(@PathVariable("id") User user) {
        return user;
    }

    @PatchMapping("{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public User update(
            @PathVariable("id") User userFromDb,
            @RequestBody User user
    ) {
        return userService.updateUser(user, userFromDb);
    }


    @DeleteMapping(path = "{id}", produces = "application/json")
    @PreAuthorize("hasAuthority('ADMIN')")
    public User delete(@PathVariable("id") User user) {
        if (userService.findById(user.getId()).isPresent()){
            userService.delete(user);
        }
        return user;
    }

    @GetMapping(path = "/auth", produces = "application/json")
    public User getAuthorizeUser(
            @AuthenticationPrincipal User user
    ) {
        return user;
    }
}
