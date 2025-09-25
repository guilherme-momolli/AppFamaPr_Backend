package br.edu.famapr.AppFamapr.repository;

import br.edu.famapr.AppFamapr.model.Matricula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MatriculaRepository extends JpaRepository<Matricula, Integer> {
    Optional<Matricula> findById(Long id);

}
