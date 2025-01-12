package com.phoosop.spring_boot_basics.verification;

import com.phoosop.spring_boot_basics.verification.internal.address_verification.AddressVerificationPersistenceService;
import com.phoosop.spring_boot_basics.verification.internal.biometric_verification.BiometricVerificationDTO;
import com.phoosop.spring_boot_basics.verification.internal.biometric_verification.BiometricVerificationPersistenceService;
import com.phoosop.spring_boot_basics.verification.internal.id_verification.IdVerificationPersistenceService;
import com.phoosop.spring_boot_basics.verification.internal.passed_verification.PassedVerificationPersistenceService;
import com.phoosop.spring_boot_basics.verification.internal.verification_request.VerificationRequestPersistenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VerificationService {

    private final VerificationRequestPersistenceService verificationRequestPersistenceService;
    private final PassedVerificationPersistenceService passedVerificationPersistenceService;
    private final IdVerificationPersistenceService idVerificationPersistenceService;
    private final BiometricVerificationPersistenceService biometricVerificationPersistenceService;
    private final AddressVerificationPersistenceService addressVerificationPersistenceService;
    private final ConversionService conversionService;

    public void createBiometricVerificationRequest(CreateBiometricVerificationRequestDTO requestDTO) {
        
        BiometricVerificationDTO biometricVerificationDTO = conversionService.convert(requestDTO, BiometricVerificationDTO.class);

    }

}
