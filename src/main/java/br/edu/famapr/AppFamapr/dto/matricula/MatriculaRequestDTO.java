package br.edu.famapr.AppFamapr.dto.matricula;

import java.time.LocalDate;

public class MatriculaRequestDTO {
    private LocalDate datamatricula;
    private String status;
    private LocalDate datavigencia;
    private Integer alunoId;
    private Integer disciplinaId;

    public MatriculaRequestDTO(LocalDate datamatricula, String status, LocalDate datavigencia, Integer alunoId, Integer disciplinaId) {
        this.datamatricula = datamatricula;
        this.status = status;
        this.datavigencia = datavigencia;
        this.alunoId = alunoId;
        this.disciplinaId = disciplinaId;
    }

    public MatriculaRequestDTO() {
    }

    public LocalDate getDatamatricula() { return datamatricula; }
    public void setDatamatricula(LocalDate datamatricula) { this.datamatricula = datamatricula; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getDatavigencia() { return datavigencia; }
    public void setDatavigencia(LocalDate datavigencia) { this.datavigencia = datavigencia; }

    public Integer getAlunoId() { return alunoId; }
    public void setAlunoId(Integer alunoId) { this.alunoId = alunoId; }

    public Integer getDisciplinaId() { return disciplinaId; }
    public void setDisciplinaId(Integer disciplinaId) { this.disciplinaId = disciplinaId; }
}