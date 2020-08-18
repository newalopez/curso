package com.is4tech.curso.curso;

import com.is4tech.curso.curso.domain.bo.Status;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CursoApplicationTests {

    @Test
    void dummyTest() {
        Status status = new Status();
        status.setId(1);
        assertEquals(status.getId(), 1);
    }

}
