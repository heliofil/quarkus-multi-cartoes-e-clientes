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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

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

            if(!cartaoLista.stream().anyMatch(cartao -> !cartao.getEDigital())){
                return null;
            }

        }
        SolicitacaoCartaoDTO solicitacaoCartao = new SolicitacaoCartaoDTO(cpf,eVirtual);
        CartaoDTO cartaoDTO = processadoraRepository.solicitarCartao(solicitacaoCartao);
        Cartao cartao = mapper.mapCartao(cartaoDTO);
        cartao.setECancelado(false);
        cartao.setEDigital(eVirtual);
        cartao.setDataCriacao(LocalDateTime.now());
        cartao = repository.gravarCartao(cartao);
        if(!cartao.getEDigital()) {
            repository.gravaPedido(new Pedido(null, cartao.getId(), "Emitido", null, null, LocalDateTime.now(), null));
        }
        return cartao;
    }

    @Override
    public Boolean atualizarPedido(Pedido pedido) {
        if(repository.gravaPedido(pedido).getId()==null) {
            return false;
        };
        return true;
    }


    @Override
    public Boolean atualizaCVV(String cpf, long idCartao, int novoCVV, LocalDate dataValiade) {
        return repository.atualizaCVV(cpf, idCartao, novoCVV, dataValiade);
    }

    // Isso no mundo real seria totalmente assincrono;
    @Override
    public Cartao reemitirCartao(long idCartao, int motivo) {
        String cpf = repository.listarCPFPorCartao(idCartao);
        if(repository.atualizaReemissao(idCartao,motivo)){
            repository.cancelarCartoesPorCpf(cpf);
            return solicitarCartao(cpf,false);
        }

        return null;


    }


}
