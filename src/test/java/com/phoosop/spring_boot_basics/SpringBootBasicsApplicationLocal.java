package com.phoosop.spring_boot_basics;

import org.springframework.boot.SpringApplication;

public class SpringBootBasicsApplicationLocal {

    public static void main(String[] args) {
        SpringApplication.from(SpringBootBasicsApplication::main)
                .with(SpringBootBasicsTestcontainersConfigs.class)
                .run(args);
    }
}
