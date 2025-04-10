package util;

import br.com.h3pro.domain.Cartao;
import br.com.h3pro.domain.Cliente;
import br.com.h3pro.domain.Pedido;
import br.com.h3pro.domain.dto.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MockTests {

    public final static CartaoDTO cartaoDTO() {

        return new CartaoDTO(
                "1",
                "1234567812345678",
                123,
                LocalDate.now().plusYears(3),
                "Helio da Silva",
                "12345678901",
                1
        );
    }
    public final static ClienteDTO clienteDTO() {

        return new ClienteDTO(
                "12345678901",
                "Helio da Silva",
                LocalDate.of(1975, 5, 15),
                "11987654321",
                "helio.silva@gmail.com",
                "01234567",
                "SP",
                "Sao Paulo",
                "Centro",
                "Rua Franca",
                "100",
                "Ap. 101"
        );
    }

        public final static NovoCVVDTO novoCVVDTO() {

            return new NovoCVVDTO(
                    "12345678901",
                    12L,
                    456,
                    LocalDate.now().plusYears(3)
            );


        }

        public final static PedidoDTO PedidoDTO() {

            return new PedidoDTO(
                    12L,
                    "EM_PROCESSAMENTO",
                    LocalDateTime.now().plusDays(33),
                    "Ficou na portaria",
                    "Rua Franca 100, Apto 101"
            );


        }

        public final static SolicitacaoCartaoDTO solicitacaoCartaoDTO(Boolean eDigital) {

            return new SolicitacaoCartaoDTO(
                    "12345678901",
                    eDigital
            );


        }

        public final static Cartao cartao(Boolean eDigital, Boolean eCancelado) {

            return new Cartao(
                    12L,
                    "1234567812345678",
                    138,
                    "Helio Silva",
                    "12345678901",
                    eDigital,
                    eCancelado,
                    false,
                    null,
                    LocalDate.now().plusYears(3),
                    1,
                    LocalDateTime.now(),
                    null
            );


        }

        public final static Cliente cliente() {

            Cliente cliente = new Cliente();
            cliente.setCpf("12345678901");
            cliente.setNome("Helio Silva");
            cliente.setDataNascimento(LocalDate.of(1975, 5, 15));
            cliente.setTelefone("11987654321");
            cliente.setEmail("helio.silva@gmail.com");
            cliente.setCep("01234567");
            cliente.setUf("SP");
            cliente.setCidade("São Paulo");
            cliente.setBairro("Centro");
            cliente.setLogradouro("Rua Franca");
            cliente.setNumero("100");
            cliente.setComplemento("Ap. 101");
            cliente.setAtivo(true);
            cliente.setDataCriacao(LocalDateTime.now());
            cliente.setDataAtualizacao(null);

            return cliente;

        }

        public final static Pedido pedido() {

            return new Pedido(
                    "81",
                    12L,
                    "ETREGUE",
                    "Ficou na portaria",
                    "Rua das Franca 100, Ap. 101",
                    LocalDateTime.now(),
                    null
            );


        }



}
