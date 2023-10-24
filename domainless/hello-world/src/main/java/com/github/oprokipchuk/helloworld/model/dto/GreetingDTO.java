package com.github.oprokipchuk.helloworld.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GreetingDTO {

    private String id;

    private String language;

    private String message;
}
