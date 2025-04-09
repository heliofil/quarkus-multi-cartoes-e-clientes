package br.com.h3pro.infrastructure.impl;

import br.com.h3pro.domain.Cliente;
import br.com.h3pro.infrastructure.ClienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;

// As querys poderiam ficar no resource mas por uma questão de time estão na aplicacao
@ApplicationScoped
public class ClienteRepositoryImpl implements ClienteRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public Boolean criarCliente(Cliente cliente) {
        try {
            entityManager.persist(cliente);
            return true;
        }catch (Exception e) {
            //Usar um log estruturado para backtrace
            return false;
        }

    }

    @Transactional
    @Override
    public Boolean desativarCliente(String cpf) {
        try {
            entityManager.createQuery(
                            "UPDATE cliente c SET c.e_ativo = false WHERE e.cpf = :cpf")
                    .setParameter("cpf", cpf)
                    .executeUpdate();
            return true;
        }catch (Exception e){
            //Usar um log estruturado para backtrace
            return false;
        }

    }

    @Transactional
    @Override
    public Boolean reativarCliente(String cpf) {
        try {
            entityManager.createQuery(
                            "UPDATE cliente c SET c.e_ativo = true WHERE e.cpf = :cpf")
                    .setParameter("cpf", cpf)
                    .executeUpdate();
            return true;
        }catch (Exception e){
            //Usar um log estruturado para backtrace
            return false;
        }

    }



}
