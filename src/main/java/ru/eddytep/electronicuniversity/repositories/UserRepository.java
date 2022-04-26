package ru.eddytep.electronicuniversity.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.eddytep.electronicuniversity.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);


}