package com.phoosop.spring_boot_basics.verification;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class VerificationController {

    private final VerificationService verificationService;

}
