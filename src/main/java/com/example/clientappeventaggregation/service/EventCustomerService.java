package com.example.clientappeventaggregation.service;

import com.example.clientappeventaggregation.dto.Event;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.util.List;

@Service

public class EventCustomerService {
    private final RestTemplate restTemplate;
    private final static String BASE_URL = "http://localhost:8080/event-client/";

    public EventCustomerService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public List<Event> getEvent() {
        return restTemplate.exchange(BASE_URL.concat("future"), HttpMethod.GET, null, new ParameterizedTypeReference<List<Event>>() {
        }).getBody();
    }

    public List<Event> getEventByDateByParametr(LocalDateTime fromDate, LocalDateTime toDate) {
        String firstParam = fromDate.toString();
        String secondParam = toDate.toString();

        UriComponentsBuilder builder = UriComponentsBuilder
                .fromUriString(BASE_URL.concat("date"))
                .queryParam("start", firstParam)
                .queryParam("end", secondParam);

        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<List<Event>>() {
        }).getBody();
    }
}