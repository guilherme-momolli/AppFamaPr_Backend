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
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RespostaService {

    private final RespostaRepository respostaRepository;
    private final AvaliacaoRepository avaliacaoRepository;
    private final PerguntaRepository perguntaRepository;
    private final RespostaMapper respostaMapper;

    public RespostaService(RespostaRepository respostaRepository,
                           AvaliacaoRepository avaliacaoRepository,
                           PerguntaRepository perguntaRepository,
                           RespostaMapper respostaMapper) {
        this.respostaRepository = respostaRepository;
        this.avaliacaoRepository = avaliacaoRepository;
        this.perguntaRepository = perguntaRepository;
        this.respostaMapper = respostaMapper;
    }

    public List<RespostaResponseDTO> findAll() {
        return respostaRepository.findAll()
                .stream()
                .map(RespostaMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    public Optional<RespostaResponseDTO> findById(Integer id) {
        return respostaRepository.findById(id)
                .map(RespostaMapper::toResponseDTO);
    }

    public RespostaResponseDTO create(RespostaRequestDTO dto) {
        Avaliacao avaliacao = avaliacaoRepository.findById(dto.getAvaliacaoId())
                .orElseThrow(() -> new RuntimeException("Avaliação não encontrada"));

        Pergunta pergunta = perguntaRepository.findById(dto.getPerguntaId())
                .orElseThrow(() -> new RuntimeException("Pergunta não encontrada"));

        Resposta resposta = RespostaMapper.toEntity(dto, avaliacao, pergunta);

        return respostaMapper.toResponseDTO(respostaRepository.save(resposta));
    }

    public Optional<RespostaResponseDTO> update(Integer id, RespostaRequestDTO dto) {
        return respostaRepository.findById(id).map(existing -> {
            existing.setRespostaNumero(dto.getRespostaNumero());
            existing.setRespostaTexto(dto.getRespostaTexto());

            if (dto.getAvaliacaoId() != null) {
                Avaliacao avaliacao = avaliacaoRepository.findById(dto.getAvaliacaoId())
                        .orElseThrow(() -> new RuntimeException("Avaliação não encontrada"));
                existing.setAvaliacao(avaliacao);
            }

            if (dto.getPerguntaId() != null) {
                Pergunta pergunta = perguntaRepository.findById(dto.getPerguntaId())
                        .orElseThrow(() -> new RuntimeException("Pergunta não encontrada"));
                existing.setPergunta(pergunta);
            }

            Resposta atualizado = respostaRepository.save(existing);
            return respostaMapper.toResponseDTO(atualizado);
        });
    }

    public boolean delete(Integer id) {
        if (respostaRepository.existsById(id)) {
            respostaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
