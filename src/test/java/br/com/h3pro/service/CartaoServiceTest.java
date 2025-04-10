package br.com.h3pro.service;

import br.com.h3pro.domain.Cartao;
import br.com.h3pro.domain.Pedido;
import br.com.h3pro.domain.dto.CartaoDTO;
import br.com.h3pro.domain.dto.SolicitacaoCartaoDTO;
import br.com.h3pro.infrastructure.CartaoRepository;
import br.com.h3pro.infrastructure.ProcessadoraRepository;
import br.com.h3pro.mapper.CartaoMapper;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Produces;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import util.MockTests;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;

@QuarkusTest
class CartaoServiceTest {

    @Inject
    CartaoService service;

    @InjectMock
    CartaoRepository repository;
    @InjectMock
    CartaoMapper mapper;

    @Produces
    @ApplicationScoped
    ProcessadoraRepository mockProcessadora() {
        return Mockito.mock(ProcessadoraRepository.class);
    }


    @Test
    void testSolicitarCartaoSoVirtual() {

        List<Cartao> cartoes = Collections.emptyList();

        Mockito.when(repository.recuperaListaCartaoPorCpf(anyString()))
                .thenReturn(cartoes);

        Assertions.assertNull(service.solicitarCartao("12345678901", true));


    }

    @Test
    void testSolicitarCartaoEVirtualComFisico() {

        List<Cartao> cartoes = List.of(MockTests.cartao(false,false));

        Mockito.when(repository.recuperaListaCartaoPorCpf(anyString()))
                .thenReturn(cartoes);

        Mockito.when(mockProcessadora().solicitarCartao(any(SolicitacaoCartaoDTO.class)))
                .thenReturn(MockTests.cartaoDTO());

        Mockito.when(mapper.mapCartao(any(CartaoDTO.class)))
                .thenReturn(MockTests.cartao(false,false));

        Mockito.when(repository.gravaPedido(any(Pedido.class)))
                .thenReturn(MockTests.pedido());

        Mockito.when(repository.gravarCartao(any(Cartao.class)))
                .thenReturn(MockTests.cartao(true,false));

        Assertions.assertEquals(service.solicitarCartao("12345678901", true).getId(),12L);


    }

    @Test
    void testAtualizaPedidoOk() {

        Mockito.when(repository.gravaPedido(any(Pedido.class)))
                .thenReturn(MockTests.pedido());

        Assertions.assertTrue(service.atualizarPedido(MockTests.pedido()));


    }

    @Test
    void testAtualizaPedidoNOK() {

        Mockito.when(repository.gravaPedido(any(Pedido.class)))
                .thenReturn(new Pedido());

        Assertions.assertFalse(service.atualizarPedido(MockTests.pedido()));

    }

    @Test
    void testAtualizaCVVOK() {

        Mockito.when(repository.atualizaCVV(anyString(),anyLong() ,anyInt(),any(LocalDate.class) ))
                .thenReturn(true);

        Assertions.assertTrue(service.atualizaCVV("09876543219",
            12,
            123,
            LocalDate.now())
        );

    }





}