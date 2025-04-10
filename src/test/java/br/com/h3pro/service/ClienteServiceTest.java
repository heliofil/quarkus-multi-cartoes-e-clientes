package br.com.h3pro.service;

import br.com.h3pro.domain.Cartao;
import br.com.h3pro.domain.Cliente;
import br.com.h3pro.domain.Pedido;
import br.com.h3pro.domain.dto.CartaoDTO;
import br.com.h3pro.domain.dto.SolicitacaoCartaoDTO;
import br.com.h3pro.infrastructure.CartaoRepository;
import br.com.h3pro.infrastructure.ClienteRepository;
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
class ClienteServiceTest {

    @Inject
    ClienteService service;

    @InjectMock
    ClienteRepository repository;

    @InjectMock
    CartaoRepository cartaoRepository;



    @Test
    void testCriarClienteError() {

        Mockito.when(repository.criarCliente(any(Cliente.class)))
                .thenReturn(false);

        Assertions.assertFalse(service.criarCliente(MockTests.cliente()));

    }

    @Test
    void testCriarCliente() {

        Mockito.when(repository.criarCliente(any(Cliente.class)))
                .thenReturn(true);

        Assertions.assertTrue(service.criarCliente(MockTests.cliente()));

    }


    @Test
    void testDesativarClienteError() {

        Mockito.when(repository.desativarCliente(anyString()))
                .thenReturn(true);

        Mockito.when(cartaoRepository.cancelarCartoesPorCpf(anyString()))
                .thenReturn(false);


        Assertions.assertFalse(service.desativarCliente("12345678909"));

    }

    @Test
    void testDesativarCliente() {

        Mockito.when(repository.desativarCliente(anyString()))
                .thenReturn(true);

        Mockito.when(cartaoRepository.cancelarCartoesPorCpf(anyString()))
                .thenReturn(true);


        Assertions.assertTrue(service.desativarCliente("12345678909"));

    }





}