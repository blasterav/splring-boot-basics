package com.phoosop.spring_boot_basics.registration;


import org.springframework.data.repository.ListCrudRepository;

interface RegistrationRepository extends ListCrudRepository<Registration, Integer> {
}
