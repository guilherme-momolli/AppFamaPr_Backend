package br.edu.famapr.AppFamapr.service;

import br.edu.famapr.AppFamapr.dto.avaliacao_opcao.AvaliacaoOpcaoRequestDTO;
import br.edu.famapr.AppFamapr.dto.avaliacao_opcao.AvaliacaoOpcaoResponseDTO;
import br.edu.famapr.AppFamapr.mapper.AvaliacaoOpcaoMapper;
import br.edu.famapr.AppFamapr.model.AvaliacaoOpcao;
import br.edu.famapr.AppFamapr.model.AvaliacaoPergunta;
import br.edu.famapr.AppFamapr.repository.AvaliacaoOpcaoRepository;
import br.edu.famapr.AppFamapr.repository.AvaliacaoPerguntaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AvaliacaoOpcaoService {

    private final AvaliacaoOpcaoRepository opcaoRepository;
    private final AvaliacaoPerguntaRepository perguntaRepository;

    public AvaliacaoOpcaoService(
            AvaliacaoOpcaoRepository opcaoRepository,
            AvaliacaoPerguntaRepository perguntaRepository
    ) {
        this.opcaoRepository = opcaoRepository;
        this.perguntaRepository = perguntaRepository;
    }

    @Transactional
    public AvaliacaoOpcaoResponseDTO create(AvaliacaoOpcaoRequestDTO dto) {

        AvaliacaoPergunta pergunta = perguntaRepository.findById(dto.getPerguntaId())
                .orElseThrow(() -> new RuntimeException("Pergunta não encontrada"));

        AvaliacaoOpcao opcao = AvaliacaoOpcaoMapper.toEntity(dto, pergunta);

        AvaliacaoOpcao saved = opcaoRepository.save(opcao);
        return AvaliacaoOpcaoMapper.toResponseDTO(saved);
    }

    public AvaliacaoOpcaoResponseDTO findById(Integer id) {
        AvaliacaoOpcao opcao = opcaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Opção não encontrada"));

        return AvaliacaoOpcaoMapper.toResponseDTO(opcao);
    }

    public List<AvaliacaoOpcaoResponseDTO> findByPergunta(Integer perguntaId) {
        return opcaoRepository.findByPerguntaId(perguntaId)
                .stream()
                .map(AvaliacaoOpcaoMapper::toResponseDTO)
                .toList();
    }

    @Transactional
    public AvaliacaoOpcaoResponseDTO update(Integer id, AvaliacaoOpcaoRequestDTO dto) {

        AvaliacaoOpcao existente = opcaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Opção não encontrada"));

        existente.setDescricao(dto.getDescricao());
        existente.setValor(dto.getValor());
        existente.setOrdem(dto.getOrdem());

        AvaliacaoOpcao atualizado = opcaoRepository.save(existente);
        return AvaliacaoOpcaoMapper.toResponseDTO(atualizado);
    }

    @Transactional
    public void delete(Integer id) {
        if (!opcaoRepository.existsById(id)) {
            throw new RuntimeException("Opção não encontrada");
        }
        opcaoRepository.deleteById(id);
    }
}
