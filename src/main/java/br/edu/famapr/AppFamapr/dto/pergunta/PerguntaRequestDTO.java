package br.edu.famapr.AppFamapr.dto.pergunta;

public class PerguntaRequestDTO {

    private String titulo;
    private Integer disciplinaId;

    public PerguntaRequestDTO() {}

    public PerguntaRequestDTO(String titulo, Integer disciplinaId) {
        this.titulo = titulo;
        this.disciplinaId = disciplinaId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(Integer disciplinaId) {
        this.disciplinaId = disciplinaId;
    }
}