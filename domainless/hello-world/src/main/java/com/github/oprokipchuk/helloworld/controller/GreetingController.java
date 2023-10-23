package com.github.oprokipchuk.helloworld.controller;

import com.github.oprokipchuk.helloworld.model.dto.GreetingBoardDTO;
import com.github.oprokipchuk.helloworld.service.GreetingBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class GreetingController {

    private final GreetingBoardService greetingBoardService;

    @GetMapping("/board")
    public GreetingBoardDTO board() {
        return greetingBoardService.getGreetingBoard();
    }
}
