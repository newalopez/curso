package com.is4tech.curso.curso.http.health;

import com.is4tech.curso.curso.service.HealthServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Adapter implements HealthServices {
    private static final String DEMO2_URL = "http://demo2/api/items/100";
    private static final Logger logger = LoggerFactory.getLogger(Adapter.class);
    private final RestTemplate restTemplate;

    public Adapter(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public boolean isOk() {
        ResponseEntity<String> exchange = restTemplate.exchange(DEMO2_URL, HttpMethod.GET, null, String.class);
        logger.info("http status: {}, message {}.", exchange.getStatusCode(), exchange.getBody());
        return exchange.getStatusCode().is2xxSuccessful();
    }
}
