package br.edu.famapr.AppFamapr.dto.avaliacao_opcao;

public class AvaliacaoOpcaoResponseDTO {

    private Integer id;
    private Integer perguntaId;
    private String descricao;
    private Integer valor;
    private Integer ordem;

    public AvaliacaoOpcaoResponseDTO() {}

    public AvaliacaoOpcaoResponseDTO(
            Integer id,
            Integer perguntaId,
            String descricao,
            Integer valor,
            Integer ordem
    ) {
        this.id = id;
        this.perguntaId = perguntaId;
        this.descricao = descricao;
        this.valor = valor;
        this.ordem = ordem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPerguntaId() {
        return perguntaId;
    }

    public void setPerguntaId(Integer perguntaId) {
        this.perguntaId = perguntaId;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }
}
