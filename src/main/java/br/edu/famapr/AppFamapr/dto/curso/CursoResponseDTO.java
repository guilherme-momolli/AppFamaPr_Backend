package br.edu.famapr.AppFamapr.dto.curso;

import br.edu.famapr.AppFamapr.dto.periodo.PeriodoResponseDTO;

import java.util.List;


public class CursoResponseDTO {

    private Integer id;
    private String nome;
    private String abreviacao;
    private List<PeriodoResponseDTO> periodo;

    public CursoResponseDTO(Integer id, String nome, String abreviacao, List<PeriodoResponseDTO> periodo) {
        this.id = id;
        this.nome = nome;
        this.abreviacao = abreviacao;
        this.periodo = periodo;
    }

    public CursoResponseDTO() {

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

    public List<PeriodoResponseDTO> getPeriodo() {
        return periodo;
    }

    public void setPeriodo(List<PeriodoResponseDTO> periodo) {
        this.periodo = periodo;
    }
}
