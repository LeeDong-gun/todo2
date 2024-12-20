package com.example.todo2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Todo2Application {

    public static void main(String[] args) {
        SpringApplication.run(Todo2Application.class, args);
    }

}
