package br.com.fiap.api_escola.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfessorController {

    @GetMapping("/professores")
    public String listarProfessores() {
        return "Corpo Docente: Prof. Antonio Carlos de Lima Júnior, Profa. Ana Costa.";
    }
}