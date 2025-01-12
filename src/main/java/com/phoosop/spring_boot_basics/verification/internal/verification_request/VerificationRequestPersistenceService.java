package com.phoosop.spring_boot_basics.verification.internal.verification_request;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VerificationRequestPersistenceService {

    private final VerificationRequestRepository verificationRequestRepository;
    private final ConversionService conversionService;

    public void save(VerificationRequestDTO verificationRequestDTO) {
        VerificationRequest verificationRequest = conversionService.convert(verificationRequestDTO, VerificationRequest.class);
        verificationRequestRepository.save(verificationRequest);
    }
}
