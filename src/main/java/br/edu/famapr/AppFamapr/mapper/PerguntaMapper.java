package br.edu.famapr.AppFamapr.mapper;

import br.edu.famapr.AppFamapr.dto.pergunta.PerguntaRequestDTO;
import br.edu.famapr.AppFamapr.dto.pergunta.PerguntaResponseDTO;
import br.edu.famapr.AppFamapr.model.Avaliacao;
import br.edu.famapr.AppFamapr.model.Disciplina;
import br.edu.famapr.AppFamapr.model.Pergunta;
import org.springframework.stereotype.Component;

@Component
public class PerguntaMapper {

    public static Pergunta toEntity(
            PerguntaRequestDTO dto,
            Avaliacao avaliacao
    ) {
        Pergunta pergunta = new Pergunta();
        pergunta.setTitulo(dto.getTitulo());
        pergunta.setAvaliacao(avaliacao);
        return pergunta;
    }

    public static PerguntaResponseDTO toResponseDTO(
            Pergunta entity
    ) {
       if( entity == null) return null;

       return new PerguntaResponseDTO(
               entity.getId(),
               entity.getTitulo(),
               entity.getAvaliacao().getId(),
               entity.getRespostas().
                       stream()
                       .map(RespostaMapper::toResponseDTO).toList()
       );
    }
}