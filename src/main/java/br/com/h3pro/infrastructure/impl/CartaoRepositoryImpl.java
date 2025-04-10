package br.com.h3pro.infrastructure.impl;

import br.com.h3pro.domain.Cartao;
import br.com.h3pro.domain.Pedido;
import br.com.h3pro.infrastructure.CartaoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

// As querys poderiam ficar no resource mas por uma questão de time estão na aplicacao
@ApplicationScoped
public class CartaoRepositoryImpl implements CartaoRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    @Override
    public List<Cartao> recuperaListaCartaoPorCpf(String cpf) {
        List<Cartao> listaCartao =  entityManager.createQuery("SELECT c FROM Cartao c WHERE c.cpf = :cpf and c.eCancelado = false", Cartao.class)
                .setParameter("cpf", cpf)
                .getResultList();
        if (Objects.isNull(listaCartao)){
            listaCartao = List.of();
        }
        return listaCartao;
    }


    @Transactional
    @Override
    public Cartao gravarCartao(Cartao cartao) {
            entityManager.persist(cartao);
            entityManager.flush();
            return cartao;


    }

    @Transactional
    @Override
    public String listarCPFPorCartao(long idCartao) {
        return entityManager.createQuery("SELECT c FROM Cartao c WHERE c.id=:id", Cartao.class)
                .setParameter("id", idCartao)
                .getSingleResult().getCpf();
    }


    @Transactional
    @Override
    public Boolean cancelarCartoesPorCpf(String cpf) {
        try {
            entityManager.createQuery("UPDATE Cartao c SET c.eCancelado=true, c.dataAtualizacao = CURRENT_TIMESTAMP WHERE c.cpf = :cpf ")
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
    public Boolean atualizaReemissao(long idCartao,int motivo ) {
        try {
            entityManager.createQuery("UPDATE Cartao c SET c.motivoReemissao = :motivo, c.eCancelado = true, c.dataAtualizacao = CURRENT_TIMESTAMP WHERE c.id = :id")
                    .setParameter("id", idCartao)
                    .setParameter("motivo", motivo)
                    .executeUpdate();
            return true;
        }catch (Exception e){
            //Usar um log estruturado para backtrace
            return false;
        }
    }

    @Transactional
    @Override
    public Boolean atualizaCVV(String cpf, long idCartao, int novoCVV, LocalDate dataValiade) {
        try {
            entityManager.createQuery("UPDATE Cartao c SET c.cvv=:cvv, c.dataValidade=:validade,  c.dataAtualizacao = CURRENT_TIMESTAMP WHERE  c.id=:id and c.cpf=:cpf ")
                    .setParameter("cvv", novoCVV)
                    .setParameter("validade", dataValiade)
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
    public Pedido gravaPedido(Pedido pedido) {

        entityManager.persist(pedido);
        entityManager.flush();

        return pedido;


    }

}
