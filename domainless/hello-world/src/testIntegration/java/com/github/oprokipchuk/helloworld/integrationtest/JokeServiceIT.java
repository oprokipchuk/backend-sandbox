package com.github.oprokipchuk.helloworld.integrationtest;

import com.github.oprokipchuk.helloworld.client.JokeClient;
import com.github.oprokipchuk.helloworld.client.JokeClientImpl;
import com.github.oprokipchuk.helloworld.model.dto.JokeDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(classes = {RestTemplate.class, JokeClientImpl.class})
@TestPropertySource(locations="classpath:integration-test.properties")
@AutoConfigureWireMock(stubs = "file:src/testIntegration/resources/mappings", port = 8001)
public class JokeServiceIT {

    @Autowired
    private JokeClient jokeClient;

    @Test
    void test() {
        // Given
        JokeDTO expectedJoke = new JokeDTO(
                "317",
                "general",
                "Why did Dracula lie in the wrong coffin?",
                "He made a grave mistake.");

        // When
        JokeDTO actualJoke = jokeClient.getRandomJoke();

        // Then
        Assertions.assertThat(actualJoke).isEqualTo(expectedJoke);
    }
}
