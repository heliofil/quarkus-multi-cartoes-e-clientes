package br.com.h3pro.service;

import br.com.h3pro.domain.Cartao;
import br.com.h3pro.domain.Pedido;

import java.time.LocalDate;


public interface CartaoService {

    Cartao solicitarCartao(String cpf, Boolean eVirtual);

    Boolean atualizarPedido(Pedido pedido);

    Boolean atualizaCVV(String cpf,long idCartao,int novoCVV, LocalDate dataValiade);

    Cartao reemitirCartao(long idCartao, int motivo);

}
