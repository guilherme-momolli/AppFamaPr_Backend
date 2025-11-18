package br.edu.famapr.AppFamapr.repository;

import br.edu.famapr.AppFamapr.model.AvaliacaoResposta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoRespostaRepository extends JpaRepository<AvaliacaoResposta, Integer> {

    List<AvaliacaoResposta> findByAvaliacaoId(Integer avaliacaoId);

    List<AvaliacaoResposta> findByPerguntaId(Integer perguntaId);

    List<AvaliacaoResposta> findByAlunoId(Integer alunoId);

}
