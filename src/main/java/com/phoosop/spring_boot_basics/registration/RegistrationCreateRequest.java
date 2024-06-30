package com.phoosop.spring_boot_basics.registration;

import lombok.Builder;

@Builder
public record RegistrationCreateRequest(String firstName,
                                 String secondName,
                                 String dateOfBirth) {

}
