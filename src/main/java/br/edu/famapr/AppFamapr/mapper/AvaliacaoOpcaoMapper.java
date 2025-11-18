package br.edu.famapr.AppFamapr.mapper;

import br.edu.famapr.AppFamapr.dto.avaliacao_opcao.AvaliacaoOpcaoRequestDTO;
import br.edu.famapr.AppFamapr.dto.avaliacao_opcao.AvaliacaoOpcaoResponseDTO;
import br.edu.famapr.AppFamapr.model.AvaliacaoOpcao;
import br.edu.famapr.AppFamapr.model.AvaliacaoPergunta;

public class AvaliacaoOpcaoMapper {

    public static AvaliacaoOpcao toEntity(AvaliacaoOpcaoRequestDTO dto, AvaliacaoPergunta pergunta) {
        AvaliacaoOpcao opcao = new AvaliacaoOpcao();
        opcao.setPergunta(pergunta);
        opcao.setDescricao(dto.getDescricao());
        opcao.setValor(dto.getValor());
        opcao.setOrdem(dto.getOrdem());
        return opcao;
    }

    public static AvaliacaoOpcaoResponseDTO toResponseDTO(AvaliacaoOpcao opcao) {
        return new AvaliacaoOpcaoResponseDTO(
                opcao.getId(),
                opcao.getPergunta().getId(),
                opcao.getDescricao(),
                opcao.getValor(),
                opcao.getOrdem()
        );
    }
}