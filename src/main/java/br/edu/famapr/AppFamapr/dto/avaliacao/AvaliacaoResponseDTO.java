package br.edu.famapr.AppFamapr.dto.avaliacao;

import br.edu.famapr.AppFamapr.dto.avaliacao_pergunta.AvaliacaoPerguntaResponseDTO;
import br.edu.famapr.AppFamapr.enums.avaliacao.TipoAvaliacao;

import java.time.LocalDateTime;
import java.util.List;

public class AvaliacaoResponseDTO {

    private Integer id;
    private LocalDateTime dataAvaliacao;
    private Integer matriculaId;
    private TipoAvaliacao tipoAvaliacao;
    private List<AvaliacaoPerguntaResponseDTO> perguntas;

    public AvaliacaoResponseDTO() {}

    public AvaliacaoResponseDTO(Integer id,
                                LocalDateTime dataAvaliacao,
                                Integer matriculaId,
                                TipoAvaliacao tipoAvaliacao,
                                List<AvaliacaoPerguntaResponseDTO> perguntas) {
        this.id = id;
        this.dataAvaliacao = dataAvaliacao;
        this.matriculaId = matriculaId;
        this.tipoAvaliacao = tipoAvaliacao;
        this.perguntas = perguntas;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public LocalDateTime getDataAvaliacao() { return dataAvaliacao; }
    public void setDataAvaliacao(LocalDateTime dataAvaliacao) { this.dataAvaliacao = dataAvaliacao; }

    public Integer getMatriculaId() { return matriculaId; }
    public void setMatriculaId(Integer matriculaId) { this.matriculaId = matriculaId; }

    public TipoAvaliacao getTipoAvaliacao() { return tipoAvaliacao; }
    public void setTipoAvaliacao(TipoAvaliacao tipoAvaliacao) { this.tipoAvaliacao = tipoAvaliacao; }

    public List<AvaliacaoPerguntaResponseDTO> getPerguntas() { return perguntas; }
    public void setPerguntas(List<AvaliacaoPerguntaResponseDTO> perguntas) { this.perguntas = perguntas; }
}