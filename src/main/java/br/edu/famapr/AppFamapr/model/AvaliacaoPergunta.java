package br.edu.famapr.AppFamapr.model;

import br.edu.famapr.AppFamapr.enums.avaliacao.TipoAvaliacao;
import br.edu.famapr.AppFamapr.enums.pergunta.TipoPergunta;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "avaliacao_perguntas")
public class AvaliacaoPergunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "avaliacao_id", nullable = false)
    private Avaliacao avaliacao;

    @Column(nullable = false)
    private String titulo;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_pergunta")
    private TipoPergunta TipoPergunta;

    private Integer ordem;

    private Boolean obrigatoria;
    @OneToMany(mappedBy = "pergunta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AvaliacaoOpcao> opcoes = new ArrayList<>();

    @OneToMany(mappedBy = "pergunta", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<AvaliacaoResposta> respostas = new ArrayList<>();


    public AvaliacaoPergunta() {}

    public AvaliacaoPergunta(Integer id,
                             Avaliacao avaliacao,
                             String titulo,
                             TipoPergunta tipoPergunta,
                             Integer ordem,
                             Boolean obrigatoria,
                             List<AvaliacaoOpcao> opcoes,
                             List<AvaliacaoResposta> respostas) {
        this.id = id;
        this.avaliacao = avaliacao;
        this.titulo = titulo;
        TipoPergunta = tipoPergunta;
        this.ordem = ordem;
        this.obrigatoria = obrigatoria;
        this.opcoes = opcoes;
        this.respostas = respostas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public TipoPergunta getTipoPergunta() {
        return TipoPergunta;
    }

    public void setTipoPergunta(TipoPergunta tipoPergunta) {
        TipoPergunta = tipoPergunta;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }

    public Boolean getObrigatoria() {
        return obrigatoria;
    }

    public void setObrigatoria(Boolean obrigatoria) {
        this.obrigatoria = obrigatoria;
    }

    public List<AvaliacaoOpcao> getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(List<AvaliacaoOpcao> opcoes) {
        this.opcoes = opcoes;
    }

    public List<AvaliacaoResposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<AvaliacaoResposta> respostas) {
        this.respostas = respostas;
    }
}
