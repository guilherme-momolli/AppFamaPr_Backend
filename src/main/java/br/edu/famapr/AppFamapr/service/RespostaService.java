package br.edu.famapr.AppFamapr.service;

import br.edu.famapr.AppFamapr.dto.resposta.RespostaRequestDTO;
import br.edu.famapr.AppFamapr.dto.resposta.RespostaResponseDTO;
import br.edu.famapr.AppFamapr.mapper.RespostaMapper;
import br.edu.famapr.AppFamapr.model.Avaliacao;
import br.edu.famapr.AppFamapr.model.Pergunta;
import br.edu.famapr.AppFamapr.model.Resposta;
import br.edu.famapr.AppFamapr.repository.AvaliacaoRepository;
import br.edu.famapr.AppFamapr.repository.PerguntaRepository;
import br.edu.famapr.AppFamapr.repository.RespostaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RespostaService {

    @Autowired
    private RespostaRepository respostaRepository;

    @Autowired
    private PerguntaRepository perguntaRepository;

    public RespostaResponseDTO create(RespostaRequestDTO dto) {
        Pergunta pergunta = perguntaRepository.findById(dto.getPerguntaId())
                .orElseThrow(() -> new RuntimeException("Pergunta não encontrada"));
        Resposta resposta = RespostaMapper.toEntity(dto, pergunta);
        return RespostaMapper.toResponseDTO(respostaRepository.save(resposta));
    }

    public List<RespostaResponseDTO> findAll() {
        return respostaRepository.findAll().stream()
                .map(RespostaMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public RespostaResponseDTO findById(Integer id) {
        Resposta resposta = respostaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resposta não encontrada"));
        return RespostaMapper.toResponseDTO(resposta);
    }

    public RespostaResponseDTO update(Integer id, RespostaRequestDTO dto) {
        Resposta resposta = respostaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resposta não encontrada"));
        Pergunta pergunta = perguntaRepository.findById(dto.getPerguntaId())
                .orElseThrow(() -> new RuntimeException("Pergunta não encontrada"));

        resposta.setPergunta(pergunta);
        resposta.setRespostaNumero(dto.getRespostaNumero());
        resposta.setRespostaTexto(dto.getRespostaTexto());

        return RespostaMapper.toResponseDTO(respostaRepository.save(resposta));
    }

    public void delete(Integer id) {
        Resposta resposta = respostaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resposta não encontrada"));
        respostaRepository.delete(resposta);
    }
}