package com.github.oprokipchuk.helloworld.client;

import com.github.oprokipchuk.helloworld.model.dto.JokeDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Slf4j
@Service
public class JokeClientImpl implements JokeClient {

    private final RestTemplate restTemplate;

    @Value("${jokes.random.url}")
    private String randomJokeUrl;

    @Override
    public JokeDTO getRandomJoke() {
        JokeDTO joke = restTemplate.getForObject(randomJokeUrl, JokeDTO.class);
        log.info("A random joke loaded: {}", joke);
        return joke;
    }
}
