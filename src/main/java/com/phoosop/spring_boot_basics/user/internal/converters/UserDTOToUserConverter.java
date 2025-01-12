package com.phoosop.spring_boot_basics.user.internal.converters;

import com.phoosop.spring_boot_basics.user.UserDTO;
import com.phoosop.spring_boot_basics.user.internal.User;
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
