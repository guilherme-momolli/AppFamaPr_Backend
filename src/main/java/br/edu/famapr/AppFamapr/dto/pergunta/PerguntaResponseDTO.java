package br.edu.famapr.AppFamapr.dto.pergunta;

import br.edu.famapr.AppFamapr.dto.resposta.RespostaResponseDTO;

import java.util.ArrayList;
import java.util.List;

public class PerguntaResponseDTO {

    private Integer id;
    private String titulo;
    private Integer avaliacaoId;
    private List<RespostaResponseDTO> respostaResponseDTOSList = new ArrayList<>();

    public PerguntaResponseDTO() {}

    public PerguntaResponseDTO(Integer id,
                               String titulo,
                               Integer avaliacaoId,
                               List<RespostaResponseDTO> respostaResponseDTOSList
    ) {
        this.id = id;
        this.titulo = titulo;
        this.avaliacaoId = avaliacaoId;
        this.respostaResponseDTOSList = respostaResponseDTOSList;
    }

    public List<RespostaResponseDTO> getRespostaResponseDTOSList() {
        return respostaResponseDTOSList;
    }

    public void setRespostaResponseDTOSList(List<RespostaResponseDTO> respostaResponseDTOSList) {
        this.respostaResponseDTOSList = respostaResponseDTOSList;
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

    public Integer getAvaliacaoId() {
        return avaliacaoId;
    }

    public void setAvaliacaoId(Integer avaliacaoId) {
        this.avaliacaoId = avaliacaoId;
    }
}