package br.edu.famapr.AppFamapr.repository;

import br.edu.famapr.AppFamapr.model.AvaliacaoPergunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoPerguntaRepository extends JpaRepository<AvaliacaoPergunta, Integer> {
    List<AvaliacaoPergunta> findByAvaliacaoId(Integer avaliacaoId);
}
