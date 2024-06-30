package com.phoosop.spring_boot_basics.registration;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
class RegistrationPersistence {

    private final RegistrationRepository registrationRepository;
    private final ConversionService conversionService;

    Optional<RegistrationDTO> findById(int id) {
        return registrationRepository.findById(id)
                .map(item -> conversionService.convert(item, RegistrationDTO.class));
    }

    RegistrationDTO save(RegistrationDTO registrationDTO) {
        Registration registration = conversionService.convert(registrationDTO, Registration.class);
        registration =  registrationRepository.save(registration);
        return conversionService.convert(registration, RegistrationDTO.class);
    }

}
