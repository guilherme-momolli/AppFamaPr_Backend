package br.edu.famapr.AppFamapr.repository;

import br.edu.famapr.AppFamapr.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer> {

}
