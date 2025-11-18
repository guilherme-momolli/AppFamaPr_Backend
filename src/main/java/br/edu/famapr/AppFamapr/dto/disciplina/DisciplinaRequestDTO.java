package br.edu.famapr.AppFamapr.dto.disciplina;


public class DisciplinaRequestDTO {
    private String nome;
    private String abreviacao;
    private Integer cargaHoraria;
    private Integer aulasSemanais;
    private Integer periodoId;

    public DisciplinaRequestDTO() {
    }

    public DisciplinaRequestDTO(String nome,
                                String abreviacao,
                                Integer cargaHoraria,
                                Integer aulasSemanais,
                                Integer periodoId) {
        this.nome = nome;
        this.abreviacao = abreviacao;
        this.cargaHoraria = cargaHoraria;
        this.aulasSemanais = aulasSemanais;
        this.periodoId = periodoId;
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
}