package com.github.oprokipchuk.helloworld.service;

import com.github.oprokipchuk.helloworld.client.JokeClient;
import com.github.oprokipchuk.helloworld.model.dto.GreetingBoardDTO;
import com.github.oprokipchuk.helloworld.model.dto.GreetingDTO;
import com.github.oprokipchuk.helloworld.model.dto.JokeDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class GreetingBoardServiceImpl implements GreetingBoardService {

    private final GreetingService greetingService;

    private final JokeClient jokeClient;

    @Override
    public GreetingBoardDTO getGreetingBoard() {
        List<GreetingDTO> greetings = greetingService.getGreetings();
        JokeDTO randomJoke = jokeClient.getRandomJoke();
        log.info("Making a greeting board from greetings and a joke...");
        return new GreetingBoardDTO(
                greetings,
                jokeAsSpeech(randomJoke));
    }

    private String jokeAsSpeech(JokeDTO joke) {
        return joke.getSetup() + " " + joke.getPunchline();
    }
}
