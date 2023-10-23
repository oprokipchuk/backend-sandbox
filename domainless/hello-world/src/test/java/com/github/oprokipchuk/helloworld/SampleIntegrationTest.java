package com.github.oprokipchuk.helloworld;

import com.github.oprokipchuk.helloworld.repository.GreetingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleIntegrationTest {

    @Container
    @ServiceConnection
    static MySQLContainer<MariaDBMySQLContainer> mySQLContainer = new MariaDBMySQLContainer(DockerImageName.parse("mysql:8"));

    @Autowired
    private GreetingRepository greetingRepository;

    @Test
    void sampleTest() {
        System.out.println("Lol");
    }
}
