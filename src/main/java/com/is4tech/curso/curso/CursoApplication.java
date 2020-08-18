package com.is4tech.curso.curso;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class CursoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CursoApplication.class, args);
    }

    @Bean
    public SpringLiquibase liquibase(DataSource dataSource) {
        SpringLiquibase sl = new SpringLiquibase();
        sl.setDataSource(dataSource);
        sl.setChangeLog("classpath:dbchangelog.xml");
        return sl;
    }

}
