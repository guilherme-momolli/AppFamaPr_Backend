package br.edu.famapr.AppFamapr.dto.pergunta;

public class PerguntaRequestDTO {

    private String titulo;
    private Integer avaliacaoId;

    public PerguntaRequestDTO() {}

    public PerguntaRequestDTO(String titulo, Integer avaliacaoId) {
        this.titulo = titulo;
        this.avaliacaoId = avaliacaoId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAvaliacaoId() {
        return avaliacaoId;
    }

    public void setAvaliacaoId(Integer avaliacaoId) {
        this.avaliacaoId = avaliacaoId;
    }
}