package com.phoosop.spring_boot_basics.verification.internal.id_verification;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IdVerificationPersistenceService {

    private final IdVerificationRepository idVerificationRepository;
    private final ConversionService conversionService;

    public void save(IdVerificationDTO idVerificationDTO) {
        IdVerification idVerification = conversionService.convert(idVerificationDTO, IdVerification.class);
        idVerificationRepository.save(idVerification);
    }
}
