package br.com.h3pro.domain.dto;

public class SolicitacaoCartaoDTO {
    private String cpf;
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
