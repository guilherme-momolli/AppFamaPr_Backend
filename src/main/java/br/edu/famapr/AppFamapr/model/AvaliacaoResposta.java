package br.edu.famapr.AppFamapr.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "avaliacao_respostas")
public class AvaliacaoResposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "avaliacao_id", nullable = false)
    private Avaliacao avaliacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pergunta_id", nullable = false)
    private AvaliacaoPergunta pergunta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id", nullable = false)
    private Aluno aluno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "opcao_id")
    private AvaliacaoOpcao opcao;

    @Column(name = "resposta_texto", length = 255)
    private String respostaTexto;

    @Column(name = "valor_numerico")
    private Integer valorNumerico;

    @Column(name = "respondido_em")
    private LocalDateTime respondidoEm = LocalDateTime.now();

    public AvaliacaoResposta() {}

    public AvaliacaoResposta(
            Integer id,
            Avaliacao avaliacao,
            AvaliacaoPergunta pergunta,
            Aluno aluno,
            AvaliacaoOpcao opcao,
            String respostaTexto,
            Integer valorNumerico,
            LocalDateTime respondidoEm
    ) {
        this.id = id;
        this.avaliacao = avaliacao;
        this.pergunta = pergunta;
        this.aluno = aluno;
        this.opcao = opcao;
        this.respostaTexto = respostaTexto;
        this.valorNumerico = valorNumerico;
        this.respondidoEm = respondidoEm;
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

    public AvaliacaoPergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(AvaliacaoPergunta pergunta) {
        this.pergunta = pergunta;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public AvaliacaoOpcao getOpcao() {
        return opcao;
    }

    public void setOpcao(AvaliacaoOpcao opcao) {
        this.opcao = opcao;
    }

    public String getRespostaTexto() {
        return respostaTexto;
    }

    public void setRespostaTexto(String respostaTexto) {
        this.respostaTexto = respostaTexto;
    }

    public Integer getValorNumerico() {
        return valorNumerico;
    }

    public void setValorNumerico(Integer valorNumerico) {
        this.valorNumerico = valorNumerico;
    }

    public LocalDateTime getRespondidoEm() {
        return respondidoEm;
    }

    public void setRespondidoEm(LocalDateTime respondidoEm) {
        this.respondidoEm = respondidoEm;
    }
}
