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

    private String nome;

    private String abreviacao;

    private Integer cargahoraria;

    private Integer aulassemanais;

    @ManyToOne
    @JoinColumn(name = "periodos_id", nullable = false)
    private Periodo periodo;

    @OneToMany(mappedBy = "disciplina", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Matricula> matriculas = new ArrayList<>();

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

    public Integer getCargahoraria() {
        return cargahoraria;
    }

    public void setCargahoraria(Integer cargahoraria) {
        this.cargahoraria = cargahoraria;
    }

    public Integer getAulassemanais() {
        return aulassemanais;
    }

    public void setAulassemanais(Integer aulassemanais) {
        this.aulassemanais = aulassemanais;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    @JsonIgnore
    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
}