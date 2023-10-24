package com.github.oprokipchuk.helloworld.componenttest.cucumber.glue.steps;

import com.github.oprokipchuk.helloworld.componenttest.cucumber.glue.util.HelloClient;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public class HelloWorldCucumberStepDefinitions {

    private ResponseEntity<String> helloWorldResponse;

    @Autowired
    private HelloClient client;

    @When("Call to GET \\/ is made")
    public void call_to_GET_is_made() {
        helloWorldResponse = client.getHelloWorld();
    }

    @Then("The response status code must be {int}")
    public void theResponseStatusCodeMustBe(int expectedStatusCode) {
        int actualStatusCode = helloWorldResponse.getStatusCode().value();
        Assertions.assertThat(actualStatusCode).isEqualTo(expectedStatusCode);
    }

    @And("{string} text must be returned")
    public void textMustBeReturned(String expectedText) {
        String actualText = helloWorldResponse.getBody();
        Assertions.assertThat(actualText).isEqualTo(expectedText);
    }
}
