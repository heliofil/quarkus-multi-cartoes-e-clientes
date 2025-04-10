package br.com.h3pro.mapper;

import br.com.h3pro.domain.Cliente;
import br.com.h3pro.domain.dto.ClienteDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "cdi")
public interface ClienteMapper {

    @Mapping(source="cpf", target="cpf")
    @Mapping(source="nome", target="nome")
    @Mapping(source="dataNascimento", target="dataNascimento")
    @Mapping(source="telefone", target="telefone")
    @Mapping(source="email", target="email")
    @Mapping(source="cep", target="cep")
    @Mapping(source="uf", target="uf")
    @Mapping(source="cidade", target="cidade")
    @Mapping(source="bairro", target="bairro")
    @Mapping(source="logradouro", target="logradouro")
    @Mapping(source="numero", target="numero")
    @Mapping(source="complemento", target="complemento")
    Cliente mapCliente(ClienteDTO clenteDTO);

}
