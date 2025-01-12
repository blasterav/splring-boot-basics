package com.phoosop.spring_boot_basics.registration.internal;


import com.phoosop.spring_boot_basics.registration.internal.model.Registration;
import org.springframework.data.repository.ListCrudRepository;

interface RegistrationRepository extends ListCrudRepository<Registration, Integer> {
}
