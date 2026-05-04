package br.com.fiap.api_escola.repositories;

import br.com.fiap.api_escola.models.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
}
