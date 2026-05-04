package br.com.fiap.api_escola.controllers;

import br.com.fiap.api_escola.models.Professor;
import br.com.fiap.api_escola.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professores")
public class ProfessorController {

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping
    public List<Professor> listarTodos() {
        return professorRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Professor> buscarPorId(@PathVariable Long id) {
        Optional<Professor> professor = professorRepository.findById(id);
        return professor.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Professor criar(@RequestBody Professor professor) {
        return professorRepository.save(professor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Professor> atualizar(@PathVariable Long id, @RequestBody Professor dadosNovos) {
        Optional<Professor> optional = professorRepository.findById(id);
        if (optional.isEmpty()) return ResponseEntity.notFound().build();

        Professor professor = optional.get();
        professor.setNome(dadosNovos.getNome());
        professor.setEmail(dadosNovos.getEmail());
        professor.setDisciplina(dadosNovos.getDisciplina());
        professor.setTitulacao(dadosNovos.getTitulacao());
        professor.setSala(dadosNovos.getSala());

        return ResponseEntity.ok(professorRepository.save(professor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!professorRepository.existsById(id)) return ResponseEntity.notFound().build();
        professorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}