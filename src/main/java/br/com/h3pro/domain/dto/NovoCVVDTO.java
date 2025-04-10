package br.com.h3pro.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class NovoCVVDTO {

    @JsonProperty("account_id")
    private String cpf;
    @JsonProperty("card_id")
    private long cartao;
    @JsonProperty("next_cvv")
    private int cvv;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("expiration_date")
    LocalDate dataValiade;

    public NovoCVVDTO(String cpf, long cartao, int cvv, LocalDate dataValiade) {
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

    public LocalDate getDataValiade() {
        return this.dataValiade;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setCartao(long cartao) {
        this.cartao = cartao;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public void setDataValiade(LocalDate dataValiade) {
        this.dataValiade = dataValiade;
    }
}
