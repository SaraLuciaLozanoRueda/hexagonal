package com.ejercicio.ejercicio.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ejercicio.ejercicio.models.User;

@RestController
@RequestMapping("/sara")
public class UserRestController {
    @GetMapping("/details")
    public Map<String, Object> details() {
        User user = new User("sara", "lozano");
        Map<String, Object> body = new HashMap<>();
        body.put("title", "Desarrollando con Spring boot CreativeCode");
        body.put("user", user);
        return body;
    }
}
