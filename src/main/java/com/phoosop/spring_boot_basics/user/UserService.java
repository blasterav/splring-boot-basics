package com.phoosop.spring_boot_basics.user;

import com.phoosop.spring_boot_basics.exceptions.NotFoundException;
import com.phoosop.spring_boot_basics.user.internal.UserPersistence;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserPersistence userPersistence;

    public UserDTO getById(int id) {
        return userPersistence.findFirstById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    public UserDTO getByFirstNameAndLastName(String firstName, String lastName) {
        return userPersistence.findByFirstNameAndLastName(firstName, lastName)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

}
