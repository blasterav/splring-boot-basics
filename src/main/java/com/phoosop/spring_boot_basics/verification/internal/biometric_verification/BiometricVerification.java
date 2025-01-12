package com.phoosop.spring_boot_basics.verification.internal.biometric_verification;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("biometric_verification")
public record BiometricVerification(@Id Long id,
                                    Long verificationRequestId) {
}
