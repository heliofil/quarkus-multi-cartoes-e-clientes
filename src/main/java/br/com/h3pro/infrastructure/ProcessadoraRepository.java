package br.com.h3pro.infrastructure;

import br.com.h3pro.domain.Cartao;
import br.com.h3pro.domain.dto.CartaoDTO;
import br.com.h3pro.domain.dto.SolicitacaoCartaoDTO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/cartao")
@RegisterRestClient
@Produces(MediaType.APPLICATION_JSON)
public interface ProcessadoraRepository {

    //Assumindo um fluxo aonde a emissao de um cartão passa de forma muito simplificada na Processadora que devolve os dados do cartao.
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    CartaoDTO solicitarCartao(SolicitacaoCartaoDTO solicitacaoCartao);

}
