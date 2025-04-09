package br.com.h3pro.service;

import br.com.h3pro.domain.Cartao;
import br.com.h3pro.domain.Pedido;

import java.time.LocalDateTime;

public interface CartaoService {

    Cartao solicitarCartao(String cpf, Boolean eVirtual);

    Boolean atualizarPedido(Pedido pedido);

    Boolean atualizaCVV(String cpf,long idCartao,int novoCVV, LocalDateTime dataValiade);


}
