package br.edu.famapr.AppFamapr.dto.avaliacao_pergunta;

import br.edu.famapr.AppFamapr.dto.avaliacao_opcao.AvaliacaoOpcaoRequestDTO;
import br.edu.famapr.AppFamapr.dto.avaliacao_opcao.AvaliacaoOpcaoResponseDTO;
import br.edu.famapr.AppFamapr.enums.pergunta.TipoPergunta;

import java.util.List;

public class AvaliacaoPerguntaResponseDTO {

    private Integer id;
    private Integer avaliacaoId;
    private String titulo;
    private TipoPergunta tipoPergunta;
    private Integer ordem;
    private Boolean obrigatoria;

    private List<AvaliacaoOpcaoResponseDTO> opcoes;

    public AvaliacaoPerguntaResponseDTO() {}

    public AvaliacaoPerguntaResponseDTO(
            Integer id,
            Integer avaliacaoId,
            String titulo,
            TipoPergunta tipoPergunta,
            Integer ordem,
            Boolean obrigatoria,
            List<AvaliacaoOpcaoResponseDTO> opcoes
    ) {
        this.id = id;
        this.avaliacaoId = avaliacaoId;
        this.titulo = titulo;
        this.tipoPergunta = tipoPergunta;
        this.ordem = ordem;
        this.obrigatoria = obrigatoria;
        this.opcoes = opcoes;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getAvaliacaoId() { return avaliacaoId; }
    public void setAvaliacaoId(Integer avaliacaoId) { this.avaliacaoId = avaliacaoId; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public TipoPergunta getTipoPergunta() { return tipoPergunta; }
    public void setTipoPergunta(TipoPergunta tipoPergunta) { this.tipoPergunta = tipoPergunta; }

    public Integer getOrdem() { return ordem; }
    public void setOrdem(Integer ordem) { this.ordem = ordem; }

    public Boolean getObrigatoria() { return obrigatoria; }
    public void setObrigatoria(Boolean obrigatoria) { this.obrigatoria = obrigatoria; }

    public List<AvaliacaoOpcaoResponseDTO> getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(List<AvaliacaoOpcaoResponseDTO> opcoes) {
        this.opcoes = opcoes;
    }
}