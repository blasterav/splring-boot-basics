package com.phoosop.spring_boot_basics;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.utility.DockerImageName;

@TestConfiguration(proxyBeanMethods = false)
public class SpringBootBasicsTestcontainersConfigs {

    @Bean
    @ServiceConnection
    public MySQLContainer mysqlContainer() {
        MySQLContainer mySQLContainer = new MySQLContainer(DockerImageName.parse("mysql:8.4.0"));
//                .withExposedPorts(3306, 3306);
        return mySQLContainer;
    }
}
