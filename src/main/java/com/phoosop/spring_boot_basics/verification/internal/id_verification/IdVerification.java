package com.phoosop.spring_boot_basics.verification.internal.id_verification;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("id_verification")
public record IdVerification(@Id Long id,
                             Long verificationRequestId) {
}
