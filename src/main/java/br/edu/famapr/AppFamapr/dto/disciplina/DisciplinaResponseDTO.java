package br.edu.famapr.AppFamapr.dto.disciplina;

import br.edu.famapr.AppFamapr.dto.aluno.AlunoResponseDTO;
import br.edu.famapr.AppFamapr.dto.matricula.MatriculaResponseDTO;
import br.edu.famapr.AppFamapr.dto.pergunta.PerguntaResponseDTO;
import br.edu.famapr.AppFamapr.dto.periodo.PeriodoResponseDTO;

import java.util.List;

public class DisciplinaResponseDTO {
    private Integer id;
    private String nome;
    private String abreviacao;
    private Integer cargaHoraria;
    private Integer aulasSemanais;
    private Integer periodoId;
    private String periodoNome;

    public DisciplinaResponseDTO() {
    }

    public DisciplinaResponseDTO(Integer id,
                                 String nome,
                                 String abreviacao,
                                 Integer cargaHoraria,
                                 Integer aulasSemanais,
                                 Integer periodoId,
                                 String periodoNome) {
        this.id = id;
        this.nome = nome;
        this.abreviacao = abreviacao;
        this.cargaHoraria = cargaHoraria;
        this.aulasSemanais = aulasSemanais;
        this.periodoId = periodoId;
        this.periodoNome = periodoNome;
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

    public Integer getPeriodoId() {
        return periodoId;
    }

    public void setPeriodoId(Integer periodoId) {
        this.periodoId = periodoId;
    }

    public String getPeriodoNome() {
        return periodoNome;
    }

    public void setPeriodoNome(String periodoNome) {
        this.periodoNome = periodoNome;
    }
}
