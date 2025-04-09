package br.com.h3pro.service.impl;

import br.com.h3pro.domain.Cartao;
import br.com.h3pro.domain.Pedido;
import br.com.h3pro.domain.dto.CartaoDTO;
import br.com.h3pro.domain.dto.SolicitacaoCartaoDTO;
import br.com.h3pro.infrastructure.CartaoRepository;

import br.com.h3pro.infrastructure.ProcessadoraRepository;
import br.com.h3pro.mapper.CartaoMapper;
import br.com.h3pro.service.CartaoService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.time.LocalDateTime;
import java.util.List;

@ApplicationScoped
public class CartaoServiceImpl implements CartaoService {

    @Inject
    CartaoRepository repository;
    @Inject
    CartaoMapper mapper;

    @Inject
    @RestClient
    ProcessadoraRepository processadoraRepository;

    // Poderia ser um objeto estrurado de Status/Error ou Exception ou ate um Enum de mensagens
    @Override
    public Cartao solicitarCartao(String cpf, Boolean eVirtual) {
        if(eVirtual) {
            List<Cartao> cartaoLista =  repository.recuperaListaCartaoPorCpf(cpf);

            if(cartaoLista.stream().anyMatch(cartao -> !cartao.getEDigital())){
                return null;
            }

        }
        SolicitacaoCartaoDTO solicitacaoCartao = new SolicitacaoCartaoDTO(cpf,eVirtual);
        CartaoDTO cartaoDTO = processadoraRepository.solicitarCartao(solicitacaoCartao);
        Cartao cartao = mapper.mapCartao(cartaoDTO);
        cartao.setECancelado(false);
        cartao.setEDigital(eVirtual);
        cartao.setDataCriacao(LocalDateTime.now());
        return repository.gravarCartao(cartao);

    }

    @Override
    public Boolean atualizarPedido(Pedido pedido) {
        return repository.gravaPedido(pedido);

    }

    @Override
    public Boolean atualizaCVV(String cpf, long idCartao, int novoCVV, LocalDateTime dataValiade) {
        return repository.atualizaCVV(cpf, idCartao, novoCVV, dataValiade);
    }


}
