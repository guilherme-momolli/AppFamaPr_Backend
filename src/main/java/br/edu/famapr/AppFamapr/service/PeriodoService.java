package br.edu.famapr.AppFamapr.service;

import br.edu.famapr.AppFamapr.dto.periodo.PeriodoRequestDTO;
import br.edu.famapr.AppFamapr.dto.periodo.PeriodoResponseDTO;
import br.edu.famapr.AppFamapr.mapper.PeriodoMapper;
import br.edu.famapr.AppFamapr.model.Curso;
import br.edu.famapr.AppFamapr.model.Periodo;
import br.edu.famapr.AppFamapr.repository.CursoRepository;
import br.edu.famapr.AppFamapr.repository.PeriodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PeriodoService {

    private final PeriodoRepository periodoRepository;
    private final CursoRepository cursoRepository;

    public PeriodoService(PeriodoRepository periodoRepository, CursoRepository cursoRepository) {
        this.periodoRepository = periodoRepository;
        this.cursoRepository = cursoRepository;
    }

    public List<PeriodoResponseDTO> findAll() {
        return periodoRepository.findAll()
                .stream()
                .map(PeriodoMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public Optional<PeriodoResponseDTO> findById(Integer id) {
        return periodoRepository.findById(id).map(PeriodoMapper::toResponseDTO);
    }

    public Optional<PeriodoResponseDTO> findByCursoId(Integer id) {
        return periodoRepository.findByCursoId(id).map(PeriodoMapper::toResponseDTO);
    }

    public PeriodoResponseDTO create(PeriodoRequestDTO dto) {
        Curso curso = cursoRepository.findById(dto.getCursoId())
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        Periodo periodo = PeriodoMapper.toEntity(dto, curso);
        return PeriodoMapper.toResponseDTO(periodoRepository.save(periodo));
    }

    public Optional<PeriodoResponseDTO> update(Integer id, PeriodoRequestDTO dto) {
        return periodoRepository.findById(id).map(periodo -> {
            Curso curso = cursoRepository.findById(dto.getCursoId())
                    .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

            periodo.setPeriodo(dto.getPeriodo());
            periodo.setAbreviacao(dto.getAbreviacao());
            periodo.setCurso(curso);

            return PeriodoMapper.toResponseDTO(periodoRepository.save(periodo));
        });
    }


    public boolean delete(Integer id) {
        return periodoRepository.findById(id).map(periodo -> {
            periodoRepository.delete(periodo);
            return true;
        }).orElse(false);
    }

}