package com.phoosop.spring_boot_basics.registration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;


@Slf4j
@Controller
@RequiredArgsConstructor
class RegistrationController {

    private final RegistrationService registrationService;
    private final ConversionService conversionService;

    @QueryMapping
    RegistrationResponse getRegistrationById(Integer id) {
        RegistrationDTO registrationDTO = registrationService.findFirstById(id);
        return conversionService.convert(registrationDTO, RegistrationResponse.class);
    }

    @MutationMapping
    RegistrationResponse createRegistration(@Argument RegistrationCreateRequest registrationCreateRequest) {
        RegistrationDTO registrationDTO = registrationService.createRegistration(registrationCreateRequest);
        return conversionService.convert(registrationDTO, RegistrationResponse.class);
    }

    @MutationMapping
    Boolean approveRegistration(@Argument Integer id) {
        registrationService.updateStatus(id, RegistrationStatus.APPROVED);
        return true;
    }
}
