package br.edu.famapr.AppFamapr.repository;

import br.edu.famapr.AppFamapr.model.Periodo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeriodoRepository extends JpaRepository<Periodo, Integer> {
    Optional<Periodo> findById(Integer id);

    Optional<Periodo> findByCursoId(Integer id);
}
