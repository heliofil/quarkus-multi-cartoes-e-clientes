package br.com.h3pro.infrastructure;

import br.com.h3pro.domain.Cartao;
import br.com.h3pro.domain.Pedido;

import java.time.LocalDate;
import java.util.List;

public interface CartaoRepository {

    String listarCPFPorCartao(long idCartao);

    Cartao gravarCartao(Cartao cartao);

    List<Cartao> recuperaListaCartaoPorCpf(String cpf);

    Boolean cancelarCartoesPorCpf(String cpf);

    Boolean atualizaReemissao(long idCartao, int motivo);

    Pedido gravaPedido(Pedido pedido);

    Boolean atualizaCVV(String cpf, long idCartao, int novoCVV, LocalDate dataValiade);

}
