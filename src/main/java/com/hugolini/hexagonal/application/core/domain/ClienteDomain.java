package com.hugolini.hexagonal.application.core.domain;

public class ClienteDomain {

    private String id;
    private String nome;
    private EnderecoDomain endereco;
    private String cpf;
    private Boolean cpfValido;

    // Construtores, getters e setters aqui abaixo
    // Não usar Lombok em classe de dominio

    public ClienteDomain() {
        cpfValido = false;
    }

    public ClienteDomain(String id, String nome, EnderecoDomain endereco, String cpf, Boolean cpfValido) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.cpfValido = cpfValido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EnderecoDomain getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDomain endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Boolean getCpfValido() {
        return cpfValido;
    }

    public void setCpfValido(Boolean cpfValido) {
        this.cpfValido = cpfValido;
    }
}
