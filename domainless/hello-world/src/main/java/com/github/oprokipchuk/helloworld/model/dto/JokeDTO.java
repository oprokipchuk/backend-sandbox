package com.github.oprokipchuk.helloworld.model.dto;

import lombok.Data;

@Data
public class JokeDTO {

    private String id;

    private String type;

    private String setup;

    private String punchline;
}
