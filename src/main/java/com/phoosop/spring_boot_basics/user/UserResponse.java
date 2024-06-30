package com.phoosop.spring_boot_basics.user;

public record UserResponse(Integer id,
                           String firstName,
                           String secondName,
                           String dateOfBirth,
                           Integer type,
                           Integer status) {

}
