package br.edu.famapr.AppFamapr.service;

import br.edu.famapr.AppFamapr.dto.avaliacao.AvaliacaoRequestDTO;
import br.edu.famapr.AppFamapr.dto.avaliacao.AvaliacaoResponseDTO;
import br.edu.famapr.AppFamapr.mapper.AvaliacaoMapper;
import br.edu.famapr.AppFamapr.mapper.AvaliacaoPerguntaMapper;
import br.edu.famapr.AppFamapr.model.Avaliacao;
import br.edu.famapr.AppFamapr.model.AvaliacaoPergunta;
import br.edu.famapr.AppFamapr.model.Disciplina;
import br.edu.famapr.AppFamapr.model.Matricula;
import br.edu.famapr.AppFamapr.repository.AvaliacaoRepository;
import br.edu.famapr.AppFamapr.repository.MatriculaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AvaliacaoService {

    private final AvaliacaoRepository avaliacaoRepository;
    private final MatriculaRepository matriculaRepository;

    public AvaliacaoService(
            AvaliacaoRepository avaliacaoRepository,
            MatriculaRepository matriculaRepository
    ) {
        this.avaliacaoRepository = avaliacaoRepository;
        this.matriculaRepository = matriculaRepository;
    }

    @Transactional
    public AvaliacaoResponseDTO create(AvaliacaoRequestDTO dto) {

        Matricula matricula = matriculaRepository.findById(dto.getMatriculaId())
                .orElseThrow(() -> new RuntimeException("Matrícula não encontrada"));

        Avaliacao avaliacao = AvaliacaoMapper.toEntity(dto, matricula);

        if (avaliacao.getPerguntas() != null) {
            avaliacao.getPerguntas().forEach(p -> p.setAvaliacao(avaliacao));
        }

        Avaliacao saved = avaliacaoRepository.save(avaliacao);
        return AvaliacaoMapper.toResponseDTO(saved);
    }


    public AvaliacaoResponseDTO findById(Integer id) {
        Avaliacao avaliacao = avaliacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Avaliação não encontrada"));

        return AvaliacaoMapper.toResponseDTO(avaliacao);
    }

    public List<AvaliacaoResponseDTO> findAll() {
        return avaliacaoRepository.findAll()
                .stream()
                .map(AvaliacaoMapper::toResponseDTO)
                .toList();
    }

    @Transactional
    public AvaliacaoResponseDTO update(Integer id, AvaliacaoRequestDTO dto) {

        Avaliacao existente = avaliacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Avaliação não encontrada"));

        existente.setTipoAvaliacao(dto.getTipoAvaliacao());
        existente.getPerguntas().clear();

        if (dto.getPerguntas() != null) {
            dto.getPerguntas().forEach(perguntaDTO -> {
                AvaliacaoPergunta pergunta = AvaliacaoPerguntaMapper.toEntity(perguntaDTO, existente);
                existente.getPerguntas().add(pergunta);
            });
        }

        Avaliacao atualizado = avaliacaoRepository.save(existente);
        return AvaliacaoMapper.toResponseDTO(atualizado);
    }

    @Transactional
    public void delete(Integer id) {
        if (!avaliacaoRepository.existsById(id)) {
            throw new RuntimeException("Avaliação não encontrada");
        }
        avaliacaoRepository.deleteById(id);
    }
}
