package br.edu.famapr.AppFamapr.dto.avaliacao;

import java.time.LocalDateTime;

public class AvaliacaoResponseDTO {

    private Integer id;
    private LocalDateTime dataAvaliacao;
    private Integer matriculaId;


    public AvaliacaoResponseDTO() {}

    public AvaliacaoResponseDTO(Integer id, LocalDateTime dataAvaliacao, Integer matriculaId, String alunoNome, String disciplinaNome) {
        this.id = id;
        this.dataAvaliacao = dataAvaliacao;
        this.matriculaId = matriculaId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(LocalDateTime dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public Integer getMatriculaId() {
        return matriculaId;
    }

    public void setMatriculaId(Integer matriculaId) {
        this.matriculaId = matriculaId;
    }

}