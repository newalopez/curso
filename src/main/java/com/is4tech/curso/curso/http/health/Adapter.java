package com.is4tech.curso.curso.http.health;

import com.is4tech.curso.curso.service.HealthServices;
import org.springframework.stereotype.Component;

@Component
public class Adapter implements HealthServices {

    @Override
    public boolean isOk() {
        // apache http client connector
        // RestTemplate - spring
        return true;
    }
}
