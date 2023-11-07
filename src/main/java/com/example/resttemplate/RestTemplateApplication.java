package com.example.resttemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class RestTemplateApplication {
    @Autowired
    ShawnMendesProxy shawnMendesClient;
    public static void main(String[] args) {
        SpringApplication.run(RestTemplateApplication.class, args);

    }
    @EventListener(ApplicationStartedEvent.class)
    public void makeRequestToShawnMend() {
        String response = shawnMendesClient.makeShawnMendesRequest("shawnmendes", 5);
        System.out.println(response);
    }

}
