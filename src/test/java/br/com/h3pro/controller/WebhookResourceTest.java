package br.com.h3pro.controller;


import br.com.h3pro.domain.Pedido;
import br.com.h3pro.domain.dto.NovoCVVDTO;
import br.com.h3pro.domain.dto.PedidoDTO;
import br.com.h3pro.mapper.CartaoMapper;
import br.com.h3pro.service.CartaoService;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static io.restassured.RestAssured.given;
import static org.mockito.ArgumentMatchers.*;


@QuarkusTest
class WebhookResourceTest {

    @InjectMock
    CartaoService service;
    @InjectMock
    CartaoMapper mapper;

    @Test
    void testDeliveryEndpointPostNotFound() {

        given()
                .contentType(ContentType.JSON)
                .when()
                .put("/webhook/delivery/status/19")
                .then()
                .statusCode(Response.Status.NOT_FOUND.getStatusCode());
    }

    @Test
    void testDeliveryEndpointPostNulll() {

        given()
                .contentType(ContentType.JSON)
        .when()
                .put("/webhook/delivery/status/89743a65-1982-4fdd-9aa5-02634c182844")
        .then()
                .statusCode(Response.Status.BAD_REQUEST.getStatusCode());
    }

    @Test
    void testDeliveryEndpointPostError() {

        Mockito.when(mapper.mapPedido(any(PedidoDTO.class))).thenReturn(new Pedido("1",1L,"REALIZADO","Não Entregue","Rua Augusta 12", LocalDateTime.now(),null));
        Mockito.when(service.atualizarPedido(any(Pedido.class))).thenReturn(false);

            given()
                .contentType(ContentType.JSON)
                .body(new PedidoDTO(1L,"REALIZADO",LocalDateTime.now(),"Não Entregue","Rua Augusta 12"))
                .when()
                    .put("/webhook/delivery/status/89743a65-1982-4fdd-9aa5-02634c182844")
                .then()
                    .statusCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
    }

    @Test
    void testDeliveryEndpointPost() {

        Mockito.when(mapper.mapPedido(any(PedidoDTO.class))).thenReturn(new Pedido("1",1L,"REALIZADO","Não Entregue","Rua Augusta 12", LocalDateTime.now(),null));
        Mockito.when(service.atualizarPedido(any(Pedido.class))).thenReturn(true);

        given()
                .contentType(ContentType.JSON)
                .body(new PedidoDTO(1L,"REALIZADO",LocalDateTime.now(),"Não Entregue","Rua Augusta 12"))
                .when()
                .put("/webhook/delivery/status/89743a65-1982-4fdd-9aa5-02634c182844")
                .then()
                .statusCode(Response.Status.OK.getStatusCode());
    }

    @Test
    void testCVVEndpointPostNotFound() {

        given()
                .contentType(ContentType.JSON)
                .when()
                .put("/webhook/card/virtual/cvv/20")
                .then()
                .statusCode(Response.Status.NOT_FOUND.getStatusCode());
    }

    @Test
    void testCVVEndpointPostNulll() {

        given()
                .contentType(ContentType.JSON)
                .when()
                .put("/webhook/card/virtual/cvv/27764a7e-3522-4a70-9ef0-fc169822a366")
                .then()
                .statusCode(Response.Status.BAD_REQUEST.getStatusCode());
    }

    @Test
    void testCVVEndpointPostError() {

        Mockito.when(service.atualizaCVV(anyString(),anyLong(),anyInt(),any(LocalDate.class))).thenReturn(false);

        given()
                .contentType(ContentType.JSON)
                .body(new NovoCVVDTO())
                .when()
                .put("/webhook/card/virtual/cvv/27764a7e-3522-4a70-9ef0-fc169822a366")
                .then()
                .statusCode(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode());
    }

    @Test
    void testCVVEndpointPost() {

        Mockito.when(service.atualizaCVV(anyString(),anyLong(),anyInt(),any(LocalDate.class))).thenReturn(true);

        given()
                .contentType(ContentType.JSON)
                .body(new NovoCVVDTO("12345678901",1L,467,LocalDate.now()))
                .when()
                .put("/webhook/card/virtual/cvv/27764a7e-3522-4a70-9ef0-fc169822a366")
                .then()
                .statusCode(Response.Status.OK.getStatusCode());
    }



}