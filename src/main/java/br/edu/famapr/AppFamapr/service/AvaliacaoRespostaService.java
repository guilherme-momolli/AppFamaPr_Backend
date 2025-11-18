package br.edu.famapr.AppFamapr.service;

import br.edu.famapr.AppFamapr.dto.avaliacao_resposta.AvaliacaoRespostaRequestDTO;
import br.edu.famapr.AppFamapr.dto.avaliacao_resposta.AvaliacaoRespostaResponseDTO;
import br.edu.famapr.AppFamapr.mapper.AvaliacaoRespostaMapper;
import br.edu.famapr.AppFamapr.model.*;
import br.edu.famapr.AppFamapr.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AvaliacaoRespostaService {

    private final AvaliacaoRespostaRepository respostaRepository;
    private final AvaliacaoRepository avaliacaoRepository;
    private final AvaliacaoPerguntaRepository perguntaRepository;
    private final AlunoRepository alunoRepository;
    private final AvaliacaoOpcaoRepository opcaoRepository;

    public AvaliacaoRespostaService(
            AvaliacaoRespostaRepository respostaRepository,
            AvaliacaoRepository avaliacaoRepository,
            AvaliacaoPerguntaRepository perguntaRepository,
            AlunoRepository alunoRepository,
            AvaliacaoOpcaoRepository opcaoRepository
    ) {
        this.respostaRepository = respostaRepository;
        this.avaliacaoRepository = avaliacaoRepository;
        this.perguntaRepository = perguntaRepository;
        this.alunoRepository = alunoRepository;
        this.opcaoRepository = opcaoRepository;
    }

    @Transactional
    public AvaliacaoRespostaResponseDTO create(AvaliacaoRespostaRequestDTO dto) {

        Avaliacao avaliacao = avaliacaoRepository.findById(dto.getAvaliacaoId())
                .orElseThrow(() -> new RuntimeException("Avaliação não encontrada"));

        AvaliacaoPergunta pergunta = perguntaRepository.findById(dto.getPerguntaId())
                .orElseThrow(() -> new RuntimeException("Pergunta não encontrada"));

        Aluno aluno = alunoRepository.findById(dto.getAlunoId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        AvaliacaoOpcao opcao = null;
        if (dto.getOpcaoId() != null) {
            opcao = opcaoRepository.findById(dto.getOpcaoId())
                    .orElseThrow(() -> new RuntimeException("Opção não encontrada"));
        }

        AvaliacaoResposta resposta = AvaliacaoRespostaMapper.toEntity(
                dto,
                avaliacao,
                pergunta,
                aluno,
                opcao
        );

        AvaliacaoResposta saved = respostaRepository.save(resposta);
        return AvaliacaoRespostaMapper.toResponseDTO(saved);
    }

    @Transactional(readOnly = true)
    public AvaliacaoRespostaResponseDTO findById(Integer id) {
        AvaliacaoResposta resposta = respostaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resposta não encontrada"));
        return AvaliacaoRespostaMapper.toResponseDTO(resposta);
    }

    public List<AvaliacaoRespostaResponseDTO> findByAvaliacao(Integer avaliacaoId) {
        return respostaRepository.findByAvaliacaoId(avaliacaoId)
                .stream()
                .map(AvaliacaoRespostaMapper::toResponseDTO)
                .toList();
    }

    @Transactional
    public AvaliacaoRespostaResponseDTO update(Integer id, AvaliacaoRespostaRequestDTO dto) {

        AvaliacaoResposta existente = respostaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Resposta não encontrada"));

        Avaliacao avaliacao = avaliacaoRepository.findById(dto.getAvaliacaoId())
                .orElseThrow(() -> new RuntimeException("Avaliação não encontrada"));

        AvaliacaoPergunta pergunta = perguntaRepository.findById(dto.getPerguntaId())
                .orElseThrow(() -> new RuntimeException("Pergunta não encontrada"));

        Aluno aluno = alunoRepository.findById(dto.getAlunoId())
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));

        AvaliacaoOpcao opcao = null;
        if (dto.getOpcaoId() != null) {
            opcao = opcaoRepository.findById(dto.getOpcaoId())
                    .orElseThrow(() -> new RuntimeException("Opção não encontrada"));
        }

        existente.setAvaliacao(avaliacao);
        existente.setPergunta(pergunta);
        existente.setAluno(aluno);
        existente.setOpcao(opcao);
        existente.setRespostaTexto(dto.getRespostaTexto());
        existente.setValorNumerico(dto.getValorNumerico());

        AvaliacaoResposta atualizado = respostaRepository.save(existente);
        return AvaliacaoRespostaMapper.toResponseDTO(atualizado);
    }

    @Transactional
    public void delete(Integer id) {
        if (!respostaRepository.existsById(id)) {
            throw new RuntimeException("Resposta não encontrada");
        }
        respostaRepository.deleteById(id);
    }
}

