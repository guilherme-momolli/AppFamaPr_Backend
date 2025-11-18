package br.edu.famapr.AppFamapr.mapper;

import br.edu.famapr.AppFamapr.dto.avaliacao.AvaliacaoRequestDTO;
import br.edu.famapr.AppFamapr.dto.avaliacao.AvaliacaoResponseDTO;
import br.edu.famapr.AppFamapr.dto.avaliacao_pergunta.AvaliacaoPerguntaResponseDTO;
import br.edu.famapr.AppFamapr.model.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class AvaliacaoMapper {

    public static Avaliacao toEntity(AvaliacaoRequestDTO dto, Matricula matricula) {

        Avaliacao avaliacao = new Avaliacao();

        avaliacao.setMatricula(matricula);
        avaliacao.setTipoAvaliacao(dto.getTipoAvaliacao());

        if (dto.getPerguntas() != null) {
            List<AvaliacaoPergunta> perguntas = dto.getPerguntas().stream()
                    .map(p -> AvaliacaoPerguntaMapper.toEntity(p, avaliacao))
                    .toList();

            avaliacao.setPerguntas(perguntas);
        }

        return avaliacao;
    }


    public static AvaliacaoResponseDTO toResponseDTO(Avaliacao avaliacao) {

        List<AvaliacaoPerguntaResponseDTO> perguntasDTO = avaliacao.getPerguntas().stream()
                .map(AvaliacaoPerguntaMapper::toResponseDTO)
                .collect(Collectors.toList());

        return new AvaliacaoResponseDTO(
                avaliacao.getId(),
                avaliacao.getDataAvaliacao(),
                avaliacao.getMatricula().getId(),
                avaliacao.getTipoAvaliacao(),
                perguntasDTO
        );
    }
}