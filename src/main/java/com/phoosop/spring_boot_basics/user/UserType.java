package com.phoosop.spring_boot_basics.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@AllArgsConstructor
@Getter
public enum UserType {

    REGULAR(1),
    PREMIUM(2);

    private final int id;

    public static Optional<UserType> find(int id) {
        return Arrays.stream(values())
                .filter(item -> item.getId() == id)
                .findFirst();
    }

}
