package com.github.oprokipchuk.helloworld.componenttest.cucumber.glue.util;

import com.github.oprokipchuk.helloworld.model.dto.GreetingBoardDTO;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static io.cucumber.spring.CucumberTestContext.SCOPE_CUCUMBER_GLUE;

@Component
@Scope(SCOPE_CUCUMBER_GLUE)
public class HelloClient {

    private static final String SERVER_URL = "http://localhost";

    @LocalServerPort
    private int port;
    private final RestTemplate restTemplate = new RestTemplate();

    private String endpoint() {
        return SERVER_URL + ":" + port;
    }

    private String url(String path) {
        return endpoint() + path;
    }

    public ResponseEntity<String> getHelloWorld() {
        return restTemplate.getForEntity(url("/"), String.class);
    }

    public GreetingBoardDTO getGreetingBoard() {
        return restTemplate.getForObject(url("/board"), GreetingBoardDTO.class);
    }
}
