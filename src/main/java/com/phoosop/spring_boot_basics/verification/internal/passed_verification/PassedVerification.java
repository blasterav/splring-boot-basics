package com.phoosop.spring_boot_basics.verification.internal.passed_verification;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("passed_verification")
public record PassedVerification(@Id Integer id,
                                 Long userId,
                                 Integer verificationType) {
}
