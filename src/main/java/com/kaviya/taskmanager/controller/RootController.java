package com.kaviya.taskmanager.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class RootController {

    @GetMapping({"/", "/api"})
    public Map<String, Object> root() {
        return Map.of(
                "service", "taskmanager",
                "status", "ok",
                "message", "API is running. Use /api/auth/* and /api/tasks/* endpoints."
        );
    }
}
