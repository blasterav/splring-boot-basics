package com.phoosop.spring_boot_basics.user;

import com.phoosop.spring_boot_basics.exceptions.ServiceException;
import com.phoosop.spring_boot_basics.registration.RegistrationDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
class UserDTOToUserConverter implements Converter<UserDTO, User> {
    @Override
    public User convert(UserDTO source) {
        return new User(
                source.id(),
                source.firstName(),
                source.secondName(),
                source.dateOfBirth(),
                source.type().getId(),
                source.status().getId());
    }
}

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

@Service
class UserDTOToUserResponseConverter implements Converter<UserDTO, UserResponse> {
    @Override
    public UserResponse convert(UserDTO source) {
        return new UserResponse(
                source.id(),
                source.firstName(),
                source.secondName(),
                source.dateOfBirth(),
                source.type().getId(),
                source.status().getId());
    }
}

@Service
class RegistrationDTOToUserDTOConverter implements Converter<RegistrationDTO, UserDTO> {
    @Override
    public UserDTO convert(RegistrationDTO source) {
        return new UserDTO(
                null,
                source.firstName(),
                source.secondName(),
                source.dateOfBirth(),
                UserType.REGULAR,
                UserStatus.ACTIVE);
    }
}
