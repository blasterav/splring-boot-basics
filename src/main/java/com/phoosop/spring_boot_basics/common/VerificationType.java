package com.phoosop.spring_boot_basics.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@AllArgsConstructor
@Getter
public enum VerificationType {

    ID(1),
    BIOMETRIC(2),
    ADDRESS(3);

    private final int id;

    public static Optional<VerificationType> find(int id) {
        return Arrays.stream(values())
                .filter(item -> item.getId() == id)
                .findFirst();
    }

}
