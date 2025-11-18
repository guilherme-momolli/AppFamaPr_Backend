package br.edu.famapr.AppFamapr.service;

import br.edu.famapr.AppFamapr.dto.pergunta.PerguntaRequestDTO;
import br.edu.famapr.AppFamapr.dto.pergunta.PerguntaResponseDTO;
import br.edu.famapr.AppFamapr.mapper.PerguntaMapper;
import br.edu.famapr.AppFamapr.model.Avaliacao;
import br.edu.famapr.AppFamapr.model.Disciplina;
import br.edu.famapr.AppFamapr.model.Pergunta;
import br.edu.famapr.AppFamapr.repository.AvaliacaoRepository;
import br.edu.famapr.AppFamapr.repository.DisciplinaRepository;
import br.edu.famapr.AppFamapr.repository.PerguntaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PerguntaService {

    @Autowired
    private PerguntaRepository perguntaRepository;

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public PerguntaResponseDTO create(PerguntaRequestDTO dto) {
        Avaliacao avaliacao = avaliacaoRepository.findById(dto.getAvaliacaoId())
                .orElseThrow(() -> new RuntimeException("Avaliação não encontrada"));
        Pergunta pergunta = PerguntaMapper.toEntity(dto, avaliacao);
        return PerguntaMapper.toResponseDTO(perguntaRepository.save(pergunta));
    }

    public List<PerguntaResponseDTO> findAll() {
        return perguntaRepository.findAll().stream()
                .map(PerguntaMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public PerguntaResponseDTO findById(Integer id) {
        Pergunta pergunta = perguntaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pergunta não encontrada"));
        return PerguntaMapper.toResponseDTO(pergunta);
    }

    public PerguntaResponseDTO update(Integer id, PerguntaRequestDTO dto) {
        Pergunta pergunta = perguntaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pergunta não encontrada"));
        Avaliacao avaliacao = avaliacaoRepository.findById(dto.getAvaliacaoId())
                .orElseThrow(() -> new RuntimeException("Avaliação não encontrada"));

        pergunta.setTitulo(dto.getTitulo());
        pergunta.setAvaliacao(avaliacao);

        return PerguntaMapper.toResponseDTO(perguntaRepository.save(pergunta));
    }

    public void delete(Integer id) {
        Pergunta pergunta = perguntaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pergunta não encontrada"));
        perguntaRepository.delete(pergunta);
    }
}
