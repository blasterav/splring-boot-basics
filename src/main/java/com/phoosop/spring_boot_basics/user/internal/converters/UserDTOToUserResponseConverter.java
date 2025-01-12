package com.phoosop.spring_boot_basics.user.internal.converters;

import com.phoosop.spring_boot_basics.user.UserDTO;
import com.phoosop.spring_boot_basics.user.internal.UserResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

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
