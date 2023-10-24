package com.github.oprokipchuk.helloworld.integrationtest;

import com.github.oprokipchuk.helloworld.model.entity.GreetingEntity;
import com.github.oprokipchuk.helloworld.util.MariaDBMySQLContainer;
import com.github.oprokipchuk.helloworld.repository.GreetingRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

import java.util.List;

@Testcontainers
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DatabaseIT {

    @Container
    @ServiceConnection
    static MySQLContainer<MariaDBMySQLContainer> mySQLContainer = new MariaDBMySQLContainer(DockerImageName.parse("mysql:8"));

    @Autowired
    private GreetingRepository greetingRepository;

    @Test
    void greeting_are_loaded_correctly() {
        // When
        List<GreetingEntity> greetings = greetingRepository.findAll();

        // Then
        Assertions.assertThat(greetings).hasSize(4);
    }
}
