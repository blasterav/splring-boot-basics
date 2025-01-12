package com.phoosop.spring_boot_basics.registration.internal.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "registration")
public record Registration(@Id
                    Integer id,
                    String firstName,
                    String secondName,
                    String dateOfBirth,
                    Integer status) {
}
