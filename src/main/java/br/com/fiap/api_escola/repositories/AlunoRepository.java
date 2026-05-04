package br.com.fiap.api_escola.repositories;

import br.com.fiap.api_escola.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
