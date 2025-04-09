package br.com.h3pro.infrastructure;

import br.com.h3pro.domain.Cartao;
import br.com.h3pro.domain.Pedido;

import java.time.LocalDateTime;
import java.util.List;

public interface CartaoRepository {

    Boolean gravarCartao(Cartao cartao);

    List<Cartao> recuperaListaCartaoPorCpf(String cpf);

    Boolean cancelarCartoesPorCpf(String cpf);

    Boolean gravaPedido(Pedido pedido);

    Boolean atualizaCVV(String cpf, long idCartao, int novoCVV, LocalDateTime dataValiade);

}
