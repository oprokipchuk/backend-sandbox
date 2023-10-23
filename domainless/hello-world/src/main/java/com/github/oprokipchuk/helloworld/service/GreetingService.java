package com.github.oprokipchuk.helloworld.service;

import com.github.oprokipchuk.helloworld.model.dto.GreetingDTO;

import java.util.List;

public interface GreetingService {

    List<GreetingDTO> getGreetings();
}
