package com.phoosop.spring_boot_basics.user;

import org.springframework.data.repository.ListCrudRepository;

interface UserRepository extends ListCrudRepository<User, Integer> {
}
