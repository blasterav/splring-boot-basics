package com.phoosop.spring_boot_basics.user;

import com.phoosop.spring_boot_basics.user.internal.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
class UserController {

    private final UserService userService;
    private final ConversionService conversionService;

    @QueryMapping
    UserResponse getUserById(@Argument Integer id) {
        UserDTO userDTO = userService.getById(id);
        return conversionService.convert(userDTO, UserResponse.class);
    }

}
