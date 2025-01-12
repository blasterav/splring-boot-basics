package com.phoosop.spring_boot_basics.verification.internal.address_verification;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressVerificationPersistenceService {

    private final AddressVerificationRepository addressVerificationRepository;
    private final ConversionService conversionService;

    public void save(AddressVerificationDTO addressVerificationDTO) {
        AddressVerification addressVerification = conversionService.convert(addressVerificationDTO, AddressVerification.class);
        addressVerificationRepository.save(addressVerification);
    }

}
