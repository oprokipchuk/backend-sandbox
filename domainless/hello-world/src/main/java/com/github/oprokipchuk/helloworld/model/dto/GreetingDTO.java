package com.github.oprokipchuk.helloworld.model.dto;

import lombok.Data;

@Data
public class GreetingDTO {

    private String id;

    private String language;

    private String message;
}
