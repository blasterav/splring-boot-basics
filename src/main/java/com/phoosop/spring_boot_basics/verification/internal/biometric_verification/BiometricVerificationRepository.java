package com.phoosop.spring_boot_basics.verification.internal.biometric_verification;

import org.springframework.data.repository.ListCrudRepository;

public interface BiometricVerificationRepository extends ListCrudRepository<BiometricVerification, Long> {
}
