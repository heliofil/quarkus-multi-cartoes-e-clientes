package br.com.h3pro.service;

import br.com.h3pro.domain.Cliente;

public interface ClienteService {

    public Boolean criarCliente(Cliente cliente);

    public Boolean desativarCliente(String cpf);

}
