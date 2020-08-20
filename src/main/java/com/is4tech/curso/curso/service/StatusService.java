package com.is4tech.curso.curso.service;

import com.is4tech.curso.curso.dao.StatusRepository;

import java.util.ArrayList;
import java.util.List;
import com.is4tech.curso.curso.domain.Status;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StatusService {
    private final StatusRepository statusRepository;
    private final HealthServices healthServices;

    public StatusService(StatusRepository statusRepository, @Qualifier("adapter") HealthServices healthServices) {
        this.statusRepository = statusRepository;
        this.healthServices = healthServices;
    }

    public List<Status> findAll() {
        if (healthServices.isOk())
            return statusRepository.findAll();
        return new ArrayList<>();
    }
}
