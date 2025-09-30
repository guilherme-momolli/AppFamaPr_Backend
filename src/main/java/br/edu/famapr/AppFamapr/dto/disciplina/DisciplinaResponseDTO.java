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
    private Integer cargahoraria;
    private Integer aulassemanais;
    private Integer periodoId;
    private List<AlunoResponseDTO> alunos;
    private List<PerguntaResponseDTO> perguntas;


    public DisciplinaResponseDTO(Integer id, String nome, String abreviacao, Integer cargahoraria, Integer aulassemanais, Integer periodoId, List<AlunoResponseDTO> alunos, List<PerguntaResponseDTO> perguntas) {
        this.id = id;
        this.nome = nome;
        this.abreviacao = abreviacao;
        this.cargahoraria = cargahoraria;
        this.aulassemanais = aulassemanais;
        this.periodoId = periodoId;
        this.alunos = alunos;
        this.perguntas = perguntas;
    }

    public DisciplinaResponseDTO() {
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

    public Integer getPeriodoId() {
        return periodoId;
    }

    public void setPeriodoId(Integer periodoId) {
        this.periodoId = periodoId;
    }

    public List<AlunoResponseDTO> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<AlunoResponseDTO> alunos) {
        this.alunos = alunos;
    }

    public List<PerguntaResponseDTO> getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(List<PerguntaResponseDTO> perguntas) {
        this.perguntas = perguntas;
    }
}