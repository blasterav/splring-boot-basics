package com.phoosop.spring_boot_basics.registration;

public record RegistrationResponse(
        Integer id,
        String firstName,
        String secondName,
        String dateOfBirth,
        Integer status) {

}