package com.phoosop.spring_boot_basics.user;

import com.phoosop.spring_boot_basics.common.UserStatus;
import com.phoosop.spring_boot_basics.common.UserType;

public record UserDTO(Integer id,
                      String firstName,
                      String secondName,
                      String dateOfBirth,
                      UserType type,
                      UserStatus status) {
}
