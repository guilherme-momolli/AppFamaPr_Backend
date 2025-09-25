package br.edu.famapr.AppFamapr.dto.aluno;

import java.time.LocalDate;

import java.time.LocalDate;

public class AlunoRequestDTO {
    private String nome;
    private String cpf;
    private String senha;
    private String sexo;
    private LocalDate datanasc;
    private String telefone;
    private String email;

    public AlunoRequestDTO(String nome, String cpf, String senha, String sexo, LocalDate datanasc, String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.sexo = sexo;
        this.datanasc = datanasc;
        this.telefone = telefone;
        this.email = email;
    }

    public AlunoRequestDTO() {
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getSexo() { return sexo; }
    public void setSexo(String sexo) { this.sexo = sexo; }

    public LocalDate getDatanasc() { return datanasc; }
    public void setDatanasc(LocalDate datanasc) { this.datanasc = datanasc; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
