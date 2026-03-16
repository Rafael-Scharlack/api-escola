package br.com.fiap.api_escola.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlunoController {

    @GetMapping("/alunos")
    public String listarAlunos() {
        return "Sistema Escolar: 30 alunos na Turma A, 28 alunos na Turma B.";
    }

    @GetMapping("/alunos/notas")
    public String muralDeNotas() {
        return "Mural de Notas: O aluno com a melhor média do semestre é Pedro Henrique (Média 9.8).";
    }
}