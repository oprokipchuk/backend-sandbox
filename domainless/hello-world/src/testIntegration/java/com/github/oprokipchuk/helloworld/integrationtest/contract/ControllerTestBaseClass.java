package com.github.oprokipchuk.helloworld.integrationtest.contract;

import com.github.oprokipchuk.helloworld.controller.GreetingController;
import com.github.oprokipchuk.helloworld.controller.HelloWorldController;
import com.github.oprokipchuk.helloworld.model.dto.GreetingBoardDTO;
import com.github.oprokipchuk.helloworld.model.dto.GreetingDTO;
import com.github.oprokipchuk.helloworld.service.GreetingBoardService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

@WebMvcTest
public abstract class ControllerTestBaseClass {

    @Autowired
    HelloWorldController helloWorldController;

    @Autowired
    GreetingController greetingController;

    @MockBean
    GreetingBoardService greetingBoardService;

    @BeforeEach
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(helloWorldController, greetingController);
        Mockito.when(greetingBoardService.getGreetingBoard()).thenReturn(new GreetingBoardDTO(
                List.of(
                        new GreetingDTO("1", "Ukrainian", "Привіт"),
                        new GreetingDTO("2", "English", "Hello")),
                "A bonus Joke"
        ));
    }
}
