package br.edu.famapr.AppFamapr.dto.disciplina;

import br.edu.famapr.AppFamapr.dto.matricula.MatriculaResponseDTO;
import br.edu.famapr.AppFamapr.dto.periodo.PeriodoResponseDTO;

import java.util.List;

public class DisciplinaResponseDTO {
    private Integer id;
    private String nome;
    private String abreviacao;
    private Integer cargahoraria;
    private Integer aulassemanais;
    private String periodoNome; // Nome do período relacionado


    public DisciplinaResponseDTO(Integer id, String nome, String abreviacao, Integer cargahoraria, Integer aulassemanais, String periodoNome) {
        this.id = id;
        this.nome = nome;
        this.abreviacao = abreviacao;
        this.cargahoraria = cargahoraria;
        this.aulassemanais = aulassemanais;
        this.periodoNome = periodoNome;
    }

    public DisciplinaResponseDTO() {
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getAbreviacao() { return abreviacao; }
    public void setAbreviacao(String abreviacao) { this.abreviacao = abreviacao; }

    public Integer getCargahoraria() { return cargahoraria; }
    public void setCargahoraria(Integer cargahoraria) { this.cargahoraria = cargahoraria; }

    public Integer getAulassemanais() { return aulassemanais; }
    public void setAulassemanais(Integer aulassemanais) { this.aulassemanais = aulassemanais; }

    public String getPeriodoNome() { return periodoNome; }
    public void setPeriodoNome(String periodoNome) { this.periodoNome = periodoNome; }
}