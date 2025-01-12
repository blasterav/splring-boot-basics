package com.phoosop.spring_boot_basics.user.internal;

import com.phoosop.spring_boot_basics.user.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserPersistence {

    private final UserRepository userRepository;
    private final ConversionService conversionService;

    public Optional<UserDTO> findFirstById(int id) {
        return userRepository.findById(id)
                .map(item -> conversionService.convert(item, UserDTO.class));
    }

    public Optional<UserDTO> findByFirstNameAndLastName(String firstName, String lastName) {
        return userRepository.findByFirstNameAndLastName(firstName, lastName)
                .map(item -> conversionService.convert(item, UserDTO.class));
    }

    public UserDTO save(UserDTO userDTO) {
        User user = conversionService.convert(userDTO, User.class);
        user = userRepository.save(user);
        return conversionService.convert(user, UserDTO.class);
    }

}
