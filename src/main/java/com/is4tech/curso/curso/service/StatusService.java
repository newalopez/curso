package com.is4tech.curso.curso.service;

import com.is4tech.curso.curso.dao.StatusRepository;
import java.util.List;
import com.is4tech.curso.curso.domain.Status;
import org.springframework.stereotype.Service;

@Service
public class StatusService {
    private final StatusRepository statusRepository;

    public StatusService(StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    public List<Status> findAll() {
        return statusRepository.findAll();
    }
}
