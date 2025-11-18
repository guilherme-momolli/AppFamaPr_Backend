package br.edu.famapr.AppFamapr.dto.avaliacao_resposta;

import java.time.LocalDateTime;

public class AvaliacaoRespostaResponseDTO {

    private Integer id;
    private Integer avaliacaoId;
    private Integer perguntaId;
    private Integer alunoId;

    private Integer opcaoId;
    private String respostaTexto;
    private Integer valorNumerico;

    private LocalDateTime respondidoEm;

    public AvaliacaoRespostaResponseDTO() {}

    public AvaliacaoRespostaResponseDTO(
            Integer id,
            Integer avaliacaoId,
            Integer perguntaId,
            Integer alunoId,
            Integer opcaoId,
            String respostaTexto,
            Integer valorNumerico,
            LocalDateTime respondidoEm
    ) {
        this.id = id;
        this.avaliacaoId = avaliacaoId;
        this.perguntaId = perguntaId;
        this.alunoId = alunoId;
        this.opcaoId = opcaoId;
        this.respostaTexto = respostaTexto;
        this.valorNumerico = valorNumerico;
        this.respondidoEm = respondidoEm;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

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

    public LocalDateTime getRespondidoEm() { return respondidoEm; }
    public void setRespondidoEm(LocalDateTime respondidoEm) { this.respondidoEm = respondidoEm; }
}