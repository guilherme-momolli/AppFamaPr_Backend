package br.edu.famapr.AppFamapr.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "periodos")
public class Periodo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String periodo;

    private Integer abreviacao;

    @ManyToOne
    @JoinColumn(name = "cursos_id", nullable = false)
    private Curso curso;

    @OneToMany(mappedBy = "periodo", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Disciplina> disciplinas = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Integer getAbreviacao() {
        return abreviacao;
    }

    public void setAbreviacao(Integer abreviacao) {
        this.abreviacao = abreviacao;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    @JsonIgnore
    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}