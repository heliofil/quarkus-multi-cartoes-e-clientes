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


        public PedidoDTO(String idCartao, String situacao, LocalDateTime dataEntrega, String observacao, String endereco) {
                this.idCartao = idCartao;
                this.situacao = situacao;
                this.dataEntrega = dataEntrega;
                this.observacao = observacao;
                this.endereco = endereco;
        }

        public PedidoDTO() {
        }

        public String getIdCartao() {
                return this.idCartao;
        }

        public String getSituacao() {
                return this.situacao;
        }

        public LocalDateTime getDataEntrega() {
                return this.dataEntrega;
        }

        public String getObservacao() {
                return this.observacao;
        }

        public String getEndereco() {
                return this.endereco;
        }

        @JsonProperty("tracking_id")
        public void setIdCartao(String idCartao) {
                this.idCartao = idCartao;
        }

        @JsonProperty("delivery_status")
        public void setSituacao(String situacao) {
                this.situacao = situacao;
        }

        @JsonProperty("delivery_status")
        public void setDataEntrega(LocalDateTime dataEntrega) {
                this.dataEntrega = dataEntrega;
        }

        @JsonProperty("delivery_status")
        public void setObservacao(String observacao) {
                this.observacao = observacao;
        }

        @JsonProperty("delivery_status")
        public void setEndereco(String endereco) {
                this.endereco = endereco;
        }
}
