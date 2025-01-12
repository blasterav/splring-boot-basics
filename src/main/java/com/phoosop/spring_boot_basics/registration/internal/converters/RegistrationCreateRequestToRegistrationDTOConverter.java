package com.phoosop.spring_boot_basics.registration.internal.converters;

import com.phoosop.spring_boot_basics.registration.internal.model.RegistrationCreateRequest;
import com.phoosop.spring_boot_basics.registration.RegistrationDTO;
import com.phoosop.spring_boot_basics.common.RegistrationStatus;
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
