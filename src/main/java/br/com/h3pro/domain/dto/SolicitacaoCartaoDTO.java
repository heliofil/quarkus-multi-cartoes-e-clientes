package br.com.h3pro.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SolicitacaoCartaoDTO {
    private String cpf;
    @JsonProperty("e-virtual")
    private Boolean eVirtual;

    public SolicitacaoCartaoDTO(String cpf, Boolean eVirtual) {
        this.cpf = cpf;
        this.eVirtual = eVirtual;
    }

    public SolicitacaoCartaoDTO() {
    }

    public String getCpf() {
        return this.cpf;
    }

    public Boolean getEVirtual() {
        return this.eVirtual;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEVirtual(Boolean eVirtual) {
        this.eVirtual = eVirtual;
    }


}
