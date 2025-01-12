package com.phoosop.spring_boot_basics.registration.internal.converters;

import com.phoosop.spring_boot_basics.registration.RegistrationDTO;
import com.phoosop.spring_boot_basics.registration.internal.model.RegistrationResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
class RegistrationDTOToRegistrationResponseConverter implements Converter<RegistrationDTO, RegistrationResponse> {
    @Override
    public RegistrationResponse convert(RegistrationDTO source) {
        return new RegistrationResponse(
                source.id(),
                source.firstName(),
                source.secondName(),
                source.dateOfBirth(),
                source.status().getId());
    }
}
