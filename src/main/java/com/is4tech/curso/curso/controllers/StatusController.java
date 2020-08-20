package com.is4tech.curso.curso.controllers;

import com.is4tech.curso.curso.domain.Status;
import com.is4tech.curso.curso.service.StatusService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/status")
@ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Resource created"),
        @ApiResponse(responseCode = "400", description = "Invalid request"),
        @ApiResponse(responseCode = "404", description = "Resource not found") })
public class StatusController {
    private final StatusService statusService;
    private final Logger logger = LoggerFactory.getLogger(StatusController.class);

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping(produces = "application/json")
    @Operation(summary = "Search status",
            description = "Search status", tags = { "Status" })
    public ResponseEntity<List<Status>> findAll() {
        try {
            return ResponseEntity.ok(statusService.findAll());
        } catch (DataAccessException dataAccessException) {
            logger.error("Error accessing data.", dataAccessException);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
