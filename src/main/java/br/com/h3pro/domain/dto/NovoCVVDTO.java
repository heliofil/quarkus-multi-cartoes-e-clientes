package br.com.h3pro.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class NovoCVVDTO {

    @JsonProperty("account_id")
    private String cpf;
    @JsonProperty("card_id")
    private long cartao;
    @JsonProperty("next_cvv")
    private int cvv;
    @JsonProperty("expiration_date")
    LocalDateTime dataValiade;

    public NovoCVVDTO(String cpf, long cartao, int cvv, LocalDateTime dataValiade) {
        this.cpf = cpf;
        this.cartao = cartao;
        this.cvv = cvv;
        this.dataValiade = dataValiade;
    }

    public NovoCVVDTO() {
    }

    public String getCpf() {
        return this.cpf;
    }

    public long getCartao() {
        return this.cartao;
    }

    public int getCvv() {
        return this.cvv;
    }

    public LocalDateTime getDataValiade() {
        return this.dataValiade;
    }

    @JsonProperty("account_id")
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @JsonProperty("card_id")
    public void setCartao(long cartao) {
        this.cartao = cartao;
    }

    @JsonProperty("next_cvv")
    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    @JsonProperty("expiration_date")
    public void setDataValiade(LocalDateTime dataValiade) {
        this.dataValiade = dataValiade;
    }
}
