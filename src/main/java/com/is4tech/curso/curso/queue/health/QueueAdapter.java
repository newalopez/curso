package com.is4tech.curso.curso.queue.health;

import com.is4tech.curso.curso.service.HealthServices;
import org.springframework.stereotype.Component;

@Component
public class QueueAdapter implements HealthServices {
    @Override
    public boolean isOk() {
        // connect by QUEUE , read queue
        return true;
    }
}
