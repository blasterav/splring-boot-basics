package com.phoosop.spring_boot_basics.user;

import com.phoosop.spring_boot_basics.exceptions.NotFoundException;
import com.phoosop.spring_boot_basics.registration.RegistrationApprovedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserPersistence userPersistence;
    private final ConversionService conversionService;

//    @ApplicationModuleListener
    @EventListener
    void listenOnRegistration(RegistrationApprovedEvent registrationApprovedEvent) {
        log.info("listenOnRegistration");
        UserDTO userDTO = conversionService.convert(registrationApprovedEvent.registrationDTO(), UserDTO.class);
        userPersistence.save(userDTO);
    }

    public UserDTO findFirstById(int id) {
        return userPersistence.findFirstById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

}
