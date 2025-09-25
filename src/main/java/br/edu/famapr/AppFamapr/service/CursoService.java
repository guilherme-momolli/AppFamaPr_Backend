package br.edu.famapr.AppFamapr.service;

import br.edu.famapr.AppFamapr.dto.curso.CursoRequestDTO;
import br.edu.famapr.AppFamapr.dto.curso.CursoResponseDTO;
import br.edu.famapr.AppFamapr.mapper.CursoMapper;
import br.edu.famapr.AppFamapr.model.Curso;
import br.edu.famapr.AppFamapr.repository.CursoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoService {

    private final CursoRepository repository;
    private final CursoMapper mapper;

    public CursoService(CursoRepository repository, CursoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<CursoResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public CursoResponseDTO findById(Integer id) {
        Curso curso = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));
        return mapper.toResponseDTO(curso);
    }

    public CursoResponseDTO create(CursoRequestDTO dto) {
        Curso curso = mapper.toEntity(dto);
        Curso saved = repository.save(curso);
        return mapper.toResponseDTO(saved);
    }

    public CursoResponseDTO update(Integer id, CursoRequestDTO dto) {
        Curso curso = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso não encontrado"));

        curso.setNome(dto.getNome());
        curso.setAbreviacao(dto.getAbreviacao());

        Curso updated = repository.save(curso);
        return mapper.toResponseDTO(updated);
    }

    public void delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Curso não encontrado");
        }
        repository.deleteById(id);
    }
}
