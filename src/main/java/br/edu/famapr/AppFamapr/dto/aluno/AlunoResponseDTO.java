package br.edu.famapr.AppFamapr.dto.aluno;

import br.edu.famapr.AppFamapr.dto.matricula.MatriculaResponseDTO;

import java.time.LocalDate;
import java.util.List;

public class AlunoResponseDTO {
    private Integer id;
    private String nome;
    private String cpf;
    private String sexo;
    private LocalDate datanasc;
    private String telefone;
    private String email;


    public AlunoResponseDTO() {
    }

    public AlunoResponseDTO(Integer id, String nome, String cpf, String sexo, LocalDate datanasc, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.sexo = sexo;
        this.datanasc = datanasc;
        this.telefone = telefone;
        this.email = email;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public LocalDate getDatanasc() { return datanasc; }
    public void setDatanasc(LocalDate datanasc) { this.datanasc = datanasc; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}