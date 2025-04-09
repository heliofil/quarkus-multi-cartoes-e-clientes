package br.com.h3pro.domain.dto;

public class BandeiraDTO {
    Integer codigo;
    String nome;

    public BandeiraDTO(Integer codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public BandeiraDTO() {
    }

    public Integer getCodigo() {
        return this.codigo;
    }

    public String getNome() {
        return this.nome;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
