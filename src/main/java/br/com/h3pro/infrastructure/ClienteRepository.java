package br.com.h3pro.infrastructure;

import br.com.h3pro.domain.Cliente;

public interface ClienteRepository {


    public Boolean criarCliente(Cliente cliente);
    public Boolean desativarCliente(String cpf);
    public Boolean reativarCliente(String cpf);
}
