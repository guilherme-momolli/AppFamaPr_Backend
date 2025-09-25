package br.edu.famapr.AppFamapr.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "matriculas")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate datamatricula;

    private String status;

    private LocalDate datavigencia;

    @ManyToOne
    @JoinColumn(name = "disciplinas_id", nullable = false)
    private Disciplina disciplina;

    @ManyToOne
    @JoinColumn(name = "alunos_id", nullable = false)
    private Aluno aluno;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDatamatricula() {
        return datamatricula;
    }

    public void setDatamatricula(LocalDate datamatricula) {
        this.datamatricula = datamatricula;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDatavigencia() {
        return datavigencia;
    }

    public void setDatavigencia(LocalDate datavigencia) {
        this.datavigencia = datavigencia;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
