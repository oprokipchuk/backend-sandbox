package com.github.oprokipchuk.helloworld.componenttest.cucumber.glue.steps;

import com.github.oprokipchuk.helloworld.componenttest.cucumber.glue.util.HelloClient;
import com.github.oprokipchuk.helloworld.model.dto.GreetingBoardDTO;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

public class GreetingBoardCucumberStepDefinitions {

    private GreetingBoardDTO greetingBoardDTO;

    @Autowired
    private HelloClient client;

    @When("Call to GET \\/board is made")
    public void callToGETBoardIsMade() {
        greetingBoardDTO = client.getGreetingBoard();
    }

    @Then("The response must contain {int} greetings")
    public void theResponseMustContainGreetings(int expectedNumberOfGreetings) {
        int actualNumberOfGreetings = greetingBoardDTO.getGreetings().size();
        Assertions.assertThat(actualNumberOfGreetings).isEqualTo(expectedNumberOfGreetings);
    }

    @And("{string} must be a bonus joke")
    public void mustBeABonusJoke(String expectedJoke) {
        String actualJoke = greetingBoardDTO.getBonusJoke();
        Assertions.assertThat(actualJoke).isEqualTo(expectedJoke);
    }
}
