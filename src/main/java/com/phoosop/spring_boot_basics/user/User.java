package com.phoosop.spring_boot_basics.user;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("user")
record User(@Id Integer id,
            String firstName,
            String secondName,
            String dateOfBirth,
            Integer type,
            Integer status) {
}
