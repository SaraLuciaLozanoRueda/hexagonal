package com.ejercicio.ejercicio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ejercicio.ejercicio.models.User;

@Controller
public class UserController {
    @GetMapping("/details")
    public String details(Model model){
        User user = new User("sara", "lozano");
        model.addAttribute("title", "Desarrollo de Springboot");
        model.addAttribute("encabezado", "pagina personal");
        model.addAttribute("USER", user);
        return "details";
    }
}
