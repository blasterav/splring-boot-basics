package com.phoosop.spring_boot_basics.verification.internal.address_verification;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("address_verification")
public record AddressVerification(@Id Long id,
                                  Long verificationRequestId) {
}
