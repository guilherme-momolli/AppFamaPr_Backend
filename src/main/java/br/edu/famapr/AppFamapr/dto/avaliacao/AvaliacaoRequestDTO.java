package br.edu.famapr.AppFamapr.dto.avaliacao;

import java.time.LocalDateTime;

public class AvaliacaoRequestDTO {

    private LocalDateTime dataAvaliacao;
    private Integer matriculaId;

    public AvaliacaoRequestDTO() {}

    public AvaliacaoRequestDTO(LocalDateTime dataAvaliacao, Integer matriculaId) {
        this.dataAvaliacao = dataAvaliacao;
        this.matriculaId = matriculaId;
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
