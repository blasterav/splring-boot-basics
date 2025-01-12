package com.phoosop.spring_boot_basics.registration.internal;

import com.phoosop.spring_boot_basics.registration.internal.model.Registration;
import com.phoosop.spring_boot_basics.registration.RegistrationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegistrationPersistence {

    private final RegistrationRepository registrationRepository;
    private final ConversionService conversionService;

    public Optional<RegistrationDTO> findById(int id) {
        return registrationRepository.findById(id)
                .map(item -> conversionService.convert(item, RegistrationDTO.class));
    }

    public RegistrationDTO save(RegistrationDTO registrationDTO) {
        Registration registration = conversionService.convert(registrationDTO, Registration.class);
        registration =  registrationRepository.save(registration);
        return conversionService.convert(registration, RegistrationDTO.class);
    }

}
