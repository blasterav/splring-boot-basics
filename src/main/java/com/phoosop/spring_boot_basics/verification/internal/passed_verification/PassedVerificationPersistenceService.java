package com.phoosop.spring_boot_basics.verification.internal.passed_verification;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PassedVerificationPersistenceService {

    private final PassedVerificationRepository passedVerificationRepository;
    private final ConversionService conversionService;

    public void save(PassedVerificationDTO passedVerificationDTO) {
        PassedVerification passedVerification = conversionService.convert(passedVerificationDTO, PassedVerification.class);
        passedVerificationRepository.save(passedVerification);
    }

}
