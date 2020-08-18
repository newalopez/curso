package com.is4tech.curso.curso;

import com.is4tech.curso.curso.domain.bo.Status;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestPropertySource("classpath:application.properties")
class CursoApplicationTests {

    @Test
    void dummyTest() {
        Status status = new Status();
        status.setId(1);
        status.setDescription("hola");
        status.setName("name");
        assertEquals(1, status.getId());
        assertEquals("hola", status.getDescription());
        assertEquals("name", status.getName());
    }

}
