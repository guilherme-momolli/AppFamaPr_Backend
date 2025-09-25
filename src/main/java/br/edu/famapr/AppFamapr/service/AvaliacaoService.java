package br.edu.famapr.AppFamapr.service;

import br.edu.famapr.AppFamapr.dto.avaliacao.AvaliacaoRequestDTO;
import br.edu.famapr.AppFamapr.dto.avaliacao.AvaliacaoResponseDTO;
import br.edu.famapr.AppFamapr.mapper.AvaliacaoMapper;
import br.edu.famapr.AppFamapr.model.Avaliacao;
import br.edu.famapr.AppFamapr.model.Matricula;
import br.edu.famapr.AppFamapr.repository.AvaliacaoRepository;
import br.edu.famapr.AppFamapr.repository.MatriculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AvaliacaoService {

    private final AvaliacaoRepository avaliacaoRepository;
    private final MatriculaRepository matriculaRepository;
    private final AvaliacaoMapper avaliacaoMapper;

    public AvaliacaoService(AvaliacaoRepository avaliacaoRepository,
                            MatriculaRepository matriculaRepository,
                            AvaliacaoMapper avaliacaoMapper) {
        this.avaliacaoRepository = avaliacaoRepository;
        this.matriculaRepository = matriculaRepository;
        this.avaliacaoMapper = avaliacaoMapper;
    }

    public List<AvaliacaoResponseDTO> findAll() {
        return avaliacaoRepository.findAll()
                .stream()
                .map(AvaliacaoMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public Optional<AvaliacaoResponseDTO> findById(Integer id) {
        return avaliacaoRepository.findById(id)
                .map(AvaliacaoMapper::toResponseDTO);
    }

    public AvaliacaoResponseDTO create(AvaliacaoRequestDTO dto) {
        Matricula matricula = matriculaRepository.findById(dto.getMatriculaId())
                .orElseThrow(() -> new RuntimeException("Matrícula não encontrada"));

        Avaliacao avaliacao = AvaliacaoMapper.toEntity(dto, matricula);

        return avaliacaoMapper.toResponseDTO(avaliacaoRepository.save(avaliacao));
    }

    public Optional<AvaliacaoResponseDTO> update(Integer id, AvaliacaoRequestDTO dto) {
        return avaliacaoRepository.findById(id).map(existing -> {
            existing.setDataAvaliacao(dto.getDataAvaliacao());
            if (dto.getMatriculaId() != null) {
                Matricula matricula = matriculaRepository.findById(dto.getMatriculaId())
                        .orElseThrow(() -> new RuntimeException("Matrícula não encontrada"));
                existing.setMatricula(matricula);
            }
            Avaliacao atualizado = avaliacaoRepository.save(existing);
            return avaliacaoMapper.toResponseDTO(atualizado);
        });
    }

    public boolean delete(Integer id) {
        if (avaliacaoRepository.existsById(id)) {
            avaliacaoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}