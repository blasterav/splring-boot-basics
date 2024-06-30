package com.phoosop.spring_boot_basics.registration;

public record RegistrationDTO(Integer id,
                              String firstName,
                              String secondName,
                              String dateOfBirth,
                              RegistrationStatus status) {

}
