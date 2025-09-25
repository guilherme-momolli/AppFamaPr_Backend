package br.edu.famapr.AppFamapr.mapper;

import br.edu.famapr.AppFamapr.dto.periodo.PeriodoRequestDTO;
import br.edu.famapr.AppFamapr.dto.periodo.PeriodoResponseDTO;
import br.edu.famapr.AppFamapr.model.Curso;
import br.edu.famapr.AppFamapr.model.Periodo;
import org.springframework.stereotype.Component;

@Component
public class PeriodoMapper {

    public static Periodo toEntity(PeriodoRequestDTO dto, Curso curso) {
        Periodo periodo = new Periodo();
        periodo.setPeriodo(dto.getPeriodo());
        periodo.setAbreviacao(dto.getAbreviacao());
        periodo.setCurso(curso);
        return periodo;
    }

    public static PeriodoResponseDTO toResponseDTO(Periodo periodo) {
        PeriodoResponseDTO dto = new PeriodoResponseDTO();
        dto.setId(periodo.getId());
        dto.setPeriodo(periodo.getPeriodo());
        dto.setAbreviacao(periodo.getAbreviacao());
        dto.setCursoNome(periodo.getCurso() != null ? periodo.getCurso().getNome() : null);
        return dto;
    }
}
