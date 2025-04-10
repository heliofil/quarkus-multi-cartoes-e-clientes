package br.com.h3pro.service.impl;

import br.com.h3pro.domain.Cliente;
import br.com.h3pro.infrastructure.CartaoRepository;
import br.com.h3pro.infrastructure.ClienteRepository;
import br.com.h3pro.service.ClienteService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.time.LocalDateTime;


@ApplicationScoped
public class ClienteServiceImpl implements ClienteService {


    @Inject
    ClienteRepository repository;

    @Inject
    CartaoRepository cartaoRepository;


    @Override
    public Boolean criarCliente(Cliente cliente)  {

        cliente.setAtivo(true);
        cliente.setDataCriacao(LocalDateTime.now());
        cliente.setDataAtualizacao(null);

        return repository.criarCliente(cliente);

    }

    @Override
    public Boolean desativarCliente(String cpf) {

         if(!repository.desativarCliente(cpf)) {
             return false;
         }

         if(!cartaoRepository.cancelarCartoesPorCpf(cpf)) {

             return false;
         }

         return true;

    }
}
