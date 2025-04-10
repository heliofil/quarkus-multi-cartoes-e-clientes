package br.com.h3pro.domain;


import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "cartao")
public class Cartao extends PanacheEntityBase {


    public Cartao(Long id, String numero, Integer cvv, String nomeTitular, String cpf, Boolean eDigital, Boolean eCancelado, Boolean eReemitido, Integer motivoReemissao, LocalDate dataValidade, Integer bandeira, LocalDateTime dataCriacao, LocalDateTime dataAtualizacao) {
        this.id = id;
        this.numero = numero;
        this.cvv = cvv;
        this.nomeTitular = nomeTitular;
        this.cpf = cpf;
        this.eDigital = eDigital;
        this.eCancelado = eCancelado;
        this.motivoReemissao = motivoReemissao;
        this.dataValidade = dataValidade;
        this.bandeira = bandeira;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
    }

    public Cartao() {
    }

    public Long getId() {
        return this.id;
    }

    public String getNumero() {
        return this.numero;
    }

    public Integer getCvv() {
        return this.cvv;
    }

    public String getNomeTitular() {
        return this.nomeTitular;
    }

    public String getCpf() {
        return this.cpf;
    }

    public Boolean getEDigital() {
        return this.eDigital;
    }

    public Boolean getECancelado() {
        return this.eCancelado;
    }

    public Integer getMotivoReemissao() {
        return this.motivoReemissao;
    }

    public LocalDate getDataValidade() {
        return this.dataValidade;
    }

    public Integer getBandeira() {
        return this.bandeira;
    }

    public LocalDateTime getDataCriacao() {
        return this.dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return this.dataAtualizacao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEDigital(Boolean eDigital) {
        this.eDigital = eDigital;
    }

    public void setECancelado(Boolean eCancelado) {
        this.eCancelado = eCancelado;
    }


    public void setMotivoReemissao(Integer motivoReemissao) {
        this.motivoReemissao = motivoReemissao;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public void setBandeira(Integer bandeira) {
        this.bandeira = bandeira;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;
    @Column(name = "numero")
    String numero;
    @Column(name = "cvv")
    Integer cvv;
    @Column(name = "nome_titular")
    String nomeTitular;
    @Column(name = "cpf")
    String cpf;
    @Column(name = "e_digital")
    Boolean eDigital;
    @Column(name = "e_cancelado")
    Boolean eCancelado;
    @Column(name = "motivo_reemissao")
    Integer motivoReemissao;
    @Column(name = "data_validade")
    LocalDate dataValidade;
    @Column(name = "id_bandeira")
    Integer bandeira;
    @Column(name = "data_criacao")
    LocalDateTime dataCriacao;
    @Column(name = "data_atualizacao")
    LocalDateTime dataAtualizacao;


}
