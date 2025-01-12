package com.phoosop.spring_boot_basics.verification.internal.address_verification;

import org.springframework.data.repository.ListCrudRepository;

public interface AddressVerificationRepository extends ListCrudRepository<AddressVerification, Long> {
}
