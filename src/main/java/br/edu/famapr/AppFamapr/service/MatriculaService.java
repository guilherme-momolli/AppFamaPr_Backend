package br.edu.famapr.AppFamapr.service;

import br.edu.famapr.AppFamapr.dto.matricula.MatriculaRequestDTO;
import br.edu.famapr.AppFamapr.dto.matricula.MatriculaResponseDTO;
import br.edu.famapr.AppFamapr.mapper.MatriculaMapper;
import br.edu.famapr.AppFamapr.model.Aluno;
import br.edu.famapr.AppFamapr.model.Disciplina;
import br.edu.famapr.AppFamapr.model.Matricula;
import br.edu.famapr.AppFamapr.repository.AlunoRepository;
import br.edu.famapr.AppFamapr.repository.DisciplinaRepository;
import br.edu.famapr.AppFamapr.repository.MatriculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MatriculaService {

    private final MatriculaRepository matriculaRepository;
    private final AlunoRepository alunoRepository;
    private final DisciplinaRepository disciplinaRepository;

    public MatriculaService(MatriculaRepository matriculaRepository,
                            AlunoRepository alunoRepository,
                            DisciplinaRepository disciplinaRepository) {
        this.matriculaRepository = matriculaRepository;
        this.alunoRepository = alunoRepository;
        this.disciplinaRepository = disciplinaRepository;
    }

    public List<MatriculaResponseDTO> findAll() {
        return matriculaRepository.findAll()
                .stream()
                .map(MatriculaMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public Optional<MatriculaResponseDTO> findById(Integer id) {
        return matriculaRepository.findById(id)
                .map(MatriculaMapper::toResponseDTO);
    }

    public MatriculaResponseDTO create(MatriculaRequestDTO dto) {
        Aluno aluno = alunoRepository.findById(dto.getAlunoId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        Disciplina disciplina = disciplinaRepository.findById(dto.getDisciplinaId())
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));

        Matricula matricula = MatriculaMapper.toEntity(dto, aluno, disciplina);
        return MatriculaMapper.toResponseDTO(matriculaRepository.save(matricula));
    }

    public Optional<MatriculaResponseDTO> update(Integer id, MatriculaRequestDTO dto) {
        return matriculaRepository.findById(id).map(matricula -> {
            Aluno aluno = alunoRepository.findById(dto.getAlunoId())
                    .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

            Disciplina disciplina = disciplinaRepository.findById(dto.getDisciplinaId())
                    .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));

            matricula.setDatamatricula(dto.getDatamatricula());
            matricula.setStatus(dto.getStatus());
            matricula.setDatavigencia(dto.getDatavigencia());
            matricula.setAluno(aluno);
            matricula.setDisciplina(disciplina);

            return MatriculaMapper.toResponseDTO(matriculaRepository.save(matricula));
        });
    }

    public boolean delete(Integer id) {
        return matriculaRepository.findById(id).map(matricula -> {
            matriculaRepository.delete(matricula);
            return true;
        }).orElse(false);
    }
}
