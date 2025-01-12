package com.phoosop.spring_boot_basics.registration;

import com.phoosop.spring_boot_basics.common.RegistrationApprovedEvent;
import com.phoosop.spring_boot_basics.common.RegistrationStatus;
import com.phoosop.spring_boot_basics.exceptions.NotFoundException;
import com.phoosop.spring_boot_basics.exceptions.ServiceException;
import com.phoosop.spring_boot_basics.registration.internal.RegistrationPersistence;
import com.phoosop.spring_boot_basics.registration.internal.model.RegistrationCreateRequest;
import com.phoosop.spring_boot_basics.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RegistrationService {

    private final RegistrationPersistence registrationPersistence;
    private final ConversionService conversionService;
    private final ApplicationEventPublisher publisher;
    private final UserService userService;

    public RegistrationDTO getById(int id) {
        return registrationPersistence.findById(id)
                .orElseThrow(() -> new NotFoundException("Registration not found"));
    }

    public RegistrationDTO createRegistration(RegistrationCreateRequest registrationCreateRequest) {
        try {
            userService.getByFirstNameAndLastName(registrationCreateRequest.firstName(), registrationCreateRequest.secondName());
            throw new ServiceException("User with this first name and second name already exists");
        } catch (NotFoundException ignore) {
        }
        RegistrationDTO registrationDTO = conversionService.convert(registrationCreateRequest, RegistrationDTO.class);
        return registrationPersistence.save(registrationDTO);
    }

    public void updateStatus(int id, RegistrationStatus status) {
        log.info("updateStatus");
        RegistrationDTO originalRegistrationDTO = registrationPersistence.findById(id)
                .orElseThrow(() -> new NotFoundException("Registration not found"));
        if (status == RegistrationStatus.APPROVED) {
            RegistrationApprovedEvent registrationApprovedEvent = new RegistrationApprovedEvent(
                    originalRegistrationDTO.firstName(),
                    originalRegistrationDTO.secondName(),
                    originalRegistrationDTO.dateOfBirth());
            publisher.publishEvent(registrationApprovedEvent);
        }
    }

}
