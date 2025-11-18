package br.edu.famapr.AppFamapr.mapper;

import br.edu.famapr.AppFamapr.dto.avaliacao_pergunta.AvaliacaoPerguntaRequestDTO;
import br.edu.famapr.AppFamapr.dto.avaliacao_pergunta.AvaliacaoPerguntaResponseDTO;
import br.edu.famapr.AppFamapr.model.Avaliacao;
import br.edu.famapr.AppFamapr.model.AvaliacaoPergunta;

import java.util.stream.Collectors;

public class AvaliacaoPerguntaMapper {

    public static AvaliacaoPergunta toEntity(AvaliacaoPerguntaRequestDTO dto, Avaliacao avaliacao) {
        AvaliacaoPergunta pergunta = new AvaliacaoPergunta();

        pergunta.setTitulo(dto.getTitulo());
        pergunta.setTipoPergunta(dto.getTipoPergunta());
        pergunta.setOrdem(dto.getOrdem());
        pergunta.setObrigatoria(dto.getObrigatoria());
        pergunta.setAvaliacao(avaliacao);

        return pergunta;
    }


    public static AvaliacaoPerguntaResponseDTO toResponseDTO(AvaliacaoPergunta entity) {
        return new AvaliacaoPerguntaResponseDTO(
                entity.getId(),
                entity.getAvaliacao().getId(),
                entity.getTitulo(),
                entity.getTipoPergunta(),
                entity.getOrdem(),
                entity.getObrigatoria(),
                entity.getOpcoes().stream()
                        .map(AvaliacaoOpcaoMapper::toResponseDTO)
                        .collect(Collectors.toList())
        );
    }
}