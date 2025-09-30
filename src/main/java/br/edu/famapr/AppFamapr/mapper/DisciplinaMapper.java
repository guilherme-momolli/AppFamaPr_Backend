package br.edu.famapr.AppFamapr.mapper;

import br.edu.famapr.AppFamapr.dto.disciplina.DisciplinaRequestDTO;
import br.edu.famapr.AppFamapr.dto.disciplina.DisciplinaResponseDTO;
import br.edu.famapr.AppFamapr.model.Disciplina;
import br.edu.famapr.AppFamapr.model.Periodo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.Mapping;

@Component
public class DisciplinaMapper {

    public static Disciplina toEntity(DisciplinaRequestDTO dto, Periodo periodo) {
        Disciplina disciplina = new Disciplina();
        disciplina.setNome(dto.getNome());
        disciplina.setAbreviacao(dto.getAbreviacao());
        disciplina.setCargahoraria(dto.getCargahoraria());
        disciplina.setAulassemanais(dto.getAulassemanais());
        disciplina.setPeriodo(periodo);
        return disciplina;
    }

    public static DisciplinaResponseDTO toResponseDTO(Disciplina disciplina) {
        DisciplinaResponseDTO dto = new DisciplinaResponseDTO();
        dto.setId(disciplina.getId());
        dto.setNome(disciplina.getNome());
        dto.setAbreviacao(disciplina.getAbreviacao());
        dto.setCargahoraria(disciplina.getCargahoraria());
        dto.setAulassemanais(disciplina.getAulassemanais());
        dto.setPeriodoId(
                disciplina.getPeriodo() != null ? disciplina.getPeriodo().getId() : null
        );
        return dto;
    }

}