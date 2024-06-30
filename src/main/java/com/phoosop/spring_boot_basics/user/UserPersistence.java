package com.phoosop.spring_boot_basics.user;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
class UserPersistence {

    private final UserRepository userRepository;
    private final ConversionService conversionService;

    Optional<UserDTO> findFirstById(int id) {
        return userRepository.findById(id)
                .map(item -> conversionService.convert(item, UserDTO.class));
    }

    UserDTO save(UserDTO userDTO) {
        User user = conversionService.convert(userDTO, User.class);
        user = userRepository.save(user);
        return conversionService.convert(user, UserDTO.class);
    }

}
