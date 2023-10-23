package com.github.oprokipchuk.helloworld;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class SampleIT {

    @Test
    void integrationTest() {
        System.out.println("This is an integration test");
        Assertions.assertThat(false).isTrue();
    }
}
