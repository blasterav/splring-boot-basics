package com.phoosop.spring_boot_basics.user.internal;

import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

interface UserRepository extends ListCrudRepository<User, Integer> {

    Optional<User> findByFirstNameAndLastName(String firstName, String lastName);

}
