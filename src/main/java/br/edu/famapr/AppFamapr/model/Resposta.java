package br.edu.famapr.AppFamapr.model;

import jakarta.persistence.*;

@Entity
@Table(name = "resposata")
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "resposta_numero")
    private int respostaNumero;

    @Column(name = "resposta_texto")
    private String respostaTexto;

    @ManyToOne
    @JoinColumn(name = "avaliacoes_id", nullable = false)
    private Avaliacao avaliacao;

    @JoinColumn(name = "perguntas_id", nullable = false)
    @ManyToOne
    private Pergunta pergunta;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getRespostaNumero() {
        return respostaNumero;
    }

    public void setRespostaNumero(int respostaNumero) {
        this.respostaNumero = respostaNumero;
    }

    public String getRespostaTexto() {
        return respostaTexto;
    }

    public void setRespostaTexto(String respostaTexto) {
        this.respostaTexto = respostaTexto;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }
}
