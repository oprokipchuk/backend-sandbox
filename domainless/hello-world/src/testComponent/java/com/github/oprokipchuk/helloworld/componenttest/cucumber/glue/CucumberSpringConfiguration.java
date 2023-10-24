package com.github.oprokipchuk.helloworld.componenttest.cucumber.glue;

import com.github.oprokipchuk.helloworld.util.MariaDBMySQLContainer;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@CucumberContextConfiguration
@Testcontainers
@TestPropertySource(locations="classpath:component-test.properties")
@AutoConfigureWireMock(stubs = "file:src/testComponent/resources/mappings", port = 8001)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CucumberSpringConfiguration {

    @Container
    @ServiceConnection
    static MySQLContainer<MariaDBMySQLContainer> mySQLContainer;

    static {
        mySQLContainer = new MariaDBMySQLContainer(DockerImageName.parse("mysql:8"));
        mySQLContainer.start();
    }
}
