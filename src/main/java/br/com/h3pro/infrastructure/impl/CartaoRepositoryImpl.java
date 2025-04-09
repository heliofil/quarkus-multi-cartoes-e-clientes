package br.com.h3pro.infrastructure.impl;

import br.com.h3pro.domain.Cartao;
import br.com.h3pro.domain.Pedido;
import br.com.h3pro.infrastructure.CartaoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class CartaoRepositoryImpl implements CartaoRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public List<Cartao> recuperaListaCartaoPorCpf(String cpf) {
        List<Cartao> listaCartao =  entityManager.createQuery(
                        "SELECT c FROM cartao c WHERE c.cpf = :cpf and c.e_cancelado = false", Cartao.class)
                .setParameter("cpf", cpf)
                .getResultList();
        if (Objects.isNull(listaCartao)){
            listaCartao = List.of();
        }
        return listaCartao;
    }


    @Transactional
    @Override
    public Boolean gravarCartao(Cartao cartao) {
        try {
            entityManager.persist(cartao);
            return true;
        }catch (Exception e){
            //Usar um log estruturado para backtrace
            return false;
        }

    }


    @Transactional
    @Override
    public Boolean cancelarCartoesPorCpf(String cpf) {
        try {
            entityManager.createQuery("UPDATE cartao SET e_cancelado=true WHERE c.cpf = :cpf ")
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
    public Boolean atualizaCVV(String cpf, long idCartao, int novoCVV, LocalDateTime dataValiade) {
        try {
            entityManager.createQuery("UPDATE cartao SET cvv=:cvv, data_validade=:data_validade WHERE c.cpf = :cpf and id=:id ")
                    .setParameter("cvv", novoCVV)
                    .setParameter("data_validade", dataValiade)
                    .setParameter("cpf", cpf)
                    .setParameter("id", idCartao)
                    .executeUpdate();
            return true;
        }catch (Exception e){
            //Usar um log estruturado para backtrace
            return false;
        }

    }

    @Transactional
    @Override
    public Boolean gravaPedido(Pedido pedido) {
        try {
            entityManager.persist(pedido);
            return true;
        }catch (Exception e){
            //Usar um log estruturado para backtrace
            return false;
        }

    }

}
