package br.edu.famapr.AppFamapr.dto.matricula;

import br.edu.famapr.AppFamapr.dto.aluno.AlunoResponseDTO;
import br.edu.famapr.AppFamapr.dto.avaliacao.AvaliacaoResponseDTO;
import br.edu.famapr.AppFamapr.dto.disciplina.DisciplinaResponseDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MatriculaResponseDTO {

    private Integer id;
    private LocalDate datamatricula;
    private String status;
    private LocalDate datavigencia;
    private String alunoNome;
    private Integer disciplinaId;
    private List<AvaliacaoResponseDTO> avaliacaoResponseDTOList = new ArrayList<>();

    public MatriculaResponseDTO() {
    }

    public MatriculaResponseDTO(
            Integer id,
            LocalDate datamatricula,
            String status,
            LocalDate datavigencia,
            String alunoNome,
            Integer disciplinaId,
            List<AvaliacaoResponseDTO> avaliacaoResponseDTOList
    ) {
        this.id = id;
        this.datamatricula = datamatricula;
        this.status = status;
        this.datavigencia = datavigencia;
        this.alunoNome = alunoNome;
        this.disciplinaId = disciplinaId;
        this.avaliacaoResponseDTOList = avaliacaoResponseDTOList;
    }

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

    public String getAlunoNome() {
        return alunoNome;
    }

    public void setAlunoNome(String alunoNome) {
        this.alunoNome = alunoNome;
    }

    public Integer getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(Integer disciplinaId) {
        this.disciplinaId = disciplinaId;
    }

    public List<AvaliacaoResponseDTO> getAvaliacaoResponseDTOList() {
        return avaliacaoResponseDTOList;
    }

    public void setAvaliacaoResponseDTOList(List<AvaliacaoResponseDTO> avaliacaoResponseDTOList) {
        this.avaliacaoResponseDTOList = avaliacaoResponseDTOList;
    }
}
