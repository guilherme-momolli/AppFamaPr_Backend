package br.edu.famapr.AppFamapr.mapper;

import br.edu.famapr.AppFamapr.dto.avaliacao_resposta.AvaliacaoRespostaRequestDTO;
import br.edu.famapr.AppFamapr.dto.avaliacao_resposta.AvaliacaoRespostaResponseDTO;
import br.edu.famapr.AppFamapr.model.*;

public class AvaliacaoRespostaMapper {

    public static AvaliacaoResposta toEntity(
            AvaliacaoRespostaRequestDTO dto,
            Avaliacao avaliacao,
            AvaliacaoPergunta pergunta,
            Aluno aluno,
            AvaliacaoOpcao opcao
    ) {

        AvaliacaoResposta resposta = new AvaliacaoResposta();

        resposta.setAvaliacao(avaliacao);
        resposta.setPergunta(pergunta);
        resposta.setAluno(aluno);
        resposta.setOpcao(opcao);
        resposta.setRespostaTexto(dto.getRespostaTexto());
        resposta.setValorNumerico(dto.getValorNumerico());

        return resposta;
    }

    public static AvaliacaoRespostaResponseDTO toResponseDTO(AvaliacaoResposta resposta)
    {
        return new AvaliacaoRespostaResponseDTO(
                resposta.getId(),
                resposta.getAvaliacao().getId(),
                resposta.getPergunta().getId(),
                resposta.getAluno().getId(),
                resposta.getOpcao() != null ? resposta.getOpcao().getId() : null,
                resposta.getRespostaTexto(),
                resposta.getValorNumerico(),
                resposta.getRespondidoEm()
        );
    }
}
