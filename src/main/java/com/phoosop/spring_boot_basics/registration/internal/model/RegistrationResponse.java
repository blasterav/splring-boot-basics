package com.phoosop.spring_boot_basics.registration.internal.model;

public record RegistrationResponse(
        Integer id,
        String firstName,
        String secondName,
        String dateOfBirth,
        Integer status) {

}