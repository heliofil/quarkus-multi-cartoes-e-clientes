package br.com.h3pro.controller;

import br.com.h3pro.domain.Cliente;
import br.com.h3pro.domain.dto.ClienteDTO;
import br.com.h3pro.service.ClienteService;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.mockito.ArgumentMatchers.any;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doThrow;

@QuarkusTest
class ClienteResourceTest {

    @InjectMock
    ClienteService service;

    @Test
    void testClienteEndpointPostNulll() {

        given()
                .contentType(ContentType.JSON)
        .when()
                .post("/cliente")
        .then()
                .statusCode(Response.Status.BAD_REQUEST.getStatusCode());
    }

    @Test
    void testClienteEndpointPostError() {

           Mockito.when(service.criarCliente(any(Cliente.class))).thenReturn(false);

            given()
                .contentType(ContentType.JSON)
                .body(new ClienteDTO())
                .when()
                .post("/cliente")
                .then()
                .statusCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
    }

    @Test
    void testClienteEndpointPost() {

        Mockito.when(service.criarCliente(any(Cliente.class))).thenReturn(true);

        given()
                .contentType(ContentType.JSON)
                .body(new ClienteDTO())
                .when()
                .post("/cliente")
                .then()
                .statusCode(Response.Status.OK.getStatusCode());
    }

    @Test
    void testClienteEndpointDeleteNull() {

        given()
                .contentType(ContentType.JSON)
                .when()
                .delete("/cliente")
                .then()
                .statusCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
    }

    @Test
    void testClienteEndpointDeleteError() {

        Mockito.when(service.desativarCliente(anyString())).thenReturn(false);

        given()
                .contentType(ContentType.JSON)
                .header("cpf","09876543210")
                .when()
                .delete("/cliente")
                .then()
                .statusCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
    }

    @Test
    void testClienteEndpointDelete() {

        Mockito.when(service.desativarCliente(anyString())).thenReturn(true);

        given()
                .contentType(ContentType.JSON)
                .header("cpf","09876543210")
                .when()
                .delete("/cliente")
                .then()
                .statusCode(Response.Status.OK.getStatusCode());
    }




}