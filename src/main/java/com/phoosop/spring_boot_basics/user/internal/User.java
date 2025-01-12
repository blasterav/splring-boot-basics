package com.phoosop.spring_boot_basics.user.internal;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("user")
public record User(@Id Integer id,
            String firstName,
            String secondName,
            String dateOfBirth,
            Integer type,
            Integer status) {
}
