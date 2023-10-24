package com.github.oprokipchuk.helloworld.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GreetingBoardDTO {

    private List<GreetingDTO> greetings;

    private String bonusJoke;
}
