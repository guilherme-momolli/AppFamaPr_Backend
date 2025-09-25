package br.edu.famapr.AppFamapr.dto.periodo;

public class PeriodoRequestDTO {

    private String periodo;
    private Integer abreviacao;
    private Integer cursoId;

    public PeriodoRequestDTO() {
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

    public Integer getCursoId() {
        return cursoId;
    }

    public void setCursoId(Integer cursoId) {
        this.cursoId = cursoId;
    }
}