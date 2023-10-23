package com.github.oprokipchuk.helloworld.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GreetingBoardDTO {

    private List<GreetingDTO> greetings;

    private String bonusJoke;
}
