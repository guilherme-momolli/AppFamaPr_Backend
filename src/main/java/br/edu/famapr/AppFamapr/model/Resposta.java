package br.edu.famapr.AppFamapr.model;

import jakarta.persistence.*;

import jakarta.persistence.*;

@Entity
@Table(name = "respostas")
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "resposta_numero")
    private Integer respostaNumero;

    @Column(name = "resposta_texto", nullable = false, length = 255)
    private String respostaTexto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pergunta_id", nullable = false)
    private Pergunta pergunta;

    public Resposta(Integer id, Integer respostaNumero, String respostaTexto, Pergunta pergunta) {
        this.id = id;
        this.respostaNumero = respostaNumero;
        this.respostaTexto = respostaTexto;
        this.pergunta = pergunta;
    }

    public Resposta() {
    }

    public Integer getId() {
        return id;
    }

    public Integer getRespostaNumero() {
        return respostaNumero;
    }

    public void setRespostaNumero(Integer respostaNumero) {
        this.respostaNumero = respostaNumero;
    }

    public String getRespostaTexto() {
        return respostaTexto;
    }

    public void setRespostaTexto(String respostaTexto) {
        this.respostaTexto = respostaTexto;
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }
}

