package com.github.oprokipchuk.helloworld.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "greeting")
public class GreetingEntity {

    @Id
    @Column(nullable = false)
    private String id;

    @Column(nullable = false)
    private String language;

    @Column(nullable = false)
    private String message;
}
