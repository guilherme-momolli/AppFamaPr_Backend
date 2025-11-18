package br.edu.famapr.AppFamapr.service;

import br.edu.famapr.AppFamapr.dto.avaliacao_pergunta.AvaliacaoPerguntaRequestDTO;
import br.edu.famapr.AppFamapr.dto.avaliacao_pergunta.AvaliacaoPerguntaResponseDTO;
import br.edu.famapr.AppFamapr.mapper.AvaliacaoOpcaoMapper;
import br.edu.famapr.AppFamapr.mapper.AvaliacaoPerguntaMapper;
import br.edu.famapr.AppFamapr.model.Avaliacao;
import br.edu.famapr.AppFamapr.model.AvaliacaoOpcao;
import br.edu.famapr.AppFamapr.model.AvaliacaoPergunta;
import br.edu.famapr.AppFamapr.repository.AvaliacaoPerguntaRepository;
import br.edu.famapr.AppFamapr.repository.AvaliacaoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AvaliacaoPerguntaService {

    private final AvaliacaoPerguntaRepository perguntaRepository;
    private final AvaliacaoRepository avaliacaoRepository;

    public AvaliacaoPerguntaService(
            AvaliacaoPerguntaRepository perguntaRepository,
            AvaliacaoRepository avaliacaoRepository
    ) {
        this.perguntaRepository = perguntaRepository;
        this.avaliacaoRepository = avaliacaoRepository;
    }

    @Transactional
    public AvaliacaoPerguntaResponseDTO create(AvaliacaoPerguntaRequestDTO dto) {

        Avaliacao avaliacao = avaliacaoRepository.findById(dto.getAvaliacaoId())
                .orElseThrow(() -> new RuntimeException("Avaliação não encontrada"));

        AvaliacaoPergunta pergunta = AvaliacaoPerguntaMapper.toEntity(dto, avaliacao);

        if (pergunta.getOpcoes() != null) {
            pergunta.getOpcoes().forEach(op -> op.setPergunta(pergunta));
        }

        AvaliacaoPergunta saved = perguntaRepository.save(pergunta);
        return AvaliacaoPerguntaMapper.toResponseDTO(saved);
    }


    public AvaliacaoPerguntaResponseDTO findById(Integer id) {
        AvaliacaoPergunta pergunta = perguntaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pergunta não encontrada"));

        return AvaliacaoPerguntaMapper.toResponseDTO(pergunta);
    }

    public List<AvaliacaoPerguntaResponseDTO> findAllByAvaliacao(Integer avaliacaoId) {
        return perguntaRepository.findByAvaliacaoId(avaliacaoId)
                .stream()
                .map(AvaliacaoPerguntaMapper::toResponseDTO)
                .toList();
    }

    @Transactional
    public AvaliacaoPerguntaResponseDTO update(Integer id, AvaliacaoPerguntaRequestDTO dto) {

        AvaliacaoPergunta existente = perguntaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pergunta não encontrada"));

        existente.setTitulo(dto.getTitulo());
        existente.setTipoPergunta(dto.getTipoPergunta());
        existente.setObrigatoria(dto.getObrigatoria());
        existente.setOrdem(dto.getOrdem());

        existente.getOpcoes().clear();

        if (dto.getOpcoes() != null) {
            dto.getOpcoes().forEach(opDTO -> {
                AvaliacaoOpcao opcao = AvaliacaoOpcaoMapper.toEntity(opDTO, existente);
                existente.getOpcoes().add(opcao);
            });
        }

        AvaliacaoPergunta atualizado = perguntaRepository.save(existente);
        return AvaliacaoPerguntaMapper.toResponseDTO(atualizado);
    }


    @Transactional
    public void delete(Integer id) {
        if (!perguntaRepository.existsById(id)) {
            throw new RuntimeException("Pergunta não encontrada");
        }
        perguntaRepository.deleteById(id);
    }
}
