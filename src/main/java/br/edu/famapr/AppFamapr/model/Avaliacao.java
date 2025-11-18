package br.edu.famapr.AppFamapr.model;

import br.edu.famapr.AppFamapr.enums.avaliacao.TipoAvaliacao;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "avaliacoes")
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data_avaliacao", nullable = false)
    private LocalDateTime dataAvaliacao = LocalDateTime.now();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "matricula_id", nullable = false)
    private Matricula matricula;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_avaliacao")
    private TipoAvaliacao tipoAvaliacao;

    @OneToMany(mappedBy = "avaliacao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AvaliacaoPergunta> perguntas = new ArrayList<>();

    public Avaliacao() {
    }

    public Avaliacao(Integer id,
                     LocalDateTime dataAvaliacao,
                     Matricula matricula,
                     TipoAvaliacao tipoAvaliacao,
                     List<AvaliacaoPergunta> perguntas) {
        this.id = id;
        this.dataAvaliacao = dataAvaliacao;
        this.matricula = matricula;
        this.tipoAvaliacao = tipoAvaliacao;
        this.perguntas = perguntas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(LocalDateTime dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public TipoAvaliacao getTipoAvaliacao() {
        return tipoAvaliacao;
    }

    public void setTipoAvaliacao(TipoAvaliacao tipoAvaliacao) {
        this.tipoAvaliacao = tipoAvaliacao;
    }

    public List<AvaliacaoPergunta> getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(List<AvaliacaoPergunta> perguntas) {
        this.perguntas = perguntas;
    }
}