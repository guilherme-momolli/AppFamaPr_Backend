package br.edu.famapr.AppFamapr.dto.disciplina;

public class DisciplinaRequestDTO {
    private String nome;
    private String abreviacao;
    private Integer cargahoraria;
    private Integer aulassemanais;
    private Integer periodoId;

    public DisciplinaRequestDTO(String nome, String abreviacao, Integer cargahoraria, Integer aulassemanais, Integer periodoId) {
        this.nome = nome;
        this.abreviacao = abreviacao;
        this.cargahoraria = cargahoraria;
        this.aulassemanais = aulassemanais;
        this.periodoId = periodoId;
    }

    public DisciplinaRequestDTO() {
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getAbreviacao() { return abreviacao; }
    public void setAbreviacao(String abreviacao) { this.abreviacao = abreviacao; }

    public Integer getCargahoraria() { return cargahoraria; }
    public void setCargahoraria(Integer cargahoraria) { this.cargahoraria = cargahoraria; }

    public Integer getAulassemanais() { return aulassemanais; }
    public void setAulassemanais(Integer aulassemanais) { this.aulassemanais = aulassemanais; }

    public Integer getPeriodoId() { return periodoId; }
    public void setPeriodoId(Integer periodoId) { this.periodoId = periodoId; }
}