package br.edu.famapr.AppFamapr.dto.periodo;

import br.edu.famapr.AppFamapr.dto.curso.CursoResponseDTO;
import br.edu.famapr.AppFamapr.dto.disciplina.DisciplinaResponseDTO;

import java.util.List;

public class PeriodoResponseDTO {

    private Integer id;
    private String periodo;
    private Integer abreviacao;
    private String cursoNome;

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

    public String getCursoNome() {
        return cursoNome;
    }

    public void setCursoNome(String cursoNome) {
        this.cursoNome = cursoNome;
    }
}
