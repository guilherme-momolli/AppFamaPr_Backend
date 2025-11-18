package br.edu.famapr.AppFamapr.mapper;

import br.edu.famapr.AppFamapr.dto.matricula.MatriculaRequestDTO;
import br.edu.famapr.AppFamapr.dto.matricula.MatriculaResponseDTO;
import br.edu.famapr.AppFamapr.model.Aluno;
import br.edu.famapr.AppFamapr.model.Disciplina;
import br.edu.famapr.AppFamapr.model.Matricula;
import org.springframework.stereotype.Component;

@Component
public class MatriculaMapper {

    public static Matricula toEntity(MatriculaRequestDTO dto, Aluno aluno, Disciplina disciplina) {
        Matricula matricula = new Matricula();
        matricula.setDatamatricula(dto.getDatamatricula());
        matricula.setStatus(dto.getStatus());
        matricula.setDatavigencia(dto.getDatavigencia());
        matricula.setAluno(aluno);
        matricula.setDisciplina(disciplina);
        return matricula;
    }

    public static MatriculaResponseDTO toResponseDTO(Matricula matricula) {
        MatriculaResponseDTO dto = new MatriculaResponseDTO();
        dto.setId(matricula.getId());
        dto.setDatamatricula(matricula.getDatamatricula());
        dto.setStatus(matricula.getStatus());
        dto.setDatavigencia(matricula.getDatavigencia());
        dto.setAlunoNome(matricula.getAluno() != null ? matricula.getAluno().getNome() : null);
        dto.setDisciplinaId(matricula.getDisciplina() != null ? matricula.getDisciplina().getId(): null);
        return dto;
    }
}