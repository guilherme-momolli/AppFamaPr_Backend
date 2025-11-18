package br.edu.famapr.AppFamapr.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "disciplinas")
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(length = 10)
    private String abreviacao;

    @Column(name = "carga_horaria", nullable = false)
    private Integer cargaHoraria;

    @Column(name = "aulas_semanais", nullable = false)
    private Integer aulasSemanais;

    @ManyToOne
    @JoinColumn(name = "periodo_id", nullable = false)
    private Periodo periodo;


    public Disciplina() {
    }

    public Disciplina(Integer id, String nome, String abreviacao, Integer cargaHoraria, Integer aulasSemanais, Periodo periodo) {
        this.id = id;
        this.nome = nome;
        this.abreviacao = abreviacao;
        this.cargaHoraria = cargaHoraria;
        this.aulasSemanais = aulasSemanais;
        this.periodo = periodo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public void setAbreviacao(String abreviacao) {
        this.abreviacao = abreviacao;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Integer getAulasSemanais() {
        return aulasSemanais;
    }

    public void setAulasSemanais(Integer aulasSemanais) {
        this.aulasSemanais = aulasSemanais;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }
}
