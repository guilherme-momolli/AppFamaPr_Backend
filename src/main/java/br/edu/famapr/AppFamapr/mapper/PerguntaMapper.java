package br.edu.famapr.AppFamapr.mapper;

import br.edu.famapr.AppFamapr.dto.pergunta.PerguntaRequestDTO;
import br.edu.famapr.AppFamapr.dto.pergunta.PerguntaResponseDTO;
import br.edu.famapr.AppFamapr.model.Disciplina;
import br.edu.famapr.AppFamapr.model.Pergunta;
import org.springframework.stereotype.Component;

@Component
public class PerguntaMapper {

    public static Pergunta toEntity(PerguntaRequestDTO dto, Disciplina disciplina) {
        Pergunta pergunta = new Pergunta();
        pergunta.setTitulo(dto.getTitulo());
        pergunta.setDisciplina(disciplina);
        return pergunta;
    }

    public static PerguntaResponseDTO toResponseDTO(Pergunta entity) {
        PerguntaResponseDTO dto = new PerguntaResponseDTO();
        dto.setId(entity.getId());
        dto.setTitulo(entity.getTitulo());
        dto.setDisciplinaId(entity.getDisciplina().getId());
        return dto;
    }
}