package com.is4tech.curso.curso;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@WebAppConfiguration
@TestPropertySource("classpath:application.properties")
class CursoApplicationTests {
    private MockMvc mvc;
    @Autowired
    private final WebApplicationContext context;

    CursoApplicationTests(WebApplicationContext context) {
        this.context = context;
    }

    @BeforeEach
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    void statusControllerTest() throws Exception {
        this.mvc.perform(
                MockMvcRequestBuilders.get("/api/status")
                        .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andDo(MockMvcResultHandlers.print());

    }

    @Test
    void statusControllerTestNonExistent() throws Exception {
        this.mvc.perform(
                MockMvcRequestBuilders.get("/api/status2")
                        .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().is4xxClientError())
                .andDo(MockMvcResultHandlers.print());

    }

}
