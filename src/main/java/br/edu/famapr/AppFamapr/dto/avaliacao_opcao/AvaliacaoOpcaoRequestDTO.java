package br.edu.famapr.AppFamapr.dto.avaliacao_opcao;

public class AvaliacaoOpcaoRequestDTO {

    private Integer perguntaId;
    private String descricao;
    private Integer valor;
    private Integer ordem;

    public AvaliacaoOpcaoRequestDTO() {}

    public AvaliacaoOpcaoRequestDTO(Integer perguntaId,
                                    String descricao,
                                    Integer valor,
                                    Integer ordem) {
        this.perguntaId = perguntaId;
        this.descricao = descricao;
        this.valor = valor;
        this.ordem = ordem;
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
