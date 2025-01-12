package com.phoosop.spring_boot_basics.verification.internal.verification_request;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("verification_request")
public record VerificationRequest(@Id Long id,
                                  Integer verificationType,
                                  Long userId,
                                  Integer status) {
}
