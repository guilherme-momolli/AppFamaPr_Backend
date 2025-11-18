package br.edu.famapr.AppFamapr.mapper;

import br.edu.famapr.AppFamapr.dto.resposta.RespostaRequestDTO;
import br.edu.famapr.AppFamapr.dto.resposta.RespostaResponseDTO;
import br.edu.famapr.AppFamapr.model.Avaliacao;
import br.edu.famapr.AppFamapr.model.Pergunta;
import br.edu.famapr.AppFamapr.model.Resposta;
import org.springframework.stereotype.Component;

@Component
public class RespostaMapper {

    public static Resposta toEntity(RespostaRequestDTO dto, Pergunta pergunta) {
        Resposta resposta = new Resposta();
        resposta.setRespostaNumero(dto.getRespostaNumero());
        resposta.setRespostaTexto(dto.getRespostaTexto());
        resposta.setPergunta(pergunta);
        return resposta;
    }

    public static RespostaResponseDTO toResponseDTO(Resposta entity) {
        RespostaResponseDTO dto = new RespostaResponseDTO();
        dto.setId(entity.getId());
        dto.setRespostaNumero(entity.getRespostaNumero());
        dto.setRespostaTexto(entity.getRespostaTexto());
        dto.setPerguntaId(entity.getPergunta().getId());
        return dto;
    }
}
