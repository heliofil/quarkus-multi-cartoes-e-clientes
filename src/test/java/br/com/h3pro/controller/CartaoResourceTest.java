package br.com.h3pro.controller;

import br.com.h3pro.domain.Cliente;
import br.com.h3pro.domain.dto.ClienteDTO;
import br.com.h3pro.service.ClienteService;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;
import static io.restassured.RestAssured.given;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

@QuarkusTest
class CartaoResourceTest {

    @InjectMock
    ClienteService service;

    @Test
    void testCartaoEndpointPostNulll() {

        given()
                .contentType(ContentType.JSON)
        .when()
                .post("/cartao")
        .then()
                .statusCode(Response.Status.BAD_REQUEST.getStatusCode());
    }

    @Test
    void testCartaoEndpointPostError() {

        doThrow(NoSuchElementException.class).when(service).criarCliente(any(Cliente.class));

            given()
                .contentType(ContentType.JSON)
                .body(new ClienteDTO())
                .when()
                .post("/cartao")
                .then()
                .statusCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
    }

    @Test
    void testCartaoEndpointPost() {

        given()
                .contentType(ContentType.JSON)
                .body(new ClienteDTO())
                .when()
                .post("/cartao")
                .then()
                .statusCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
    }

}