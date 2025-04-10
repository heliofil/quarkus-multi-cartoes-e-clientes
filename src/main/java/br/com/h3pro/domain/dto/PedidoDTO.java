package br.com.h3pro.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class PedidoDTO {

        @JsonProperty("tracking_id")
        private Long idCartao;

        @JsonProperty("delivery_status")
        private String situacao;

        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
        @JsonProperty("delivery_date")
        private LocalDateTime dataEntrega;

        @JsonProperty("delivery_return_reason")
        private String observacao;

        @JsonProperty("delivery_address")
        private String endereco;

        public PedidoDTO() {
        }

        public PedidoDTO(long idCartao, String situacao, LocalDateTime dataEntrega, String observacao, String endereco) {
                this.idCartao = idCartao;
                this.situacao = situacao;
                this.dataEntrega = dataEntrega;
                this.observacao = observacao;
                this.endereco = endereco;
        }



        public long getIdCartao() {
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

        public void setIdCartao(long idCartao) {
                this.idCartao = idCartao;
        }

        public void setSituacao(String situacao) {
                this.situacao = situacao;
        }

        public void setDataEntrega(LocalDateTime dataEntrega) {
                this.dataEntrega = dataEntrega;
        }

        public void setObservacao(String observacao) {
                this.observacao = observacao;
        }

        public void setEndereco(String endereco) {
                this.endereco = endereco;
        }
}
