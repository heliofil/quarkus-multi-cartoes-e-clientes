package br.com.h3pro.controller;

import br.com.h3pro.domain.Cartao;
import br.com.h3pro.domain.Cliente;
import br.com.h3pro.domain.dto.CartaoDTO;
import br.com.h3pro.domain.dto.ClienteDTO;
import br.com.h3pro.domain.dto.SolicitacaoCartaoDTO;
import br.com.h3pro.mapper.CartaoMapper;
import br.com.h3pro.service.CartaoService;
import br.com.h3pro.service.ClienteService;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.ArgumentMatchers.*;

@QuarkusTest
class CartaoResourceTest {

    @InjectMock
    CartaoService service;
    @InjectMock
    CartaoMapper mapper;

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

           Mockito.when(service.solicitarCartao(anyString(),anyBoolean())).thenReturn(null);

            given()
                .contentType(ContentType.JSON)
                .body(new SolicitacaoCartaoDTO())
                .when()
                .post("/cartao")
                .then()
                .statusCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
    }

    @Test
    void testClienteEndpointPost() {

        CartaoDTO cartaoDTO = new CartaoDTO();
        cartaoDTO.setId("1");

        Mockito.when(service.solicitarCartao(anyString(),anyBoolean())).thenReturn(new Cartao());
        Mockito.when(mapper.mapCartao(any(Cartao.class))).thenReturn(cartaoDTO);

        given()
                .contentType(ContentType.JSON)
                .body(new SolicitacaoCartaoDTO("12345678901",true))
                .when()
                .post("/cartao")
                .then()
                .statusCode(Response.Status.OK.getStatusCode())
                .body("id",equalTo("1"));
    }

    @Test
    void testClienteEndpointReemissao() {

        CartaoDTO cartaoDTO = new CartaoDTO();
        cartaoDTO.setId("2");

        Mockito.when(service.reemitirCartao(anyLong(),anyInt())).thenReturn(new Cartao());
        Mockito.when(mapper.mapCartao(any(Cartao.class))).thenReturn(cartaoDTO);


        given()
                .contentType(ContentType.JSON)
                .when()
                .post("/cartao/reemissao/1/2")
                .then()
                .statusCode(Response.Status.CREATED.getStatusCode())
                .body("id",equalTo("2"));
    }

    @Test
    void testClienteEndpointReemissaoError() {

        Mockito.when(service.reemitirCartao(anyLong(),anyInt())).thenReturn(null);

        given()
                .contentType(ContentType.JSON)
                .when()
                .post("/cartao/reemissao/1/2")
                .then()
                .statusCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
    }




}