package com.phoosop.spring_boot_basics.user.internal.converters;

import com.phoosop.spring_boot_basics.exceptions.ServiceException;
import com.phoosop.spring_boot_basics.user.UserDTO;
import com.phoosop.spring_boot_basics.common.UserStatus;
import com.phoosop.spring_boot_basics.common.UserType;
import com.phoosop.spring_boot_basics.user.internal.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
class UserEntityToUserDTOConverter implements Converter<User, UserDTO> {
    @Override
    public UserDTO convert(User source) {
        UserType userType = UserType.find(source.type())
                .orElseThrow(() -> new ServiceException("Invalid user type"));
        UserStatus userStatus = UserStatus.find(source.status())
                .orElseThrow(() -> new ServiceException("Invalid user status"));
        return new UserDTO(
                source.id(),
                source.firstName(),
                source.secondName(),
                source.dateOfBirth(),
                userType,
                userStatus);
    }
}

