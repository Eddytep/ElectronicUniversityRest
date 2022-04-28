package ru.eddytep.electronicuniversity.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN,
    INSTRUCTOR,
    MANAGER,
    STUDENT,
    USER;

    @Override
    public String getAuthority() {
        return name();
    }
}
