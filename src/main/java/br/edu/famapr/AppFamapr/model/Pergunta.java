package br.edu.famapr.AppFamapr.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "perguntas")
public class Pergunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titulo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "avaliacao_id", nullable = false)
    private Avaliacao avaliacao;

    @OneToMany(mappedBy = "pergunta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Resposta> respostas = new ArrayList<>();

    public Pergunta() {
    }

    public Pergunta(Integer id,
                    String titulo,
                    Avaliacao avaliacao,
                    List<Resposta> respostas
    ) {
        this.id = id;
        this.titulo = titulo;
        this.avaliacao = avaliacao;
        this.respostas = respostas;
    }

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Avaliacao getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Avaliacao avaliacao) {
        this.avaliacao = avaliacao;
    }

    public List<Resposta> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Resposta> respostas) {
        this.respostas = respostas;
    }
}
