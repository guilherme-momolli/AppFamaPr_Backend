package br.edu.famapr.AppFamapr.mapper;

import br.edu.famapr.AppFamapr.dto.curso.CursoRequestDTO;
import br.edu.famapr.AppFamapr.dto.curso.CursoResponseDTO;
import br.edu.famapr.AppFamapr.model.Curso;
import org.springframework.stereotype.Component;

@Component
public class CursoMapper {

    public Curso toEntity(CursoRequestDTO dto) {
        Curso curso = new Curso();
        curso.setNome(dto.getNome());
        curso.setAbreviacao(dto.getAbreviacao());
        return curso;
    }

    public CursoResponseDTO toResponseDTO(Curso curso) {
        CursoResponseDTO dto = new CursoResponseDTO();
        dto.setId(curso.getId());
        dto.setNome(curso.getNome());
        dto.setAbreviacao(curso.getAbreviacao());
        return dto;
    }
}
