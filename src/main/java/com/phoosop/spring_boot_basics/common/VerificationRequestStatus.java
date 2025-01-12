package com.phoosop.spring_boot_basics.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;

@AllArgsConstructor
@Getter
public enum VerificationRequestStatus {

    WAITING(1),
    MANUALLY_APPROVED(2),
    AUTO_APPROVED(3),
    MANUALLY_REJECTED(4),
    AUTO_REJECTED(5);

    private final int id;

    public static Optional<VerificationRequestStatus> find(int id) {
        return Arrays.stream(values())
                .filter(item -> item.getId() == id)
                .findFirst();
    }

}
