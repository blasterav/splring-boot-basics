package com.phoosop.spring_boot_basics.registration;

import com.phoosop.spring_boot_basics.common.RegistrationStatus;

public record RegistrationDTO(Integer id,
                              String firstName,
                              String secondName,
                              String dateOfBirth,
                              RegistrationStatus status) {

}
