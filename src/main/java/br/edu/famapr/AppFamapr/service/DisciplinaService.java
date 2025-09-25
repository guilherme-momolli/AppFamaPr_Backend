package br.edu.famapr.AppFamapr.service;

import br.edu.famapr.AppFamapr.dto.disciplina.DisciplinaRequestDTO;
import br.edu.famapr.AppFamapr.dto.disciplina.DisciplinaResponseDTO;
import br.edu.famapr.AppFamapr.mapper.DisciplinaMapper;
import br.edu.famapr.AppFamapr.model.Disciplina;
import br.edu.famapr.AppFamapr.model.Periodo;
import br.edu.famapr.AppFamapr.repository.DisciplinaRepository;
import br.edu.famapr.AppFamapr.repository.PeriodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;
    private final PeriodoRepository periodoRepository;

    public DisciplinaService(DisciplinaRepository disciplinaRepository,
                             PeriodoRepository periodoRepository) {
        this.disciplinaRepository = disciplinaRepository;
        this.periodoRepository = periodoRepository;
    }

    public List<DisciplinaResponseDTO> findAll() {
        return disciplinaRepository.findAll()
                .stream()
                .map(DisciplinaMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public Optional<DisciplinaResponseDTO> findById(Integer id) {
        return disciplinaRepository.findById(id)
                .map(DisciplinaMapper::toResponseDTO);
    }

    public DisciplinaResponseDTO create(DisciplinaRequestDTO dto) {
        Periodo periodo = periodoRepository.findById(dto.getPeriodoId())
                .orElseThrow(() -> new RuntimeException("Período não encontrado"));

        Disciplina disciplina = DisciplinaMapper.toEntity(dto, periodo);
        return DisciplinaMapper.toResponseDTO(disciplinaRepository.save(disciplina));
    }

    public Optional<DisciplinaResponseDTO> update(Integer id, DisciplinaRequestDTO dto) {
        return disciplinaRepository.findById(id).map(disciplina -> {
            Periodo periodo = periodoRepository.findById(dto.getPeriodoId())
                    .orElseThrow(() -> new RuntimeException("Período não encontrado"));

            disciplina.setNome(dto.getNome());
            disciplina.setAbreviacao(dto.getAbreviacao());
            disciplina.setCargahoraria(dto.getCargahoraria());
            disciplina.setAulassemanais(dto.getAulassemanais());
            disciplina.setPeriodo(periodo);

            return DisciplinaMapper.toResponseDTO(disciplinaRepository.save(disciplina));
        });
    }

    public boolean delete(Integer id) {
        return disciplinaRepository.findById(id).map(disciplina -> {
            disciplinaRepository.delete(disciplina);
            return true;
        }).orElse(false);
    }
}
