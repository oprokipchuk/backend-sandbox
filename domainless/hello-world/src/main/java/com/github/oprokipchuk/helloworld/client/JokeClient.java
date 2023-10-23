package com.github.oprokipchuk.helloworld.client;

import com.github.oprokipchuk.helloworld.model.dto.JokeDTO;

public interface JokeClient {

    JokeDTO getRandomJoke();
}
