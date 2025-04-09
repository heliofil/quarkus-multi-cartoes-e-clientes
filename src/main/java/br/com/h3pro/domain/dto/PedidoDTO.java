package br.com.h3pro.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class PedidoDTO {

        @JsonProperty("tracking_id")
        private String idCartao;
        @JsonProperty("delivery_status")
        private String situacao;
        @JsonProperty("delivery_status")
        private LocalDateTime dataEntrega;
        @JsonProperty("delivery_status")
        String observacao;
        @JsonProperty("delivery_status")
        String endereco;


}
