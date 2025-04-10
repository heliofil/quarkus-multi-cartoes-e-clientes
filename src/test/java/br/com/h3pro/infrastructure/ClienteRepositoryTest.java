package br.com.h3pro.infrastructure;

import br.com.h3pro.domain.Cliente;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TransactionRequiredException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import util.MockTests;



import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.any;

@QuarkusTest
class ClienteRepositoryTest {

    @Inject
    ClienteRepository repository;

    @InjectMock
    EntityManager entityManager;

    @Test
    void criarClienteError() {

        Mockito.doThrow(TransactionRequiredException.class).when(entityManager).persist(any(Cliente.class));

        Assertions.assertFalse(repository.criarCliente(MockTests.cliente()));

    }

    @Test
    void criarCliente() {
        Mockito.doNothing().when(entityManager).persist(any(Cliente.class));

        Assertions.assertTrue(repository.criarCliente(MockTests.cliente()));

    }

    @Test
    void desativarClienteError() {
        Mockito.doThrow(TransactionRequiredException.class).when(entityManager).createQuery(anyString());
        Assertions.assertFalse(repository.desativarCliente("12345678909"));
    }



}