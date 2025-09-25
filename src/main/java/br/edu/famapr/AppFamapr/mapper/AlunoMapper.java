package br.edu.famapr.AppFamapr.mapper;

import br.edu.famapr.AppFamapr.dto.aluno.AlunoRequestDTO;
import br.edu.famapr.AppFamapr.dto.aluno.AlunoResponseDTO;
import br.edu.famapr.AppFamapr.model.Aluno;
import org.springframework.stereotype.Component;

@Component
public class AlunoMapper {

    public static Aluno toEntity(AlunoRequestDTO dto) {
        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setCpf(dto.getCpf());
        aluno.setSenha(dto.getSenha());
        aluno.setSexo(dto.getSexo());
        aluno.setDatanasc(dto.getDatanasc());
        aluno.setTelefone(dto.getTelefone());
        aluno.setEmail(dto.getEmail());
        return aluno;
    }

    public static AlunoResponseDTO toResponseDTO(Aluno aluno) {
        AlunoResponseDTO dto = new AlunoResponseDTO();
        dto.setId(aluno.getId());
        dto.setNome(aluno.getNome());
        dto.setCpf(aluno.getCpf());
        dto.setSexo(aluno.getSexo());
        dto.setDatanasc(aluno.getDatanasc());
        dto.setTelefone(aluno.getTelefone());
        dto.setEmail(aluno.getEmail());
        return dto;
    }
}
