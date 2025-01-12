package com.phoosop.spring_boot_basics.verification.internal.id_verification;

import org.springframework.data.repository.ListCrudRepository;

public interface IdVerificationRepository extends ListCrudRepository<IdVerification, Long> {
}
