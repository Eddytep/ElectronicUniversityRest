package ru.eddytep.electronicuniversity.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.eddytep.electronicuniversity.domain.Role;
import ru.eddytep.electronicuniversity.domain.User;
import ru.eddytep.electronicuniversity.repositories.UserRepository;

import java.util.Collections;
import java.util.Objects;

@Service
@Slf4j
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }



    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (Objects.nonNull(user)) {
            return user;
        }
        throw new UsernameNotFoundException("User '" + username + "' not found");
    }

    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    public boolean addUser(User user) {
        User userFromDb = userRepository.findByUsername(user.getUsername());
        if (Objects.nonNull(userFromDb)) {
            return false;
        }
        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return true;
    }

    public User updateUser(User editedUser, User userFromDb) {
        BeanUtils.copyProperties(editedUser, userFromDb, "id");
        User updatedUser = userRepository.save(userFromDb);
        return updatedUser;
    }

    public void delete(User user) {
        if (!"admin".equals(user.getUsername())) {
            userRepository.delete(user);
        } else {
            log.warn("Attempt to remove an administrator. There must be at least one administrator in the system.");
        }
    }

}
