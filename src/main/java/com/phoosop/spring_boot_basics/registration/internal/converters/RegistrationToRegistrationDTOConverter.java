package com.phoosop.spring_boot_basics.registration.internal.converters;

import com.phoosop.spring_boot_basics.exceptions.ServiceException;
import com.phoosop.spring_boot_basics.registration.internal.model.Registration;
import com.phoosop.spring_boot_basics.registration.RegistrationDTO;
import com.phoosop.spring_boot_basics.common.RegistrationStatus;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;


@Service
class RegistrationToRegistrationDTOConverter implements Converter<Registration, RegistrationDTO> {
    @Override
    public RegistrationDTO convert(Registration source) {
        RegistrationStatus status = RegistrationStatus.find(source.status())
                .orElseThrow(() -> new ServiceException("Invalid registration status"));
        return new RegistrationDTO(
                source.id(),
                source.firstName(),
                source.secondName(),
                source.dateOfBirth(),
                status);
    }
}

