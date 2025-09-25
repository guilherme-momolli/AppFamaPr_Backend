package br.edu.famapr.AppFamapr.service;

import br.edu.famapr.AppFamapr.dto.pergunta.PerguntaRequestDTO;
import br.edu.famapr.AppFamapr.dto.pergunta.PerguntaResponseDTO;
import br.edu.famapr.AppFamapr.mapper.PerguntaMapper;
import br.edu.famapr.AppFamapr.model.Disciplina;
import br.edu.famapr.AppFamapr.model.Pergunta;
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
    private final PerguntaRepository perguntaRepository;
    private final DisciplinaRepository disciplinaRepository;
    private final PerguntaMapper perguntaMapper;

    public PerguntaService(PerguntaRepository perguntaRepository, DisciplinaRepository disciplinaRepository, PerguntaMapper perguntaMapper) {
        this.perguntaRepository = perguntaRepository;
        this.disciplinaRepository = disciplinaRepository;
        this.perguntaMapper = perguntaMapper;
    }

    public List<PerguntaResponseDTO> findAll() {
        return perguntaRepository.findAll()
                .stream()
                .map(PerguntaMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public Optional<PerguntaResponseDTO> findById(Integer id) {
        return perguntaRepository.findById(id).map(PerguntaMapper::toResponseDTO);
    }

    public PerguntaResponseDTO create(PerguntaRequestDTO dto) {
        Disciplina disciplina = disciplinaRepository.findById(dto.getDisciplinaId())
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));

        Pergunta pergunta = PerguntaMapper.toEntity(dto, disciplina);

        return perguntaMapper.toResponseDTO(perguntaRepository.save(pergunta));
    }

    public Optional<PerguntaResponseDTO> update(Integer id, PerguntaRequestDTO dto) {
        return perguntaRepository.findById(id).map(existing -> {
            existing.setTitulo(dto.getTitulo());
            return perguntaMapper.toResponseDTO(perguntaRepository.save(existing));
        });
    }

    public boolean delete(Integer id) {
        if (perguntaRepository.existsById(id)) {
            perguntaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
