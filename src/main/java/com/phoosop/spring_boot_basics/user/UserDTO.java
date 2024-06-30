package com.phoosop.spring_boot_basics.user;

public record UserDTO(Integer id,
                      String firstName,
                      String secondName,
                      String dateOfBirth,
                      UserType type,
                      UserStatus status) {
}
