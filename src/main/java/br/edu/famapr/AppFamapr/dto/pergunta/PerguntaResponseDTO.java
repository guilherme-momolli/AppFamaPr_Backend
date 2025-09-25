package br.edu.famapr.AppFamapr.dto.pergunta;

public class PerguntaResponseDTO {

    private Integer id;
    private String titulo;
    private Integer disciplinaId;

    public PerguntaResponseDTO() {}

    public PerguntaResponseDTO(Integer id, String titulo, Integer disciplinaId) {
        this.id = id;
        this.titulo = titulo;
        this.disciplinaId = disciplinaId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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