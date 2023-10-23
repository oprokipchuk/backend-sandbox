package com.github.oprokipchuk.helloworld.service;

import com.github.oprokipchuk.helloworld.model.converter.GreetingConverter;
import com.github.oprokipchuk.helloworld.model.dto.GreetingDTO;
import com.github.oprokipchuk.helloworld.model.entity.GreetingEntity;
import com.github.oprokipchuk.helloworld.repository.GreetingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class GreetingServiceImpl implements GreetingService {

    private final GreetingRepository greetingRepository;

    @Override
    public List<GreetingDTO> getGreetings() {
        List<GreetingEntity> greetingEntities = greetingRepository.findAll();
        log.info("Getting greetings. Found: [{}] entities", greetingEntities.size());
        return greetingEntities.stream().map(GreetingConverter::toDTO).toList();
    }
}
