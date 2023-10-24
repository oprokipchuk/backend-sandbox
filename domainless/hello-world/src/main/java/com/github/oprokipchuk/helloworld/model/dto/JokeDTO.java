package com.github.oprokipchuk.helloworld.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JokeDTO {

    private String id;

    private String type;

    private String setup;

    private String punchline;
}
