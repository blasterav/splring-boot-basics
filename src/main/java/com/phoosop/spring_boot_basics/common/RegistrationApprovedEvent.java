package com.phoosop.spring_boot_basics.common;

public record RegistrationApprovedEvent(String firstName,
                                        String secondName,
                                        String dateOfBirth) {
}
