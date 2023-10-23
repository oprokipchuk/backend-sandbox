package com.github.oprokipchuk.helloworld.repository;

import com.github.oprokipchuk.helloworld.model.entity.GreetingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<GreetingEntity, String> {
}
