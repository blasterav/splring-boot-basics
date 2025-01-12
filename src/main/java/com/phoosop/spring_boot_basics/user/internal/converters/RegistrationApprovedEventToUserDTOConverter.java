package com.phoosop.spring_boot_basics.user.internal.converters;

import com.phoosop.spring_boot_basics.common.RegistrationApprovedEvent;
import com.phoosop.spring_boot_basics.user.UserDTO;
import com.phoosop.spring_boot_basics.common.UserStatus;
import com.phoosop.spring_boot_basics.common.UserType;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
class RegistrationApprovedEventToUserDTOConverter implements Converter<RegistrationApprovedEvent, UserDTO> {
    @Override
    public UserDTO convert(RegistrationApprovedEvent source) {
        return new UserDTO(
                null,
                source.firstName(),
                source.secondName(),
                source.dateOfBirth(),
                UserType.REGULAR,
                UserStatus.ACTIVE);
    }
}
