package com.phoosop.spring_boot_basics.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@AllArgsConstructor
@Getter
public enum RegistrationStatus {

    WAITING(1),
    APPROVED(2);

    private final int id;

    public static Optional<RegistrationStatus> find(int id) {
        return Arrays.stream(values())
                .filter(item -> item.getId() == id)
                .findFirst();
    }

}
