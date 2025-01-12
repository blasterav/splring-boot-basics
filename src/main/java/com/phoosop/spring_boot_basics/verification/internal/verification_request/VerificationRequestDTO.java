package com.phoosop.spring_boot_basics.verification.internal.verification_request;

public record VerificationRequestDTO(Long id,
                                     Integer verificationType,
                                     Long userId,
                                     Integer status) {
}
