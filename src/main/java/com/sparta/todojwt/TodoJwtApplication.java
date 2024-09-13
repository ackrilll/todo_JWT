package com.sparta.todojwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing

public class TodoJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoJwtApplication.class, args);
    }

}
