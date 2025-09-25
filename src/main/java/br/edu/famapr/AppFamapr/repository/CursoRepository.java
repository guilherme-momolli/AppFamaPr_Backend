package br.edu.famapr.AppFamapr.repository;

import br.edu.famapr.AppFamapr.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
    Optional<Curso> findById(Long id);
}
