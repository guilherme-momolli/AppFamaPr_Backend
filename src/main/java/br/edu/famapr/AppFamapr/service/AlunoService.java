package br.edu.famapr.AppFamapr.service;

import br.edu.famapr.AppFamapr.dto.aluno.AlunoRequestDTO;
import br.edu.famapr.AppFamapr.dto.aluno.AlunoResponseDTO;
import br.edu.famapr.AppFamapr.mapper.AlunoMapper;
import br.edu.famapr.AppFamapr.model.Aluno;
import br.edu.famapr.AppFamapr.repository.AlunoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepository;

    public AlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public List<AlunoResponseDTO> findAll() {
        return alunoRepository.findAll()
                .stream()
                .map(AlunoMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public Optional<AlunoResponseDTO> findById(Integer id) {
        return alunoRepository.findById(id).map(AlunoMapper::toResponseDTO);
    }

    public AlunoResponseDTO create(AlunoRequestDTO dto) {
        Aluno aluno = AlunoMapper.toEntity(dto);
        return AlunoMapper.toResponseDTO(alunoRepository.save(aluno));
    }

    public Optional<AlunoResponseDTO> update(Integer id, AlunoRequestDTO dto) {
        return alunoRepository.findById(id).map(aluno -> {
            aluno.setNome(dto.getNome());
            aluno.setCpf(dto.getCpf());
            aluno.setSenha(dto.getSenha());
            aluno.setSexo(dto.getSexo());
            aluno.setDatanasc(dto.getDatanasc());
            aluno.setTelefone(dto.getTelefone());
            aluno.setEmail(dto.getEmail());
            return AlunoMapper.toResponseDTO(alunoRepository.save(aluno));
        });
    }

    public boolean delete(Integer id) {
        return alunoRepository.findById(id).map(aluno -> {
            alunoRepository.delete(aluno);
            return true;
        }).orElse(false);
    }
}
