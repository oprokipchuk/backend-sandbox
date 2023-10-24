package com.github.oprokipchuk.helloworld.service;

import com.github.oprokipchuk.helloworld.client.JokeClient;
import com.github.oprokipchuk.helloworld.model.dto.GreetingBoardDTO;
import com.github.oprokipchuk.helloworld.model.dto.GreetingDTO;
import com.github.oprokipchuk.helloworld.model.dto.JokeDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class GreetingBoardServiceImplTest {

    @Mock
    private GreetingService greetingService;

    @Mock
    private JokeClient jokeClient;

    @InjectMocks
    private GreetingBoardServiceImpl service;

    @Test
    public void getting_board_composes_a_board_from_db_data_and_joke_service() {
        // Given
        List<GreetingDTO> expectedGreetings = List.of(
                new GreetingDTO("1", "eng", "hello"));
        JokeDTO expectedJokeDTO = new JokeDTO("1", "type", "Setup", "Punchline");
        String expectedJoke = "Setup Punchline";
        GreetingBoardDTO expectedGreetingBoard = new GreetingBoardDTO(expectedGreetings, expectedJoke);

        Mockito.when(greetingService.getGreetings()).thenReturn(expectedGreetings);
        Mockito.when(jokeClient.getRandomJoke()).thenReturn(expectedJokeDTO);

        // When
        GreetingBoardDTO actualGreetingBoard = service.getGreetingBoard();

        Assertions.assertThat(actualGreetingBoard).isEqualTo(expectedGreetingBoard);
    }
}