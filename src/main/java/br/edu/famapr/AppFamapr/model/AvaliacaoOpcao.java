package br.edu.famapr.AppFamapr.model;

import jakarta.persistence.*;

@Entity
@Table(name = "avaliacao_opcoes")
public class AvaliacaoOpcao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pergunta_id", nullable = false)
    private AvaliacaoPergunta pergunta;

    @Column(nullable = false)
    private String descricao;

    private Integer valor;

    private Integer ordem;

    public AvaliacaoOpcao() {
    }

    public AvaliacaoOpcao(Integer id,
                          AvaliacaoPergunta pergunta,
                          String descricao,
                          Integer valor,
                          Integer ordem
    ) {
        this.id = id;
        this.pergunta = pergunta;
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

    public AvaliacaoPergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(AvaliacaoPergunta pergunta) {
        this.pergunta = pergunta;
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