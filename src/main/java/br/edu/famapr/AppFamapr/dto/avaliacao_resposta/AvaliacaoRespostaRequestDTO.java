package br.edu.famapr.AppFamapr.dto.avaliacao_resposta;

public class AvaliacaoRespostaRequestDTO {

    private Integer avaliacaoId;
    private Integer perguntaId;
    private Integer alunoId;

    private Integer opcaoId;

    private String respostaTexto;

    private Integer valorNumerico;

    public AvaliacaoRespostaRequestDTO() {}

    public AvaliacaoRespostaRequestDTO(Integer avaliacaoId,
                                       Integer perguntaId,
                                       Integer alunoId,
                                       Integer opcaoId,
                                       String respostaTexto,
                                       Integer valorNumerico) {
        this.avaliacaoId = avaliacaoId;
        this.perguntaId = perguntaId;
        this.alunoId = alunoId;
        this.opcaoId = opcaoId;
        this.respostaTexto = respostaTexto;
        this.valorNumerico = valorNumerico;
    }

    public Integer getAvaliacaoId() { return avaliacaoId; }
    public void setAvaliacaoId(Integer avaliacaoId) { this.avaliacaoId = avaliacaoId; }

    public Integer getPerguntaId() { return perguntaId; }
    public void setPerguntaId(Integer perguntaId) { this.perguntaId = perguntaId; }

    public Integer getAlunoId() { return alunoId; }
    public void setAlunoId(Integer alunoId) { this.alunoId = alunoId; }

    public Integer getOpcaoId() { return opcaoId; }
    public void setOpcaoId(Integer opcaoId) { this.opcaoId = opcaoId; }

    public String getRespostaTexto() { return respostaTexto; }
    public void setRespostaTexto(String respostaTexto) { this.respostaTexto = respostaTexto; }

    public Integer getValorNumerico() { return valorNumerico; }
    public void setValorNumerico(Integer valorNumerico) { this.valorNumerico = valorNumerico; }
}
