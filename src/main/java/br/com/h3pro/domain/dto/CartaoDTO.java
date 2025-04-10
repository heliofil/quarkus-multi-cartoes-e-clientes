package br.com.h3pro.domain.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class CartaoDTO {
    String id;
    String numero;
    int cvv;
    @JsonProperty("data-validade")
    LocalDate dataValidade;
    String nome;
    String cpf;
    int bandeira;



    public CartaoDTO(String id, String numero, int cvv, LocalDate dataValidade, String nome, String cpf, int badeira) {
        this.id = id;
        this.numero = numero;
        this.cvv = cvv;
        this.dataValidade = dataValidade;
        this.nome = nome;
        this.cpf = cpf;
        this.bandeira = badeira;
    }

    public CartaoDTO() {
    }

    public String getId() {
        return this.id;
    }

    public String getNumero() {
        return this.numero;
    }

    public int getCvv() {
        return this.cvv;
    }

    public LocalDate getDataValidade() {
        return this.dataValidade;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public int getBandeira() {
        return this.bandeira;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setBandeira(int badeira) {
        this.bandeira = badeira;
    }
}
