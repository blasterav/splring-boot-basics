package com.phoosop.spring_boot_basics.registration;

import com.phoosop.spring_boot_basics.common.ExternalConnectorService;
import com.phoosop.spring_boot_basics.common.ExternalResponse;
import com.phoosop.spring_boot_basics.exceptions.NotFoundException;
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
    private final ExternalConnectorService externalConnectorService;

    RegistrationDTO findFirstById(int id) {
        return registrationPersistence.findById(id)
                .orElseThrow(() -> new NotFoundException("Registration not found"));
    }

    RegistrationDTO createRegistration(RegistrationCreateRequest registrationCreateRequest) {
        RegistrationDTO registrationDTO = conversionService.convert(registrationCreateRequest, RegistrationDTO.class);
        return registrationPersistence.save(registrationDTO);
    }

    void updateStatus(int id, RegistrationStatus status) {
        log.info("updateStatus");
        RegistrationDTO originalRegistrationDTO = registrationPersistence.findById(id)
                .orElseThrow(() -> new NotFoundException("Registration not found"));
        RegistrationDTO updatedRegistrationDTO = new RegistrationDTO(
                id,
                originalRegistrationDTO.firstName(),
                originalRegistrationDTO.secondName(),
                originalRegistrationDTO.dateOfBirth(),
                status);
        ExternalResponse externalResponse = externalConnectorService.getSomeData();
        System.out.println(externalResponse.toString());
        publisher.publishEvent(new RegistrationApprovedEvent(updatedRegistrationDTO));
    }

}
