package br.edu.famapr.AppFamapr.mapper;

import br.edu.famapr.AppFamapr.dto.avaliacao.AvaliacaoRequestDTO;
import br.edu.famapr.AppFamapr.dto.avaliacao.AvaliacaoResponseDTO;
import br.edu.famapr.AppFamapr.model.Avaliacao;
import br.edu.famapr.AppFamapr.model.Matricula;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AvaliacaoMapper {

    public static Avaliacao toEntity(AvaliacaoRequestDTO dto, Matricula matricula) {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setDataAvaliacao(dto.getDataAvaliacao() != null ? dto.getDataAvaliacao() : LocalDateTime.now());
        avaliacao.setMatricula(matricula);
        return avaliacao;
    }

    public static AvaliacaoResponseDTO toResponseDTO(Avaliacao entity) {
        AvaliacaoResponseDTO dto = new AvaliacaoResponseDTO();
        dto.setId(entity.getId());
        dto.setDataAvaliacao(entity.getDataAvaliacao());
        dto.setMatriculaId(entity.getMatricula().getId());
        return dto;
    }
}