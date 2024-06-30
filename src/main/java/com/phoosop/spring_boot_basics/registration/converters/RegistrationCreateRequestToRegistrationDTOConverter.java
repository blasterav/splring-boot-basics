package com.phoosop.spring_boot_basics.registration.converters;

import com.phoosop.spring_boot_basics.registration.RegistrationCreateRequest;
import com.phoosop.spring_boot_basics.registration.RegistrationDTO;
import com.phoosop.spring_boot_basics.registration.RegistrationStatus;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
class RegistrationCreateRequestToRegistrationDTOConverter implements Converter<RegistrationCreateRequest, RegistrationDTO> {
    @Override
    public RegistrationDTO convert(RegistrationCreateRequest source) {
        return new RegistrationDTO(
                null,
                source.firstName(),
                source.secondName(),
                source.dateOfBirth(),
                RegistrationStatus.WAITING);
    }
}
