package br.edu.famapr.AppFamapr.dto.avaliacao;

import br.edu.famapr.AppFamapr.dto.avaliacao_pergunta.AvaliacaoPerguntaRequestDTO;
import br.edu.famapr.AppFamapr.enums.avaliacao.TipoAvaliacao;

import java.util.List;


public class AvaliacaoRequestDTO {

    private Integer matriculaId;
    private TipoAvaliacao tipoAvaliacao;
    private List<AvaliacaoPerguntaRequestDTO> perguntas;

    public AvaliacaoRequestDTO() {}

    public AvaliacaoRequestDTO(Integer matriculaId,
                               TipoAvaliacao tipoAvaliacao,
                               List<AvaliacaoPerguntaRequestDTO> perguntas) {
        this.matriculaId = matriculaId;
        this.tipoAvaliacao = tipoAvaliacao;
        this.perguntas = perguntas;
    }

    public Integer getMatriculaId() { return matriculaId; }
    public void setMatriculaId(Integer matriculaId) { this.matriculaId = matriculaId; }

    public TipoAvaliacao getTipoAvaliacao() { return tipoAvaliacao; }
    public void setTipoAvaliacao(TipoAvaliacao tipoAvaliacao) { this.tipoAvaliacao = tipoAvaliacao; }

    public List<AvaliacaoPerguntaRequestDTO> getPerguntas() { return perguntas; }
    public void setPerguntas(List<AvaliacaoPerguntaRequestDTO> perguntas) { this.perguntas = perguntas; }
}