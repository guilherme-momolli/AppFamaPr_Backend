package br.edu.famapr.AppFamapr.dto.resposta;

public class RespostaRequestDTO {

    private Integer respostaNumero;
    private String respostaTexto;
    private Integer avaliacaoId;
    private Integer perguntaId;

    public RespostaRequestDTO() {}

    public RespostaRequestDTO(Integer respostaNumero, String respostaTexto, Integer avaliacaoId, Integer perguntaId) {
        this.respostaNumero = respostaNumero;
        this.respostaTexto = respostaTexto;
        this.avaliacaoId = avaliacaoId;
        this.perguntaId = perguntaId;
    }

    public Integer getRespostaNumero() {
        return respostaNumero;
    }

    public void setRespostaNumero(Integer respostaNumero) {
        this.respostaNumero = respostaNumero;
    }

    public String getRespostaTexto() {
        return respostaTexto;
    }

    public void setRespostaTexto(String respostaTexto) {
        this.respostaTexto = respostaTexto;
    }

    public Integer getAvaliacaoId() {
        return avaliacaoId;
    }

    public void setAvaliacaoId(Integer avaliacaoId) {
        this.avaliacaoId = avaliacaoId;
    }

    public Integer getPerguntaId() {
        return perguntaId;
    }

    public void setPerguntaId(Integer perguntaId) {
        this.perguntaId = perguntaId;
    }
}