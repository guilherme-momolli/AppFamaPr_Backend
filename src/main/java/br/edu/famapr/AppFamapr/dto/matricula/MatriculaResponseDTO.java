package br.edu.famapr.AppFamapr.dto.matricula;

import br.edu.famapr.AppFamapr.dto.aluno.AlunoResponseDTO;
import br.edu.famapr.AppFamapr.dto.disciplina.DisciplinaResponseDTO;

import java.time.LocalDate;

public class MatriculaResponseDTO {

    private Integer id;
    private LocalDate datamatricula;
    private String status;
    private LocalDate datavigencia;
    private String alunoNome;
    private String disciplinaNome;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public LocalDate getDatamatricula() { return datamatricula; }
    public void setDatamatricula(LocalDate datamatricula) { this.datamatricula = datamatricula; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getDatavigencia() { return datavigencia; }
    public void setDatavigencia(LocalDate datavigencia) { this.datavigencia = datavigencia; }

    public String getAlunoNome() { return alunoNome; }
    public void setAlunoNome(String alunoNome) { this.alunoNome = alunoNome; }

    public String getDisciplinaNome() { return disciplinaNome; }
    public void setDisciplinaNome(String disciplinaNome) { this.disciplinaNome = disciplinaNome; }
}
