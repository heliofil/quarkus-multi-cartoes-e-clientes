package br.com.h3pro.mapper;

import br.com.h3pro.domain.Bandeira;
import br.com.h3pro.domain.Cartao;

import br.com.h3pro.domain.Pedido;
import br.com.h3pro.domain.dto.BandeiraDTO;
import br.com.h3pro.domain.dto.CartaoDTO;

import br.com.h3pro.domain.dto.PedidoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface CartaoMapper {

    @Mapping(source="id", target="id")
    @Mapping(source="numero", target="numero")
    @Mapping(source="cvv", target="cvv")
    @Mapping(source="validadeMes", target="validadeMes")
    @Mapping(source="validadeAno", target="validadeAno")
    @Mapping(source="nome", target="nome")
    @Mapping(source="cpf", target="cpf")
    @Mapping(source="badeira", target="badeira")
    CartaoDTO mapCartao(Cartao cartao);

    @Mapping(source="id", target="id")
    @Mapping(source="numero", target="numero")
    @Mapping(source="cvv", target="cvv")
    @Mapping(source="validadeMes", target="validadeMes")
    @Mapping(source="validadeAno", target="validadeAno")
    @Mapping(source="nome", target="nome")
    @Mapping(source="cpf", target="cpf")
    @Mapping(source="badeira", target="badeira")
    Cartao mapCartao(CartaoDTO cartaoDTO);

    @Mapping(source="codigo", target="codigo")
    @Mapping(source="nome", target="nome")
    Bandeira mapBandeira(BandeiraDTO bandeiraDTO);

    @Mapping(source="codigo", target="codigo")
    @Mapping(source="nome", target="nome")
    BandeiraDTO mapBandeira(Bandeira bandeira);

    @Mapping(source="idCartao", target="idCartao")
    @Mapping(source="situacao", target="situacao")
    @Mapping(source="dataEntrega", target="dataCriacao")
    @Mapping(source="observacao", target="observacao")
    @Mapping(source="endereco", target="endereco")
    Pedido mapPedido(PedidoDTO pedidoDTO);


}
