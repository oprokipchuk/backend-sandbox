package com.github.oprokipchuk.helloworld.model.converter;

import com.github.oprokipchuk.helloworld.model.dto.GreetingDTO;
import com.github.oprokipchuk.helloworld.model.entity.GreetingEntity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GreetingConverter {

    public static GreetingDTO toDTO(GreetingEntity entity) {
        GreetingDTO dto = new GreetingDTO();
        dto.setId(entity.getId());
        dto.setLanguage(entity.getLanguage());
        dto.setMessage(entity.getMessage());
        return dto;
    }

    public static GreetingEntity toEntity(GreetingDTO dto) {
        GreetingEntity entity = new GreetingEntity();
        entity.setId(dto.getId());
        entity.setLanguage(dto.getLanguage());
        entity.setMessage(dto.getMessage());
        return entity;
    }
}
