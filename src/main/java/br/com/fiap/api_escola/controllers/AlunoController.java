package br.com.fiap.api_escola.controllers;

import br.com.fiap.api_escola.models.Aluno;
import br.com.fiap.api_escola.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping
    public List<Aluno> listarTodos() {
        return alunoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarPorId(@PathVariable Long id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);
        return aluno.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Aluno criar(@RequestBody Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizar(@PathVariable Long id, @RequestBody Aluno dadosNovos) {
        Optional<Aluno> optional = alunoRepository.findById(id);
        if (optional.isEmpty()) return ResponseEntity.notFound().build();

        Aluno aluno = optional.get();
        aluno.setNome(dadosNovos.getNome());
        aluno.setEmail(dadosNovos.getEmail());
        aluno.setTurma(dadosNovos.getTurma());
        aluno.setMediaFinal(dadosNovos.getMediaFinal());
        aluno.setObservacao(dadosNovos.getObservacao());

        return ResponseEntity.ok(alunoRepository.save(aluno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (!alunoRepository.existsById(id)) return ResponseEntity.notFound().build();
        alunoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}