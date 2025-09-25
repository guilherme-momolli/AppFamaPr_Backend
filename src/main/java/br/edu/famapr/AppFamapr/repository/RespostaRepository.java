package br.edu.famapr.AppFamapr.repository;

import br.edu.famapr.AppFamapr.model.Resposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RespostaRepository extends JpaRepository<Resposta, Integer> {
    Optional<Resposta> findById(Long id);

}
