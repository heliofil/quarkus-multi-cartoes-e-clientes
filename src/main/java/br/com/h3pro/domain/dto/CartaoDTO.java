package br.com.h3pro.domain.dto;


public class CartaoDTO {
    String id;
    String numero;
    int cvv;
    Integer validadeMes;
    Integer validadeAno;
    String nome;
    String cpf;
    BandeiraDTO badeira;

    public CartaoDTO(String id, String numero, int cvv, Integer validadeMes, Integer validadeAno, String nome, String cpf, BandeiraDTO badeira) {
        this.id = id;
        this.numero = numero;
        this.cvv = cvv;
        this.validadeMes = validadeMes;
        this.validadeAno = validadeAno;
        this.nome = nome;
        this.cpf = cpf;
        this.badeira = badeira;
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

    public Integer getValidadeMes() {
        return this.validadeMes;
    }

    public Integer getValidadeAno() {
        return this.validadeAno;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }

    public BandeiraDTO getBadeira() {
        return this.badeira;
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

    public void setValidadeMes(Integer validadeMes) {
        this.validadeMes = validadeMes;
    }

    public void setValidadeAno(Integer validadeAno) {
        this.validadeAno = validadeAno;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setBadeira(BandeiraDTO badeira) {
        this.badeira = badeira;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CartaoDTO)) return false;
        final CartaoDTO other = (CartaoDTO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$numero = this.getNumero();
        final Object other$numero = other.getNumero();
        if (this$numero == null ? other$numero != null : !this$numero.equals(other$numero)) return false;
        final Object this$cvv = this.getCvv();
        final Object other$cvv = other.getCvv();
        if (this$cvv == null ? other$cvv != null : !this$cvv.equals(other$cvv)) return false;
        final Object this$validadeMes = this.getValidadeMes();
        final Object other$validadeMes = other.getValidadeMes();
        if (this$validadeMes == null ? other$validadeMes != null : !this$validadeMes.equals(other$validadeMes))
            return false;
        final Object this$validadeAno = this.getValidadeAno();
        final Object other$validadeAno = other.getValidadeAno();
        if (this$validadeAno == null ? other$validadeAno != null : !this$validadeAno.equals(other$validadeAno))
            return false;
        final Object this$nome = this.getNome();
        final Object other$nome = other.getNome();
        if (this$nome == null ? other$nome != null : !this$nome.equals(other$nome)) return false;
        final Object this$cpf = this.getCpf();
        final Object other$cpf = other.getCpf();
        if (this$cpf == null ? other$cpf != null : !this$cpf.equals(other$cpf)) return false;
        final Object this$badeira = this.getBadeira();
        final Object other$badeira = other.getBadeira();
        if (this$badeira == null ? other$badeira != null : !this$badeira.equals(other$badeira)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CartaoDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $numero = this.getNumero();
        result = result * PRIME + ($numero == null ? 43 : $numero.hashCode());
        final Object $cvv = this.getCvv();
        result = result * PRIME + ($cvv == null ? 43 : $cvv.hashCode());
        final Object $validadeMes = this.getValidadeMes();
        result = result * PRIME + ($validadeMes == null ? 43 : $validadeMes.hashCode());
        final Object $validadeAno = this.getValidadeAno();
        result = result * PRIME + ($validadeAno == null ? 43 : $validadeAno.hashCode());
        final Object $nome = this.getNome();
        result = result * PRIME + ($nome == null ? 43 : $nome.hashCode());
        final Object $cpf = this.getCpf();
        result = result * PRIME + ($cpf == null ? 43 : $cpf.hashCode());
        final Object $badeira = this.getBadeira();
        result = result * PRIME + ($badeira == null ? 43 : $badeira.hashCode());
        return result;
    }

    public String toString() {
        return "CartaoDTO(id=" + this.getId() + ", numero=" + this.getNumero() + ", cvv=" + this.getCvv() + ", validadeMes=" + this.getValidadeMes() + ", validadeAno=" + this.getValidadeAno() + ", nome=" + this.getNome() + ", cpf=" + this.getCpf() + ", badeira=" + this.getBadeira() + ")";
    }
}
