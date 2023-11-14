package com.example.resttemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

// GET https://itunes.apple.com/search?term=shawnmendes&limit=1
@Component
public class ShawnMendesProxy {
    @Value("${shawnmendes.service.url}")
    String url;

    @Autowired
    RestTemplate restTemplate;

    public ShawnMendesResponse makeShawnMendesRequest(String term, Integer limit) throws JsonProcessingException {

        String uri = url + "/search?term=" + term + "&limit=" + limit;
        ResponseEntity<String> response = restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                String.class
        );
        String json = response.getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, ShawnMendesResponse.class);
    }
}
