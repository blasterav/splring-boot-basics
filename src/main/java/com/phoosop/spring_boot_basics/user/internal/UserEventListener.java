package com.phoosop.spring_boot_basics.user.internal;

import com.phoosop.spring_boot_basics.common.RegistrationApprovedEvent;
import com.phoosop.spring_boot_basics.user.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.core.convert.ConversionService;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserEventListener {

    private final UserPersistence userPersistence;
    private final ConversionService conversionService;

    @EventListener
    void listenOnRegistration(RegistrationApprovedEvent registrationApprovedEvent) {
        log.info("listenOnRegistration");

        UserDTO userDTO = conversionService.convert(registrationApprovedEvent, UserDTO.class);
        userPersistence.save(userDTO);
    }

}
