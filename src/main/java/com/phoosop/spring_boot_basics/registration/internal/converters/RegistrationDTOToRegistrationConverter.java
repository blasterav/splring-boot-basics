package com.phoosop.spring_boot_basics.registration.internal.converters;

import com.phoosop.spring_boot_basics.registration.internal.model.Registration;
import com.phoosop.spring_boot_basics.registration.RegistrationDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
class RegistrationDTOToRegistrationConverter implements Converter<RegistrationDTO, Registration> {
    @Override
    public Registration convert(RegistrationDTO source) {
        return new Registration(
                source.id(),
                source.firstName(),
                source.secondName(),
                source.dateOfBirth(),
                source.status().getId());
    }
}
