package com.phoosop.spring_boot_basics.verification.internal.biometric_verification;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BiometricVerificationPersistenceService {

    private final BiometricVerificationRepository biometricVerificationRepository;
    private final ConversionService conversionService;

    public void save(BiometricVerificationDTO biometricVerificationDTO) {
        BiometricVerification biometricVerification = conversionService.convert(biometricVerificationDTO, BiometricVerification.class);
        biometricVerificationRepository.save(biometricVerification);
    }

}
