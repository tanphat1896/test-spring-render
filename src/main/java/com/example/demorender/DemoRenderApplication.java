package com.example.demorender;

import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootApplication
@RestController
public class DemoRenderApplication {

    @Data
    @Builder
    public static class Payload {
        private String id;
        private String date;
    }

    @Value("${MYSQL_DATABASE}")
    private String MYSQL_DATABASE;

    @GetMapping("/")
    public Payload test() {
        System.out.println("===============> " + MYSQL_DATABASE);
        return Payload.builder().id(UUID.randomUUID().toString()).date(LocalDateTime.now().toString()).build();
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoRenderApplication.class, args);
    }

}
