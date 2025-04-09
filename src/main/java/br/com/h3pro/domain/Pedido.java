package br.com.h3pro.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "pedido")
public class Pedido {


    @Column(name = "id")
    private String id;
    @Column(name = "id_cartao")
    private long idCartao;
    @Column(name = "situacao")
    private String situacao;
    @Column(name = "observacao")
    String observacao;
    @Column(name = "endereco_entrega")
    String endereco;
    @Column(name = "data_criacao)")
    LocalDateTime dataCriacao;
    @Column(name = "data_atualizacao)")
    LocalDateTime dataAtualizacao;


    public Pedido(String id, long idCartao, String situacao, String observacao, String endereco, LocalDateTime dataCriacao, LocalDateTime dataAtualizacao) {
        this.id = id;
        this.idCartao = idCartao;
        this.situacao = situacao;
        this.observacao = observacao;
        this.endereco = endereco;
        this.dataCriacao = dataCriacao;
        this.dataAtualizacao = dataAtualizacao;
    }

    public Pedido() {
    }

    public String getId() {
        return this.id;
    }

    public long getIdCartao() {
        return this.idCartao;
    }

    public String getSituacao() {
        return this.situacao;
    }

    public String getObservacao() {
        return this.observacao;
    }

    public String getEndereco() {
        return this.endereco;
    }

    public LocalDateTime getDataCriacao() {
        return this.dataCriacao;
    }

    public LocalDateTime getDataAtualizacao() {
        return this.dataAtualizacao;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIdCartao(long idCartao) {
        this.idCartao = idCartao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
