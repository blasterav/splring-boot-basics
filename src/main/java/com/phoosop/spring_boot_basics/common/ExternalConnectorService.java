package com.phoosop.spring_boot_basics.common;

import org.springframework.stereotype.Service;

@Service
public class ExternalConnectorService {

    public ExternalResponse getSomeData() {
        return new ExternalResponse("Something");
    }

}


